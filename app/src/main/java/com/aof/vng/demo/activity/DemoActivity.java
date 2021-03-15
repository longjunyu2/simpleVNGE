package com.aof.vng.demo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.aof.vng.core.event.SoundEvent;
import com.aof.vng.core.scene.background.animation.Animation;
import com.aof.vng.core.surface.VNGAdapter;
import com.aof.vng.core.surface.VNGSurface;
import com.aof.vng.demo.R;
import com.aof.vng.demo.data.BuildNekoScript;
import com.aof.vng.demo.data.DataBase;
import com.aof.vng.demo.utils.AssetsUtils;
import com.aof.vng.demo.view.OboTextView;

public class DemoActivity extends AppCompatActivity {

    private VNGAdapter mVNGAdapter;
    private DataBase mDataBase;
    private SoundPool mSoundPool;
    private int backgroundAudioId;
    private int backgroundAudioStreamId;
    private int extraAudioStreamId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // FullScreen
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        //初始化资源表
        mDataBase = new DataBase();
        mDataBase.initiate();

        //设置字体
        ((TextView) findViewById(R.id.text_dialog_info)).setTypeface(Typeface.createFromAsset(getAssets(), mDataBase.getPath(DataBase.TYPE_TTF, "GenJyuuGothicX-Bold")));
        ((TextView) findViewById(R.id.text_dialog_tag)).setTypeface(Typeface.createFromAsset(getAssets(), mDataBase.getPath(DataBase.TYPE_TTF, "GenJyuuGothicX-Heavy")));

        // 创建音频播放器
        AudioAttributes abs = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build();
        mSoundPool = new SoundPool.Builder()
                .setMaxStreams(10)
                .setAudioAttributes(abs)
                .build();
        mSoundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int i, int i1) {
                if (i1 != 0)
                    throw new RuntimeException("Sound played failed.");
                if (i == backgroundAudioId) {
                    backgroundAudioStreamId = soundPool.play(i, 1, 1, 1, -1, 1);
                } else {
                    extraAudioStreamId = soundPool.play(i, 1, 1, 1, 0, 1);
                }
            }
        });

        //配置VNGAdapter
        mVNGAdapter = new VNGAdapter() {
            @Override
            public void doDialogText(final String dialog) {
                OboTextView otv = findViewById(R.id.text_dialog_info);
                otv.drawTextObo(dialog);
            }

            @Override
            public void doDialogTag(final String tag) {
                TextView tv = findViewById(R.id.text_dialog_tag);
                ImageView iv = findViewById(R.id.image_name);

                Bitmap btm = AssetsUtils.getBitmapFromAssetsName(DemoActivity.this, mDataBase.getPath(DataBase.TYPE_ICON, tag));
                String str = (btm == null) ? tag : "";

                tv.post(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText(str);
                    }
                });

                iv.post(new Runnable() {
                    @Override
                    public void run() {
                        if (btm == null)
                            iv.setImageResource(0);
                        else
                            iv.setImageBitmap(btm);
                    }
                });
            }

            @Override
            public void doDialogVisibility(final boolean visible) {
                View v = findViewById(R.id.group_textbox);
                v.post(new Runnable() {
                    @Override
                    public void run() {
                        v.setVisibility((visible) ? View.VISIBLE : View.INVISIBLE);
                    }
                });
            }

            @Override
            public void doBackground(String name) {
                ImageView iv = findViewById(R.id.image_background);
                iv.post(new Runnable() {
                    @Override
                    public void run() {
                        iv.setImageBitmap(AssetsUtils.getBitmapFromAssetsName(DemoActivity.this, mDataBase.getPath(DataBase.TYPE_BG_IMAGE, name)));
                    }
                });
            }

            @Override
            public void doBackgroundAnimation(Animation animation) {
                //TODO:
            }

            @Override
            public void doBackgroundAudio(SoundEvent event) {
                if (backgroundAudioId != 0)
                    mSoundPool.stop(backgroundAudioStreamId);
                backgroundAudioId = mSoundPool.load(event.getSoundFile(), 0);
            }

            @Override
            public void doDialogueAudio(SoundEvent event) {
                if (extraAudioStreamId != 0)
                    mSoundPool.stop(extraAudioStreamId);
                mSoundPool.load(event.getSoundFile(), 0);
            }

            @Override
            public void doEnvironmentAudio(SoundEvent event) {
                if (extraAudioStreamId != 0)
                    mSoundPool.stop(extraAudioStreamId);
                mSoundPool.load(event.getSoundFile(), 0);
            }

        };

        //配置抽象层
        VNGSurface mVNGSurface = new VNGSurface(mVNGAdapter);

        //运行剧本
        BuildNekoScript.createNekoScript().playNext(mVNGSurface);

        // 测试
        /*mVNGAdapter.doDialogVisibility(false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mVNGAdapter.doDialogVisibility(true);
                mVNGAdapter.doBackground("店铺外观_白天_开店后");
                mVNGAdapter.doDialogTag("香草");
                mVNGAdapter.doDialogText("我太喜欢你了巧克力!");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mVNGAdapter.doDialogTag("巧克力");
                        mVNGAdapter.doDialogText("香草我也喜欢你！！！!");
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mVNGAdapter.doDialogVisibility(false);
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        mVNGAdapter.doBackground("店铺外观_晚上_开店后");
                                        new Handler().postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                mVNGAdapter.doBackground("店铺外观_晚上_熄灯_开店前");
                                                mVNGAdapter.doDialogVisibility(true);
                                                mVNGAdapter.doDialogText("");
                                                mVNGAdapter.doDialogTag("");
                                                new Handler().postDelayed(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        mVNGAdapter.doDialogTag("嘉祥");
                                                        mVNGAdapter.doDialogText("哼哼哼 啊啊啊啊啊啊啊啊啊啊啊啊啊!");
                                                    }
                                                }, 2000);
                                            }
                                        }, 2000);
                                    }
                                }, 2000);
                            }
                        }, 2000);
                    }
                }, 2000);
            }
        }, 2000);
         */
    }
}
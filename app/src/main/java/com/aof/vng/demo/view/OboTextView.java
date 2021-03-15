package com.aof.vng.demo.view;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class OboTextView extends AppCompatTextView {

    private String text;
    private Thread mThread;

    public OboTextView(@NonNull Context context) {
        super(context);
    }

    public OboTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public OboTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void drawTextObo(final String str) {
        this.text = str;
        if (mThread != null && !mThread.isInterrupted()) {
            mThread.interrupt();
            if (str.equals(""))
                OboTextView.this.post(new Runnable() {
                    @Override
                    public void run() {
                        OboTextView.this.setText("");
                    }
                });
        }
        mThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= text.length(); i++) {
                    long lastTime = System.currentTimeMillis();
                    int finalI = i;
                    OboTextView.this.post(new Runnable() {
                        @Override
                        public void run() {
                            OboTextView.this.setText(text.substring(0, finalI));
                        }
                    });
                    if (i == text.length())
                        return;
                    while (System.currentTimeMillis() - lastTime <= 50) {
                        if (Thread.interrupted())
                            return;
                    }
                }
            }
        });
        mThread.start();
    }
}

package com.aof.vng.core.surface;

import com.aof.vng.core.event.SoundEvent;
import com.aof.vng.core.event.TextEvent;
import com.aof.vng.core.event.VideoEvent;
import com.aof.vng.core.scene.background.animation.Animation;

public class VNGSurface implements Surface {

    private final static String TAG = "VNGSurface";
    private final VNGAdapter mVNGAdapter;

    public VNGSurface(VNGAdapter VNGAdapter) {
        this.mVNGAdapter = VNGAdapter;
    }

    @Override
    public void doText(TextEvent event) {
        if (event.getTextVisibility() == TextEvent.INVISIBLE) {
            mVNGAdapter.doDialogVisibility(false);
            return;
        } else
            mVNGAdapter.doDialogVisibility(true);
        mVNGAdapter.doDialogTag((event.getTextTitle() == null) ? "" : event.getTextTitle());
        mVNGAdapter.doDialogText((event.getTextInfo() == null) ? "" : event.getTextInfo());
    }

    @Override
    public void dispatchAudioEvent(SoundEvent event) {
        switch (event.getSoundType()) {
            case SoundEvent.TYPE_BGM:
                mVNGAdapter.doBackgroundAudio(event);
                break;
            case SoundEvent.TYPE_DIALOG:
                mVNGAdapter.doDialogueAudio(event);
                break;
            case SoundEvent.TYPE_ENV:
                mVNGAdapter.doEnvironmentAudio(event);
                break;
            default:
                throw new RuntimeException("SoundEvent has incorrect type.\n" + event.toString());
        }
    }

    @Override
    public void doVideo(VideoEvent event) {

    }

    @Override
    public void doBackgroundSwitch(String name) {
        mVNGAdapter.doBackground(name);
    }

    @Override
    public void doBackgroundAnimation(Animation animation) {
        mVNGAdapter.doBackgroundAnimation(animation);
    }
}

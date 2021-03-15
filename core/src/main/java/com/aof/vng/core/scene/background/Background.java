package com.aof.vng.core.scene.background;

import com.aof.vng.core.scene.background.animation.Animation;
import com.aof.vng.core.scene.common.ImagePlayable;
import com.aof.vng.core.surface.Image.ImageSurface;

public class Background implements ImagePlayable {

    private String resName;
    private Animation animation;

    public Background(String resName) {
        this.resName = resName;
    }

    public Background(String resName, Animation animation) {
        this.resName = resName;
        this.animation = animation;
    }

    public void setBackgroundResName(String resName) {
        this.resName = resName;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    @Override
    public void doPlay(ImageSurface surface) {
        if (animation == null) {
            surface.doBackgroundSwitch(resName);
        }
    }

    @Override
    public void stopPlay(ImageSurface surface) {
        //stub
    }

}

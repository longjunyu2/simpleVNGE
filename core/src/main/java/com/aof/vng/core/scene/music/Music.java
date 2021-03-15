package com.aof.vng.core.scene.music;

import com.aof.vng.core.event.SoundEvent;
import com.aof.vng.core.scene.common.SoundPlayable;
import com.aof.vng.core.surface.Sound.SoundSurface;

public class Music implements SoundPlayable {

    private String resName;
    private boolean loop;
    private int type;

    public Music(int type, boolean loop, String resName) {
        this.resName = resName;
        this.loop = loop;
        this.type = type;
    }

    @Override
    public void doPlay(SoundSurface surface) {
        surface.dispatchAudioEvent(new SoundEvent(loop, resName, type));
    }

    @Override
    public void stopPlay(SoundSurface surface) {
        //TODO:
    }
}

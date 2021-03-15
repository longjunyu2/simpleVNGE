package com.aof.vng.core.scene.common;

import com.aof.vng.core.surface.Sound.SoundSurface;

public interface SoundPlayable {

    void doPlay(SoundSurface surface);
    void stopPlay(SoundSurface surface);

}

package com.aof.vng.core.surface.Sound;

import com.aof.vng.core.event.SoundEvent;

public interface SoundSurface {

    /* 处理音频事件 */
    void dispatchAudioEvent(SoundEvent event);

}

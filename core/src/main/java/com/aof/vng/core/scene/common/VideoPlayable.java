package com.aof.vng.core.scene.common;

import com.aof.vng.core.surface.Video.VideoSurface;

public interface VideoPlayable {
    void doPlay(VideoSurface surface);
    void stopPlay(VideoSurface surface);
}

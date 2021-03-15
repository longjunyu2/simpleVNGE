package com.aof.vng.core.scene.common;

import com.aof.vng.core.surface.Image.ImageSurface;

public interface ImagePlayable {

    void doPlay(ImageSurface surface);
    void stopPlay(ImageSurface surface);

}

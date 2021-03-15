package com.aof.vng.core.surface.Image.common;

import com.aof.vng.core.scene.background.animation.Animation;

public interface BackgroundSurface {

    /* 显示背景 */
    void doBackgroundSwitch(String name);

    /* 显示背景动画 */
    void doBackgroundAnimation(Animation animation);

}

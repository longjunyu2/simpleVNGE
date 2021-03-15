package com.aof.vng.core.surface;

import com.aof.vng.core.event.SoundEvent;
import com.aof.vng.core.scene.background.animation.Animation;

public interface VNGAdapter {

    /* 实现文本框 */
    void doDialogText(final String dialog);

    /* 实现文本框标签 */
    void doDialogTag(final String tag);

    /* 实现文本框的显示与隐藏 */
    void doDialogVisibility(final boolean visible);

    /* 实现背景操作 */
    void doBackground(String name);

    /* 实现背景动画操作 */
    void doBackgroundAnimation(Animation animation);

    /* 播放背景音频 */
    void doBackgroundAudio(SoundEvent event);

    /* 播放对白音频 */
    void doDialogueAudio(SoundEvent event);

    /* 播放环境音频 */
    void doEnvironmentAudio(SoundEvent event);

}

package com.aof.vng.core.scene;

import com.aof.vng.core.scene.background.Background;
import com.aof.vng.core.scene.character.Character;
import com.aof.vng.core.scene.dialogue.Dialogue;
import com.aof.vng.core.scene.music.Music;
import com.aof.vng.core.scene.text.Text;
import com.aof.vng.core.surface.Surface;

public interface Scene {

    /* 播放场景 */
    void doPlay(Surface surface);

    /* 停止场景 */
    void stopPlay(Surface surface);

    /* 获取背景对象 */
    Background getBackground();

    /* 获取主角对象 */
    Character getCharacter();

    /* 获取对白对象 */
    Dialogue getDialogue();

    /* 获取音乐对象 */
    Music getMusic();

    /* 获取文本对象 */
    Text getText();

    /* 是否延迟执行 */
    boolean isDelayed();

    /* 获取延迟执行时间 */
    int getDelayedTime(int ms);

    /* 是否可等待 */
    boolean isPaused();

}

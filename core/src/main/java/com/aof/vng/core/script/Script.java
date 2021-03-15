package com.aof.vng.core.script;

import com.aof.vng.core.surface.Surface;

public interface Script {

    /* 播放下一个场景 */
    void playNext(Surface surface);

    /* 自动播放场景 */
    void autoPlay(Surface surface);

}

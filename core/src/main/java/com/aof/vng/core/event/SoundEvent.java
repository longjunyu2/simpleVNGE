package com.aof.vng.core.event;

public class SoundEvent implements Event {
    private final static String TAG = "SoundEvent";
    private final boolean loop;
    private final int soundType;
    private final String soundFile;

    public final static int TYPE_BGM = 1001;
    public final static int TYPE_DIALOG = 1002;
    public final static int TYPE_ENV = 1003;

    public SoundEvent(boolean loop, String soundPath, int soundType) {
        this.loop = loop;
        this.soundFile = soundPath;
        this.soundType = soundType;
    }

    public boolean isLoop() {
        return this.loop;
    }

    public int getSoundType() {
        return this.soundType;
    }

    public String getSoundFile() {
        return this.soundFile;
    }

    @Override
    public String toString() {
        return TAG +
                " isLoop: " + this.isLoop() +
                " soundFile: " + this.soundFile +
                " soundType: " + this.soundType;
    }

}

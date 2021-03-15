package com.aof.vng.core.event;

import androidx.annotation.NonNull;

import java.io.File;

public class VideoEvent implements Event {

    private final static String TAG = "VideoEvent";
    private final String videoFile;

    public VideoEvent(String videoPath) {
        this.videoFile = videoPath;
    }

    public String getVideoFile() {
        return this.videoFile;
    }

    @NonNull
    @Override
    public String toString() {
        return TAG +
                " videoFile: " + this.videoFile;
    }
}

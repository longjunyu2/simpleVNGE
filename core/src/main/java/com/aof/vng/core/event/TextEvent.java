package com.aof.vng.core.event;

import androidx.annotation.NonNull;

public class TextEvent implements Event {

    private final String textTitle;
    private final String textInfo;
    private final int textVisibility;

    public final static int VISIBLE = 1001;
    public final static int INVISIBLE = 1002;

    public TextEvent(String textTitle, String textInfo, int visible) {
        if (textTitle == null)
            this.textTitle = "";
        else
            this.textTitle = textTitle;
        if (textInfo == null)
            this.textInfo = "";
        else
            this.textInfo = textInfo;
        this.textVisibility = visible;
    }

    public TextEvent(String textInfo) {
        this(null, textInfo, VISIBLE);
    }

    public String getTextTitle() {
        return this.textTitle;
    }

    public String getTextInfo() {
        return this.textInfo;
    }

    public int getTextVisibility() {
        return this.textVisibility;
    }

    @NonNull
    @Override
    public String toString() {
        return "TextEvent" +
                " textTitle: " + this.textTitle +
                " textInfo: " + this.textInfo +
                " textVisibility: " + ((this.textVisibility == VISIBLE) ? "VISIBLE" : "INVISIBLE");
    }
}

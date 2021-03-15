package com.aof.vng.core.scene.text;

import com.aof.vng.core.event.TextEvent;
import com.aof.vng.core.scene.common.ImagePlayable;
import com.aof.vng.core.surface.Image.ImageSurface;

public class Text implements ImagePlayable {

    private String textInfo;
    private String textTitle;
    private int visible;

    public Text(String textTitle, String textInfo, int visible) {
        this.textTitle = textTitle;
        this.textInfo = textInfo;
        this.visible = visible;
    }

    public Text(String textTitle, String textInfo) {
        this(textTitle, textInfo, TextEvent.VISIBLE);
    }

    @Override
    public void doPlay(ImageSurface surface) {
        surface.doText(new TextEvent(textTitle, textInfo, visible));
    }

    @Override
    public void stopPlay(ImageSurface surface) {
        //TODO:
    }
}

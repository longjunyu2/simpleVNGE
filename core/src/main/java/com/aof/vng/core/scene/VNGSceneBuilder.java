package com.aof.vng.core.scene;

import com.aof.vng.core.event.TextEvent;
import com.aof.vng.core.scene.background.Background;
import com.aof.vng.core.scene.background.animation.Animation;
import com.aof.vng.core.scene.character.Character;
import com.aof.vng.core.scene.dialogue.Dialogue;
import com.aof.vng.core.scene.music.Music;
import com.aof.vng.core.scene.text.Text;

public class VNGSceneBuilder {

    private boolean delayed;
    private boolean paused;
    private int delayTime;

    private Background mBackground;
    private Character mCharacter;
    private Dialogue mDialogue;
    private Music mMusic;
    private Text mText;

    public VNGSceneBuilder addBackground(String resName, Animation bgAnimation) {
        this.mBackground = new Background(resName, bgAnimation);
        return this;
    }

    public VNGSceneBuilder addCharacter() {
        //TODO:
        return this;
    }

    public VNGSceneBuilder addDialogue(String resName) {
        //TODO:
        return this;
    }

    public VNGSceneBuilder addMusic(int type, boolean loop, String resName) {
        this.mMusic = new Music(type, loop, resName);
        return this;
    }

    public VNGSceneBuilder addText(String title, String info, boolean visible) {
        this.mText = new Text(title, info, (visible) ? TextEvent.VISIBLE : TextEvent.INVISIBLE);
        return this;
    }

    public VNGSceneBuilder setConfig(boolean delayed, int delayedTime, boolean paused) {
        this.delayed = delayed;
        this.delayTime = delayedTime;
        this.paused = paused;
        return this;
    }

    public Scene build() {
        return new VNGScene(mBackground, mCharacter, mDialogue, mMusic, mText, delayed, delayTime, paused);
    }

}

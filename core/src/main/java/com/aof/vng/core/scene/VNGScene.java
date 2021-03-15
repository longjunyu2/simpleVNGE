package com.aof.vng.core.scene;

import android.util.Log;

import com.aof.vng.core.scene.background.Background;
import com.aof.vng.core.scene.character.Character;
import com.aof.vng.core.scene.common.ImagePlayable;
import com.aof.vng.core.scene.common.SoundPlayable;
import com.aof.vng.core.scene.dialogue.Dialogue;
import com.aof.vng.core.scene.music.Music;
import com.aof.vng.core.scene.text.Text;
import com.aof.vng.core.surface.Surface;

public class VNGScene implements Scene {

    private final static String TAG = "Scene";
    private final Background mBackground;
    private final Character mCharacter;
    private final Dialogue mDialogue;
    private final Music mMusic;
    private final Text mText;

    private boolean delayed;
    private boolean paused;
    private int delayedTime;

    public VNGScene(Background bg, Character ca, Dialogue dl, Music mc, Text tx) {
        this(bg, ca, dl, mc, tx, false, 0, true);
    }

    public VNGScene(Background bg, Character ca, Dialogue dl, Music mc, Text tx, boolean delayed, int delayedTime, boolean paused) {
        mBackground = bg;
        mCharacter = ca;
        mDialogue = dl;
        mMusic = mc;
        mText = tx;
        this.delayedTime = delayedTime;
        this.delayed = delayed;
        this.paused = paused;
    }

    @Override
    public void doPlay(Surface surface) {
        try {
            for (ImagePlayable ip : new ImagePlayable[]{mBackground, mCharacter, mText}) {
                if (ip != null)
                    ip.doPlay(surface);
            }
            for (SoundPlayable sp : new SoundPlayable[]{mDialogue, mMusic}) {
                if (sp != null)
                    sp.doPlay(surface);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            Log.e(TAG, "The scene has not been fully initialized.");
        }
    }

    @Override
    public void stopPlay(Surface surface) {
        try {
            for (ImagePlayable ip : new ImagePlayable[]{mBackground, mCharacter, mText}) {
                if (ip != null)
                    ip.stopPlay(surface);
            }
            for (SoundPlayable sp : new SoundPlayable[]{mDialogue, mMusic}) {
                if (sp != null)
                    sp.stopPlay(surface);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            Log.e(TAG, "The scene has not been fully initialized.");
        }
    }

    @Override
    public Background getBackground() {
        return this.mBackground;
    }

    @Override
    public Character getCharacter() {
        return this.mCharacter;
    }

    @Override
    public Dialogue getDialogue() {
        return this.mDialogue;
    }

    @Override
    public Music getMusic() {
        return this.mMusic;
    }

    @Override
    public Text getText() {
        return this.mText;
    }

    @Override
    public boolean isDelayed() {
        return this.delayed;
    }

    @Override
    public int getDelayedTime(int ms) {
        return delayedTime;
    }

    @Override
    public boolean isPaused() {
        return paused;
    }

    public void setDelayedTime(int ms) {
        this.delayedTime = ms;
    }

    public void setDelayed(boolean delayed) {
        this.delayed = delayed;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

}

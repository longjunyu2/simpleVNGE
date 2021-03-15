package com.aof.vng.core.script;

import com.aof.vng.core.scene.Scene;
import com.aof.vng.core.surface.Surface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VNGScript implements Script {

    private final ArrayList<Scene> mScenes;
    private int currentIndex = 0;
    private Scene currentScene;

    private VNGScript(List<Scene> scenes){
        this.mScenes = new ArrayList<>(scenes);
    }

    public static VNGScript create(List<Scene> scenes) {
        return new VNGScript(scenes);
    }

    public static VNGScript create(Scene[] scenes) {
        return new VNGScript(Arrays.asList(scenes));
    }


    @Override
    public void playNext(Surface surface) {
        if (currentIndex < mScenes.size())
            currentScene = mScenes.get(currentIndex++);
        currentScene.doPlay(surface);
    }

    @Override
    public void autoPlay(Surface surface) {
        //TODO:
    }

}

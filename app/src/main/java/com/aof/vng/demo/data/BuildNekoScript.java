package com.aof.vng.demo.data;

import com.aof.vng.core.scene.Scene;
import com.aof.vng.core.scene.VNGSceneBuilder;
import com.aof.vng.core.script.Script;
import com.aof.vng.core.script.VNGScript;

import java.util.ArrayList;

public class BuildNekoScript {

    public static Script createNekoScript(){
        ArrayList<Scene> scenes = new ArrayList<>();
        scenes.add(new VNGSceneBuilder()
                .addBackground("天空_白天", null)
                .addDialogue(null)
                .addCharacter()
                .addText("搬家公司", "「多谢惠顾！那我们就先告辞啦！」",true)
                .setConfig(false, 0, true)
                .build());
        return VNGScript.create(scenes);
    }

}

package com.jak.flappy.factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * Created by manu on 3/20/14.
 */
public class LibgdxFactory {
    public static BitmapFont createFont(String fntPng, String fntFnt, String fntPath) {
        String path = fntPath == "" ? "" : fntPath + "/";
        String fntPngPath = path + fntPng;
        String fntFntPath = path + fntFnt;
        return new BitmapFont(Gdx.files.internal(fntFntPath),Gdx.files.internal(fntPngPath),false);
    }
}

package com.jak.flappy.component.graphic;

import com.artemis.Component;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by manu on 08/03/14.
 */
public class BitmapFontComponent extends Component implements Disposable {
    private final BitmapFont font;

    public BitmapFontComponent(String fntPng, String fntFnt, String fntPath) {
        String path = fntPath == "" ? "" : fntPath + "/";
        String fntPngPath = path + fntPng;
        String fntFntPath = path + fntFnt;
        font = new BitmapFont(Gdx.files.internal(fntFntPath),Gdx.files.internal(fntPngPath),false);
    }

    public BitmapFont getFont() {
        return font;
    }

    @Override
    public void dispose() {
        font.dispose();
    }
}

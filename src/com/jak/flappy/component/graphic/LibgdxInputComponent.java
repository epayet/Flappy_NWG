package com.jak.flappy.component.graphic;

import com.badlogic.gdx.Gdx;
import com.jak.flappy.component.InputComponent;

/**
 * Created by manu on 08/03/14.
 */
public class LibgdxInputComponent extends InputComponent{
    @Override
    public boolean isKeyPressed(int key) {
        return Gdx.input.isKeyPressed(key);
    }
}

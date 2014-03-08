package com.jak.flappy.component.graphic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.jak.flappy.component.InputComponent;

/**
 * Created by manu on 08/03/14.
 */
public class LibgdxInputComponent extends InputComponent{
    @Override
    public boolean isKeyPressed(int key) {
        return Gdx.input.isKeyPressed(key);
    }

    @Override
    public float getAccelerometerY() {
        return Gdx.input.getAccelerometerY();
    }

    @Override
    public boolean isAccelerometerAvailable() {
        return Gdx.input.isPeripheralAvailable(Input.Peripheral.Accelerometer);
    }

    @Override
    public boolean isTouched() {
        return Gdx.input.isTouched();
    }
}

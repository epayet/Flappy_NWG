package com.jak.flappy.component.mock;

import com.jak.flappy.component.InputComponent;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by manu on 3/7/14.
 */
public class MockInputComponent extends InputComponent {
    private int keyPressed;
    private float accelerometerY;
    private boolean accelerometerAvailable;

    public MockInputComponent() {
        accelerometerY = 0;
    }

    public void setInput(int key) {
        keyPressed = key;
    }

    @Override
    public boolean isKeyPressed(int key) {
        return keyPressed == key;
    }

    public void setAccelerometerY(float y) {
        accelerometerAvailable = true;
        this.accelerometerY = y;
    }

    @Override
    public float getAccelerometerY() {
        return accelerometerY;
    }

    @Override
    public boolean isAccelerometerAvailable() {
        return accelerometerAvailable;
    }
}

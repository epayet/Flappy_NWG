package com.jak.flappy.manager.input;

/**
 * Created by manu on 3/7/14.
 */
public class MockInputManager extends InputManager {
    private int keyPressed;
    private int keyUpped;
    private float accelerometerY;
    private boolean accelerometerAvailable;
    private boolean touched;
    private boolean touchedUp;

    public MockInputManager() {
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

    public void setTouched(boolean touched) {
        this.touched = touched;
    }

    @Override
    public boolean isTouched() {
        return touched;
    }

    @Override
    public boolean isTouchedUp() {
        return touchedUp;
    }

    @Override
    public boolean isKeyUp(int key) {
        return keyUpped == key;
    }

    @Override
    public void reset() {

    }

    public void setKeyUp(int key) {
        this.keyUpped = key;
    }

    public void setTouchedUp(boolean touchedUp) {
        this.touchedUp = touchedUp;
    }
}

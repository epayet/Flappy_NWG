package com.jak.flappy.component;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by manu on 3/7/14.
 */
public class MockInputComponent extends InputComponent {
    private int keyPressed;

    public MockInputComponent() {
        super();
    }

    public void setInput(int key) {
        keyPressed = key;
    }

    @Override
    public boolean isPressed(int key) {
        return keyPressed == key;
    }
}

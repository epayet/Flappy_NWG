package com.jak.flappy.component;

import com.artemis.Component;

/**
 * Created by manu on 05/04/14.
 */
public class SizeComponent extends Component {
    private int width;
    private int height;

    public SizeComponent(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

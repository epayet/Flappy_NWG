package com.jak.flappy.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.jak.flappy.FlappyGame;

/**
 * Created by manu on 2/20/14.
 */
public class DesktopStarter {
    public static void main(String[] args) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "Flappy Ninja With Glasses";
        cfg.useGL20 = true;
        cfg.width = 800;
        cfg.height = 600;
        new LwjglApplication(new FlappyGame(), cfg);
    }
}

package com.jak.flappy;

import com.artemis.Entity;
import com.artemis.World;
import com.jak.flappy.component.RectangleComponent;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by manu on 3/5/14.
 */
public class FlappyGameTest extends TestCase {
    private World world;

    @Before
    public void setUp() throws Exception {
        world = new World();
        world.initialize();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void createNinja_CheckIsInTheMiddle() {
        Entity ninja = world.createEntity();
        ninja.addComponent(new RectangleComponent(0, 0, 0, 0));
    }
}

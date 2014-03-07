package com.jak.flappy.system;

import com.artemis.Entity;
import com.artemis.World;
import com.jak.flappy.component.CameraComponent;
import com.jak.flappy.component.MockCameraComponent;
import junit.framework.TestCase;
import org.junit.Before;

/**
 * Created by manu on 3/7/14.
 */
public class TestCameraSystem extends TestCase {
    private World world;

    @Before
    public void setUp() {
        world = new World();
        world.initialize();
        world.setSystem(new CameraSystem());

        Entity camera = world.createEntity();
        camera.addComponent(new MockCameraComponent(800, 600));
    }

    public void testUpdateCamera_EverySFine() {
        world.process();

        assertTrue("Everything shloud be ok", true);
    }
}

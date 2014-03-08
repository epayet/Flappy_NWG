package com.jak.flappy.system;

import com.artemis.Entity;
import com.artemis.World;
import com.badlogic.gdx.Input;
import com.jak.flappy.component.mock.MockInputComponent;
import com.jak.flappy.component.RectangleComponent;
import com.jak.flappy.component.VelocityComponent;
import com.jak.flappy.system.mock.MockInputSystem;
import com.jak.flappy.system.mock.MockVelocitySystem;
import junit.framework.TestCase;
import org.junit.Before;

/**
 * Created by manu on 3/6/14.
 */
public class TestInputSystem extends TestCase {
    private World world;
    private Entity ninja;
    private MockInputComponent mockInput;

    @Before
    public void setUp() throws Exception {
        world = new World();
        world.initialize();
        world.setSystem(new MockInputSystem());
        world.setSystem(new MockVelocitySystem());

        ninja = world.createEntity();
        ninja.addComponent(new RectangleComponent(50, 60, 50, 50));
        ninja.addComponent(new VelocityComponent());
        mockInput = new MockInputComponent();
        ninja.addComponent(mockInput);
        ninja.addToWorld();
    }

    public void testNinjaMoveRight_WithKeyboard() {
        mockInput.setInput(Input.Keys.RIGHT);
        world.setDelta(50);

        world.process();

        RectangleComponent rectangle = ninja.getComponent(RectangleComponent.class);
        assertEquals(rectangle.getY(), 60f);
        assertTrue(rectangle.getX() > 50f);
    }

    public void testNinjaMoveLeft_WithKeyboard() {
        mockInput.setInput(Input.Keys.LEFT);
        world.setDelta(50);

        world.process();

        RectangleComponent rectangle = ninja.getComponent(RectangleComponent.class);
        assertEquals(rectangle.getY(), 60f);
        assertTrue(rectangle.getX() < 50f);
    }

    public void testNinjaMoveRight_WithAccelerometer() {
        mockInput.setAccelerometerY(10);
        world.setDelta(50);

        world.process();

        RectangleComponent rectangle = ninja.getComponent(RectangleComponent.class);
        assertEquals(rectangle.getY(), 60f);
        assertTrue("Should be more than 50, value : " + rectangle.getX(), rectangle.getX() > 50f);
    }
}

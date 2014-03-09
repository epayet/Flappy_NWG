package com.jak.flappy.system;

import com.artemis.Entity;
import com.artemis.World;
import com.badlogic.gdx.math.Rectangle;
import com.jak.flappy.component.*;
import com.jak.flappy.component.graphic.LibgdxCameraComponent;
import com.jak.flappy.component.mock.MockCameraComponent;
import com.jak.flappy.system.mock.MockVelocitySystem;
import junit.framework.TestCase;
import org.junit.Before;

/**
 * Created by manu on 3/6/14.
 */
public class TestVelocitySystem extends TestCase {
    private World world;
    private Entity ninja;
    private VelocityComponent velocity;
    private RectangleComponent rectangle;

    @Before
    public void setUp() throws Exception {
        world = new World();
        world.initialize();
        world.setSystem(new MockVelocitySystem());

        ninja = world.createEntity();
        velocity = new VelocityComponent();
        ninja.addComponent(velocity);
        rectangle = new RectangleComponent();
        ninja.addComponent(rectangle);
        ninja.addToWorld();
    }

    public void testAddNoVelocity_DoesntMove() {
        rectangle.setRectangle(new Rectangle(50, 60, 50, 50));

        world.process();

        assertEquals(50f, rectangle.getX());
        assertEquals(60f, rectangle.getY());
    }

    public void testAddVelocityX_XmoveYDoesnt() {
        rectangle.setRectangle(new Rectangle(50, 60, 50 ,50));
        velocity.setX(50);
        world.setDelta(50);

        world.process();

        assertEquals(60f, rectangle.getY());
        assertTrue(rectangle.getX() > 50f);
    }


    public void testVelocity_Circle() {
        Entity circle = world.createEntity();
        circle.addComponent(velocity);
        velocity.setY(-50);
        CircleComponent circleComponent = new CircleComponent(10, 10, 10);
        circle.addComponent(circleComponent);
        circle.addToWorld();
        world.setDelta(50);

        world.process();

        assertTrue("Value should be less than 10, value : " + circleComponent.getY(), circleComponent.getY() < 10);
    }
}

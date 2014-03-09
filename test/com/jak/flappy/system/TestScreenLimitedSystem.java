package com.jak.flappy.system;

import com.artemis.Entity;
import com.artemis.World;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.jak.flappy.component.CircleComponent;
import com.jak.flappy.component.RectangleComponent;
import com.jak.flappy.component.StayInScreenComponent;
import com.jak.flappy.component.VelocityComponent;
import com.jak.flappy.component.mock.MockCameraComponent;
import com.jak.flappy.system.mock.MockScreenLimitedSystem;
import com.jak.flappy.system.mock.MockVelocitySystem;
import junit.framework.TestCase;
import org.junit.Before;

/**
 * Created by manu on 09/03/14.
 */
public class TestScreenLimitedSystem extends TestCase {
    private World world;
    private RectangleComponent rectangle;
    private Entity ninja;
    private VelocityComponent velocity;
    private Entity flappy;
    private CircleComponent circle;

    @Before
    public void setUp() {
        world = new World();
        world.initialize();
        world.setSystem(new MockVelocitySystem());
        world.setSystem(new MockScreenLimitedSystem());

        MockCameraComponent cameraComponent = new MockCameraComponent(800, 600);

        ninja = world.createEntity();
        velocity = new VelocityComponent();
        ninja.addComponent(velocity);
        rectangle = new RectangleComponent();
        ninja.addComponent(rectangle);
        ninja.addComponent(cameraComponent);
        ninja.addToWorld();

        flappy = world.createEntity();
        flappy.addComponent(velocity);
        circle = new CircleComponent();
        flappy.addComponent(circle);
        flappy.addComponent(cameraComponent);
        flappy.addToWorld();
    }

    public void test_ScreenLimited_AddVelocityX_LimitedBy0() {
        ninja.addComponent(new StayInScreenComponent());
        rectangle.setRectangle(new Rectangle(0.1f, 20, 50 ,50));
        velocity.setX(-50);
        world.setDelta(50);

        world.process();

        assertEquals(0f, rectangle.getX());
        assertEquals(20f, rectangle.getY());
    }

    public void test_NoScreenLimited_AddVelocityX_IsNegative() {
        rectangle.setRectangle(new Rectangle(0.1f, 60, 50 ,50));
        velocity.setX(-50);
        world.setDelta(50);

        world.process();

        assertTrue(rectangle.getX() < 0f);
        assertEquals(60f, rectangle.getY());
    }

    public void testScreenLimited_Y() {
        rectangle.setRectangle(new Rectangle(50, 0.1f, 50 ,50));
        ninja.addComponent(new StayInScreenComponent());
        velocity.setY(-60);
        world.setDelta(50);

        world.process();

        assertEquals(50f, rectangle.getX());
        assertEquals(0f, rectangle.getY());
    }

    public void testScreenLimited_StayInsideCameraX() {
        rectangle.setRectangle(new Rectangle(89, 60, 10 ,50));
        ninja.addComponent(new StayInScreenComponent());
        velocity.setX(50);
        velocity.setY(50);
        world.setDelta(50);

        world.process();

        assertEquals(790f, rectangle.getX());
        assertEquals(550f, rectangle.getY());
    }

    public void testScreenLimitedCircle() {
        circle.setCircle(new Circle(10, 50, 10));
        flappy.addComponent(new StayInScreenComponent());
        velocity.setX(-50);
        velocity.setY(-50);
        world.setDelta(50);

        world.process();

        assertEquals(10f, circle.getX());
        assertEquals(10f, circle.getY());
    }

    public void testScreenLimited_Circle_Camera() {
        circle.setCircle(new Circle(10, 50, 10));
        flappy.addComponent(new StayInScreenComponent());
        velocity.setX(50);
        velocity.setY(50);
        world.setDelta(50);

        world.process();

        assertEquals(790f, circle.getX());
        assertEquals(590f, circle.getY());
    }
}

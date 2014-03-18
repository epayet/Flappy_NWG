package system;

import com.artemis.Entity;
import com.artemis.World;
import com.jak.flappy.component.RectangleComponent;
import com.jak.flappy.component.StayInScreenComponent;
import com.jak.flappy.component.VelocityComponent;
import com.jak.flappy.system.VelocitySystem;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;

/**
 * Created by manu on 3/6/14.
 */
public class TestVelocitySystem extends TestCase {
    private World world;
    private Entity ninja;
    private VelocityComponent velocity;

    @Before
    public void setUp() throws Exception {
        world = new World();
        world.initialize();
        world.setSystem(new VelocitySystem());

        ninja = world.createEntity();
        ninja.addComponent(new VelocityComponent());
        velocity = ninja.getComponent(VelocityComponent.class);
        ninja.addToWorld();
    }

    @After
    public void tearDown() throws Exception {

    }

    public void testAddNoVelocity_DoesntMove() {
        ninja.addComponent(new RectangleComponent(50 ,60, 50 , 50));

        world.process();

        RectangleComponent rectangle = ninja.getComponent(RectangleComponent.class);
        assertEquals(50f, rectangle.getX());
        assertEquals(60f, rectangle.getY());
    }

    public void testAddVelocityX_XmoveYDoesnt() {
        ninja.addComponent(new RectangleComponent(50 ,60, 50 , 50));
        velocity.setX(50);
        world.setDelta(50);

        world.process();

        RectangleComponent rectangle = ninja.getComponent(RectangleComponent.class);
        assertEquals(60f, rectangle.getY());
        assertTrue(rectangle.getX() > 50f);
    }

    public void test_ScreenLimited_AddVelocityX_LimitedBy0() {
        ninja.addComponent(new StayInScreenComponent());
        ninja.addComponent(new RectangleComponent(0.1f, 60, 50 , 50));
        velocity.setX(-50);
        world.setDelta(50);

        world.process();

        RectangleComponent rectangle = ninja.getComponent(RectangleComponent.class);
        assertEquals(0f, rectangle.getX());
        assertEquals(60f, rectangle.getY());
    }

    public void test_NoScreenLimited_AddVelocityX_IsNegative() {
        ninja.addComponent(new RectangleComponent(0.1f, 60, 50 , 50));
        velocity.setX(-50);
        world.setDelta(50);

        world.process();

        RectangleComponent rectangle = ninja.getComponent(RectangleComponent.class);
        assertTrue(rectangle.getX() < 0f);
        assertEquals(60f, rectangle.getY());
    }
}

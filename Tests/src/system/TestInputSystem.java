package system;

import com.artemis.Entity;
import com.artemis.World;
import com.badlogic.gdx.Gdx;
import com.jak.flappy.component.GravityComponent;
import com.jak.flappy.component.RectangleComponent;
import com.jak.flappy.component.VelocityComponent;
import com.jak.flappy.system.GravitySystem;
import com.jak.flappy.system.VelocitySystem;
import junit.framework.TestCase;
import org.junit.Before;

/**
 * Created by manu on 3/6/14.
 */
public class TestInputSystem extends TestCase {
    private World world;
    private Entity ninja;

    @Before
    public void setUp() throws Exception {
        world = new World();
        world.initialize();
        world.setSystem(new GravitySystem());
        world.setSystem(new VelocitySystem());

        ninja = world.createEntity();
        ninja.addComponent(new RectangleComponent(50 ,60, 50 , 50));
        ninja.addComponent(new VelocityComponent());
        ninja.addComponent(new GravityComponent(10));
        ninja.addToWorld();
    }

    public void testMoveRight() {
        if(Gdx.input.isTouched()) {

        }

    }
}

package com.jak.flappy.system;

import com.artemis.World;
import com.artemis.managers.GroupManager;
import com.jak.flappy.Constants;
import com.jak.flappy.component.mock.MockCameraComponent;
import junit.framework.TestCase;
import org.junit.Before;

/**
 * Created by manu on 08/03/14.
 */
public class TestSpawnFlappySystem extends TestCase {
    private World world;

    @Before
    public void setUp() {
        world = new World();
        world.initialize();
        world.setSystem(new SpawnFlappySystem(new MockCameraComponent(10, 10)));
        world.setManager(new GroupManager());
    }

    public void testProcessFewSavagesFlappyAppeared() throws InterruptedException {
        world.process();

        assertEquals(1, world.getManager(GroupManager.class).getEntities(Constants.GROUP_FLAPPY).size());
    }
}

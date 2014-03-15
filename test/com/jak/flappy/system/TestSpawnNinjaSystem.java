package com.jak.flappy.system;

import com.artemis.Component;
import com.artemis.World;
import com.artemis.managers.GroupManager;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ObjectMap;
import com.jak.flappy.Constants;
import com.jak.flappy.component.graphic.ShapeRendererComponent;
import com.jak.flappy.component.mock.MockCameraComponent;
import junit.framework.TestCase;
import org.junit.Before;

/**
 * Created by manu on 08/03/14.
 */
public class TestSpawnNinjaSystem extends TestCase {
    private World world;

    @Before
    public void setUp() {
        world = new World();
        world.initialize();
        ObjectMap<String, Component> reusableComponents = new ObjectMap<String, Component>();
        reusableComponents.put(Constants.COMPONENT_CAMERA, new MockCameraComponent(10, 10));
        reusableComponents.put(Constants.COMPONENT_SHAPERENDERER, new ShapeRendererComponent(false));
        world.setSystem(new SpawnNinjaSystem(reusableComponents));
        world.setManager(new GroupManager());
    }

    public void testProcessFewSavagesNinjaAppeared() throws InterruptedException {
        world.getSystem(SpawnNinjaSystem.class).processEntities(null);

        assertEquals(1, world.getManager(GroupManager.class).getEntities(Constants.GROUP_FLAPPY).size());
    }
}

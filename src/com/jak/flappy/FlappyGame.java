package com.jak.flappy;

import com.artemis.managers.GroupManager;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.jak.flappy.factory.EntityFactory;
import com.jak.flappy.system.*;
import com.jak.flappy.system.MovingFlappySystem;
import com.jak.flappy.system.death.CheckDeathSystem;
import com.jak.flappy.system.death.ShowDeathSystem;
import com.jak.flappy.system.death.UpdateShowReplayButton;
import com.jak.flappy.system.ninja.DeleteNinjaSystem;
import com.jak.flappy.system.ninja.SpawningNinjaSystem;
import com.jak.flappy.system.physics.ContactSystem;
import com.jak.flappy.system.physics.UpdatePositionComponent;
import com.jak.flappy.system.score.ShowScoreSystem;
import com.jak.flappy.system.score.UpdateScoreSystem;
import com.jak.flappy.system.ui.DrawButtonSystem;
import com.jak.flappy.world.FlappyWorld;

/**
 * Created by manu on 2/19/14.
 */
public class FlappyGame implements ApplicationListener {
    private FlappyWorld world;
    private FPSLogger fpsLogger;

    @Override
    public void create() {
        world = new FlappyWorld(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT);
        world.initialize();
        world.setManager(new GroupManager());
        world.setSystem(new PreparingSystem(world), false);
        world.setSystem(new ContactSystem(world), false);
        world.setSystem(new UpdatePositionComponent());
        world.setSystem(new MovingFlappySystem(world));
        world.setSystem(new SpawningNinjaSystem(0.5f));
        world.setSystem(new CheckDeathSystem());
        world.setSystem(new UpdateScoreSystem());
        world.setSystem(new ShowScoreSystem(world));
        world.setSystem(new DeleteNinjaSystem());
        world.setSystem(new ShowDeathSystem(world));
        world.setSystem(new UpdateShowReplayButton());
        world.setSystem(new DrawButtonSystem(world));
        //world.setSystem(new DebugInfoSystem(world));
        EntityFactory.createFlappy(world);
        EntityFactory.createGround(world);
        EntityFactory.createRoof(world);
        EntityFactory.createScore(world);
        EntityFactory.createReplayButton(world);

        //EntityFactory.createNinja(world);

        fpsLogger = new FPSLogger();
    }

    @Override
    public void render() {
        world.setDelta(Gdx.graphics.getDeltaTime());
        world.getSystem(PreparingSystem.class).process();
        world.getSystem(ContactSystem.class).process();
        world.process();

        //fpsLogger.log();
    }

    @Override
    public void resize(int i, int i2) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        world.dispose();
    }
}

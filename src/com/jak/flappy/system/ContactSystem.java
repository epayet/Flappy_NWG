package com.jak.flappy.system;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.jak.flappy.component.graphic.physics.ContactComponent;
import com.jak.flappy.manager.ContactManager;
import com.jak.flappy.world.FlappyWorld;

/**
 * Created by manu on 01/04/14.
 */
public class ContactSystem extends EntityProcessingSystem {
    @Mapper
    private ComponentMapper<ContactComponent> contactMapper;

    private final ContactManager contactManager;

    public ContactSystem(FlappyWorld flappyWorld) {
        super(Aspect.getAspectForAll(ContactComponent.class));
        contactManager = flappyWorld.getContactManager();
    }

    @Override
    protected void process(Entity entity) {
        ContactComponent contactComponent = contactMapper.get(entity);

        if(contactManager.hasCollided()) {
            Fixture fixture = contactManager.getFixtureB();
            String fixtureName = (String)fixture.getUserData();

            if(contactComponent.getName() == fixtureName) {
                contactComponent.setCollided(contactManager.getFixtureA());
            }
        }
        else {
            contactComponent.reset();
        }
    }
}

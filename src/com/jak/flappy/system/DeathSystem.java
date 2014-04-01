package com.jak.flappy.system;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.jak.flappy.component.FlappyComponent;
import com.jak.flappy.component.graphic.physics.ContactComponent;

/**
 * Created by manu on 01/04/14.
 */
public class DeathSystem extends EntityProcessingSystem {
    @Mapper
    private ComponentMapper<ContactComponent> contactMapper;

    public DeathSystem( ) {
        super(Aspect.getAspectForAll(ContactComponent.class, FlappyComponent.class));
    }

    @Override
    protected void process(Entity entity) {
        ContactComponent contact = contactMapper.get(entity);
        if(contact.hasCollided()) {
            Fixture collided = contact.getCollided();
            Gdx.app.log("contact", "beteween flappy and " + collided.getUserData());
        }
    }
}

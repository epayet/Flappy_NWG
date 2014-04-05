package com.jak.flappy.system.death;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.jak.flappy.Constants;
import com.jak.flappy.component.DeathComponent;
import com.jak.flappy.component.physics.ContactComponent;

/**
 * Created by manu on 01/04/14.
 */
public class CheckDeathSystem extends EntityProcessingSystem {
    @Mapper
    private ComponentMapper<ContactComponent> contactMapper;
    @Mapper
    private ComponentMapper<DeathComponent> deathMapper;

    public CheckDeathSystem() {
        super(Aspect.getAspectForAll(ContactComponent.class, DeathComponent.class));
    }

    @Override
    protected void process(Entity entity) {
        ContactComponent contact = contactMapper.get(entity);
        if(contact.hasCollided()) {
            Fixture collided = contact.getCollided();
            String collidedName = (String)collided.getUserData();
            if(collidedName == Constants.CONTACT_GROUND || collidedName == Constants.CONTACT_NINJA) {
                DeathComponent deathComponent = deathMapper.get(entity);
                deathComponent.setDeath(true);
            }
        }
    }
}

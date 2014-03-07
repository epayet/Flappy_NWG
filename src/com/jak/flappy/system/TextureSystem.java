package com.jak.flappy.system;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.jak.flappy.component.RectangleComponent;
import com.jak.flappy.component.TextureComponent;

/**
 * Created by manu on 3/7/14.
 */
public class TextureSystem extends EntityProcessingSystem{
    public TextureSystem() {
        super(Aspect.getAspectForAll(TextureComponent.class, RectangleComponent.class));
    }

    @Override
    protected void process(Entity entity) {

    }
}

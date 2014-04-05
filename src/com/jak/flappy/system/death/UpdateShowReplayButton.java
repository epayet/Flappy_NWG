package com.jak.flappy.system.death;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.jak.flappy.Constants;
import com.jak.flappy.component.ui.ButtonComponent;
import com.jak.flappy.component.ui.LabelComponent;
import com.jak.flappy.component.ui.ShowComponent;
import com.jak.flappy.world.FlappyWorldUtils;

/**
 * Created by manu on 05/04/14.
 */
public class UpdateShowReplayButton extends EntityProcessingSystem {

    @Mapper
    private ComponentMapper<ShowComponent> showComponentMapper;
    @Mapper
    private ComponentMapper<LabelComponent> labelComponentMapper;

    public UpdateShowReplayButton() {
        super(Aspect.getAspectForAll(ButtonComponent.class, ShowComponent.class, LabelComponent.class));
    }

    @Override
    protected void process(Entity entity) {
        LabelComponent labelComponent = labelComponentMapper.get(entity);
        ShowComponent showComponent = showComponentMapper.get(entity);

        if(labelComponent.getLabel().equals(Constants.BUTTON_REPLAY)) {
            showComponent.setShow(FlappyWorldUtils.isFlappyDead(world));
        }
    }
}

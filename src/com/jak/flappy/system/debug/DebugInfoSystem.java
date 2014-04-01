package com.jak.flappy.system.debug;

/**
 * Created by manu on 08/03/14.
 */
public class DebugInfoSystem { /*extends EntityProcessingSystem{
    @Mapper
    ComponentMapper<SpriteBatchComponent> spriteBatchMapper;
    @Mapper
    ComponentMapper<BitmapFontComponent> fontMapper;
    @Mapper
    ComponentMapper<DrawingComponent> drawingMapper;
    @Mapper
    ComponentMapper<LibgdxCameraComponent> cameraMapper;
    @Mapper
    ComponentMapper<LibgdxInputManager> inputMapper;

    public DebugInfoSystem() {
        super(Aspect.getAspectForAll(DebubInfoComponent.class));
    }

    @Override
    protected void process(Entity entity) {
        SpriteBatchComponent spriteBatchComponent = spriteBatchMapper.get(entity);
        SpriteBatch spriteBatch = spriteBatchComponent.getSpriteBatch();

        BitmapFontComponent fontComponent = fontMapper.get(entity);
        BitmapFont font = fontComponent.getFont();

        DrawingComponent drawingComponent = drawingMapper.get(entity);
        Color color = drawingComponent.getColor();

        CameraComponent camera = cameraMapper.get(entity);
        InputComponent input = inputMapper.get(entity);

        String debugStr = "acc : " + input.getAccelerometerY();
        font.setColor(color);

        spriteBatch.begin();
        font.draw(spriteBatch, debugStr, 10, camera.getHeight() - 10);
        spriteBatch.end();
    }*/
}

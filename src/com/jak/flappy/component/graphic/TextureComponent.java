package com.jak.flappy.component.graphic;

import com.artemis.Component;

/**
 * Created by manu on 3/7/14.
 */
public abstract class TextureComponent extends Component {
    protected String filePath;

    public TextureComponent(String filePath) {
        this.filePath = filePath;
    }
}

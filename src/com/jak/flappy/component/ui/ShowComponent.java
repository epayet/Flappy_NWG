package com.jak.flappy.component.ui;

import com.artemis.Component;

/**
 * Created by manu on 05/04/14.
 */
public class ShowComponent extends Component {
    private boolean show;

    public ShowComponent(boolean show) {
        this.show = show;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}

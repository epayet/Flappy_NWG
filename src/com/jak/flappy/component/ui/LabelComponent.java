package com.jak.flappy.component.ui;

import com.artemis.Component;

/**
 * Created by manu on 05/04/14.
 */
public class LabelComponent extends Component {
    private String label;

    public LabelComponent(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}

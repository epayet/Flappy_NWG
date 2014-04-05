package com.jak.flappy.component.util;

import com.artemis.Component;
import com.jak.flappy.util.Listener;

/**
 * Created by manu on 05/04/14.
 */
public class ListenerComponent extends Component {
    private Listener listener;

    public ListenerComponent(Listener listener) {
        this.listener = listener;
    }

    public void run() {
        listener.run();
    }
}

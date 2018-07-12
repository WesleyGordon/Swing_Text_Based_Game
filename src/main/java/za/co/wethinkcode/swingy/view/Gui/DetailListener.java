package za.co.wethinkcode.swingy.view.Gui;

import za.co.wethinkcode.swingy.view.Gui.DetailEvent;

import java.util.EventListener;

public interface DetailListener extends EventListener {
    public void detailEventOccurred(DetailEvent event);
}

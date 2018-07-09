package za.co.wethinkcode.swingy.view;

import java.util.EventListener;

public interface DetailListener extends EventListener {
    public void detailEventOccurred(DetailEvent event);
}

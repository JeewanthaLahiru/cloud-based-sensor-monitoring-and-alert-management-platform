package com.monitor.database.listen;

import com.monitor.database.configure.DatabaseListenerConfigurator;
import com.monitor.database.model.TempData;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;

public class TempDataRepositoryListener extends AbstractMongoEventListener<TempData> {

    @Override
    public void onBeforeSave(BeforeSaveEvent<TempData> event) {
        super.onBeforeSave(event);
        if (Integer.parseInt(event.getSource().getData_value()) > DatabaseListenerConfigurator.TEMP_THRESHOLD) {
            System.out.println("Saved");
        }
    }
}

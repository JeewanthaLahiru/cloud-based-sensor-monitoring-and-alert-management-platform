package com.monitor.database.listen;

import com.monitor.database.model.TempData;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;

public class TempDataRepositoryListener extends AbstractMongoEventListener<TempData> {

    @Override
    public void onBeforeSave(BeforeSaveEvent<TempData> event) {
        super.onBeforeSave(event);
        System.out.println("Saved");
    }
}

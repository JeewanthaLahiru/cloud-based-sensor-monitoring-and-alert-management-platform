package com.monitor.database.listen;

import com.monitor.database.configure.DatabaseListenerConfig;
import com.monitor.database.model.Notification;
import com.monitor.database.model.TempData;
import com.monitor.database.repository.NotificationReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;

public class TempDataRepositoryListener extends AbstractMongoEventListener<Notification> {

    @Autowired
    public TempDataRepositoryListener() {
    }


    @Override
    public void onBeforeSave(BeforeSaveEvent<Notification> event) {
        super.onBeforeSave(event);
        System.out.println("Hi");
        //implement user's notification notifying detail getting logic to display notification string
    }
}

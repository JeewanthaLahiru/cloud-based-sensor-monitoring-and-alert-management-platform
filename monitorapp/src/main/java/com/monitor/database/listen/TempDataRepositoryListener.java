package com.monitor.database.listen;

import com.monitor.database.configure.DatabaseListenerConfigurator;
import com.monitor.database.model.TempData;
import com.monitor.database.repository.NotificationReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;

public class TempDataRepositoryListener extends AbstractMongoEventListener<TempData> {

    private NotificationReactiveRepository notificationReactiveRepository;

    @Autowired
    public TempDataRepositoryListener(NotificationReactiveRepository notificationReactiveRepository) {
        this.notificationReactiveRepository = notificationReactiveRepository;
    }


    @Override
    public void onBeforeSave(BeforeSaveEvent<TempData> event) {
        super.onBeforeSave(event);

        if (Integer.parseInt(event.getSource().getData_value().substring(0,2)) > DatabaseListenerConfigurator.TEMP_THRESHOLD) {
            System.out.println(this.notificationReactiveRepository);
            System.out.println("Saved");
        }
    }
}

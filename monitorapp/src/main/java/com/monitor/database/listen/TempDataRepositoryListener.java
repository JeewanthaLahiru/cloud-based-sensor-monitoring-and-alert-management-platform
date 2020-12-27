package com.monitor.database.listen;

import com.monitor.database.configure.DatabaseListenerConfig;
import com.monitor.database.model.Notification;
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
        TempData tempData = event.getSource();
        if (Integer.parseInt(tempData.getData_value().substring(0,2)) > DatabaseListenerConfig.TEMP_THRESHOLD) {
            this.notificationReactiveRepository.save(new Notification(tempData.getDate(), tempData.getData_value().substring(0,2))).subscribe();
            System.out.println("\n\nYour current temperature exceeded the threshold value!!!\n\n");
        }
    }
}

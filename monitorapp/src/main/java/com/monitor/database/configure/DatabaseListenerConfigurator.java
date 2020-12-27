package com.monitor.database.configure;

import com.monitor.database.listen.TempDataRepositoryListener;
import com.monitor.database.repository.NotificationReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseListenerConfigurator {

    public static final int TEMP_THRESHOLD = 24;

    private NotificationReactiveRepository notificationReactiveRepository;

    @Autowired
    public DatabaseListenerConfigurator(NotificationReactiveRepository notificationReactiveRepository) {
        this.notificationReactiveRepository = notificationReactiveRepository;
    }

    @Bean
    public TempDataRepositoryListener tempDataRepositoryListener() {
        return new TempDataRepositoryListener(notificationReactiveRepository);
    }

}

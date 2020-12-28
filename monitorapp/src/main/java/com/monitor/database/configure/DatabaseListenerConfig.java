package com.monitor.database.configure;

import com.monitor.database.listen.TempDataRepositoryListener;
import com.monitor.database.repository.NotificationReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseListenerConfig {

    public static final int TEMP_THRESHOLD = 24;


    @Autowired
    public DatabaseListenerConfig() {
    }

    @Bean
    public TempDataRepositoryListener tempDataRepositoryListener() {
        return new TempDataRepositoryListener();
    }

}

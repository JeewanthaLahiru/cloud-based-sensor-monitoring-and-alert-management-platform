package com.monitor.database.configure;

import com.monitor.database.listen.TempDataRepositoryListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseListenerConfigurator {

    public static final int TEMP_THRESHOLD = 24;

    @Bean
    public TempDataRepositoryListener tempDataRepositoryListener() {
        return new TempDataRepositoryListener();
    }

}

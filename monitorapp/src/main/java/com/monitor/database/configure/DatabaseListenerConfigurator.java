package com.monitor.database.configure;

import com.monitor.database.listen.TempDataRepositoryListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseListenerConfigurator {

    @Bean
    public TempDataRepositoryListener tempDataRepositoryListener() {
        return new TempDataRepositoryListener();
    }

}

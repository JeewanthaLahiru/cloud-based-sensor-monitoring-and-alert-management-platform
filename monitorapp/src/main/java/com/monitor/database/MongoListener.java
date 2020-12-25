package com.monitor.database;

import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.stereotype.Component;

@Component
public class MongoListener extends AbstractMongoEventListener<Integer> {

    @Override
    public void onAfterSave(AfterSaveEvent<Integer> event) {
        System.out.println("Done");
    }

}
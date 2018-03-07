package com.fit.room.config;


import com.fit.room.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;


/**
 * An application event listener interested in {@link ContextRefreshedEvent} which is raised
 * when an ApplicationContext gets initialized or refreshed.
 */
@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    TaskService taskService;


    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        taskService.createTestTask();


    }


}

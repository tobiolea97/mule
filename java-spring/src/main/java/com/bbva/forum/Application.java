package com.bbva.forum;

import com.bbva.forum.config.ApplicationConfig;
import com.bbva.forum.service.GreetingService;
import com.bbva.forum.service.OutputService;
import com.bbva.forum.service.TimeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        OutputService outputService = context.getBean(OutputService.class);

        for (int i=0;i<5;i++){
            outputService.generateOutput("Tobias");
            Thread.sleep(5000);
        }
    }
}

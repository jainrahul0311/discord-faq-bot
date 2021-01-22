package com.discord.faq_bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Component
public class KeepMeAliveBean {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public KeepMeAliveBean() {
        logger.info("Inside Keep Alive Bean");
        while (true){
            long time = new Date().getTime();
        }
    }
}

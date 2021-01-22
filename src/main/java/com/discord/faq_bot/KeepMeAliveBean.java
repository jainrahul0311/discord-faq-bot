package com.discord.faq_bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class KeepMeAliveBean {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @GetMapping("/")
    public void keepMeAlive(){
        logger.info("Keep Me Alive HeartBeat");
    }
}

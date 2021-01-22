package com.discord.faq_bot.event;

import discord4j.core.event.domain.message.MessageCreateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MessageCreateListener extends MessageListener implements EventListener<MessageCreateEvent> {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public Class<MessageCreateEvent> getEventType() {
        return MessageCreateEvent.class;
    }

    @Override
    public Mono<Void> execute(MessageCreateEvent event) {
        logger.info("Inside execute");
        Mono<Void> voidMono = processCommand(event.getMessage());
        return voidMono;
    }

}

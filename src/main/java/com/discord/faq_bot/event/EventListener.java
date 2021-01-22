package com.discord.faq_bot.event;

import discord4j.core.event.domain.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;


public interface EventListener <T extends Event>{
    Logger Log = LoggerFactory.getLogger(EventListener.class);

    Class<T> getEventType();
    Mono<Void> execute(T event);

    default Mono<Void> handleError(Throwable error){
        Log.error("Unable to process " + getEventType().getSimpleName(),error);
        return Mono.empty();
    }
}

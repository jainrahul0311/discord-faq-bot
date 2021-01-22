package com.discord.faq_bot;

import com.discord.faq_bot.event.EventListener;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BotConfiguration {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String token = System.getenv("BOT_TOKEN");

    @Bean
    public <T extends Event> GatewayDiscordClient gatewayDiscordClient(List<EventListener<T>> eventListeners){
        logger.info("Initialized the GatewayDiscord Client");

        GatewayDiscordClient client =  DiscordClientBuilder.create(token)
                .build()
                .login()
                .block();

        for (EventListener<T> listener : eventListeners){
            logger.info("Inside the Event Listener Loop");
            client.on(listener.getEventType())
                    .flatMap(listener::execute)
                    .onErrorResume(listener::handleError)
                    .subscribe();
        }

        return client;
    }
}

package dev.ayohandgod.roomcleanernotifier;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper mapper;

    @Autowired
    private ConfigurableApplicationContext context;

    public Runner(RabbitTemplate template, ObjectMapper mapper) {
        this.rabbitTemplate = template;
        this.mapper = mapper;
    }

    @Override
    public void run(String... args) throws Exception {
        int index = (int) (Math.random() * (28-1)) + 1;
        AsyncPayload payload = new AsyncPayload();
        payload.setId(index);
        payload.setModel("ROOM");
        rabbitTemplate.convertAndSend("operations", "Landon.rooms.cleaner",
                mapper.writeValueAsString(payload));
        context.close();
    }
}

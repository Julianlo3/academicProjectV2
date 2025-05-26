package co.edu.unicauca.gestioncoordinadormicroservice.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String PROYECTO_PUBLICADO_QUEUE = "proyectoPublicadoQueue";

    @Bean
    public Queue proyectoPublicadoQueue() {
        return new Queue(PROYECTO_PUBLICADO_QUEUE, true);
    }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue proyectoAprobadoQueue() {
        return new Queue("proyectoAprobadoQueue", true);
    }
}
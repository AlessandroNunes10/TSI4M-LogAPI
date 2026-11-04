package br.org.edu.ifrn.LogAPI.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String FILA_LOGS = "loja.carro.logs";
    public static final String EXCHANGE_LOGS = "loja.carro.exchange";
    public static final String CHAVE_LOGS = "loja.carro.log";

    @Bean
    public Queue filaLogs() {
        return new Queue(FILA_LOGS, true);
    }

    @Bean
    public TopicExchange exchangeLogs() {
        return new TopicExchange(EXCHANGE_LOGS);
    }

    @Bean
    public Binding ligacaoLogs(Queue filaLogs, TopicExchange exchangeLogs) {
        return BindingBuilder.bind(filaLogs).to(exchangeLogs).with(CHAVE_LOGS);
    }

    @Bean
    public MessageConverter conversorJson() {
        return new Jackson2JsonMessageConverter();
    }
}

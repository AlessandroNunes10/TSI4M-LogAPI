package br.org.edu.ifrn.LogAPI.messaging;

import br.org.edu.ifrn.LogAPI.dto.LogMensagem;
import br.org.edu.ifrn.LogAPI.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class LogRabbitConsumer {
    private static final Logger log = LoggerFactory.getLogger(LogRabbitConsumer.class);
    private final LogService logService;

    public LogRabbitConsumer(LogService logService) {
        this.logService = logService;
    }

    @RabbitListener(queues = "loja.carro.logs")
    public void receber(LogMensagem mensagem) {
        log.info("Mensagem recebida do RabbitMQ: operacao={} usuario={}",
                mensagem.operacao(), mensagem.usuarioNome());
        logService.salvar(mensagem);
    }
}

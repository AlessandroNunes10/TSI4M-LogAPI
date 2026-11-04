package br.org.edu.ifrn.LogAPI.service;

import br.org.edu.ifrn.LogAPI.dto.LogMensagem;
import br.org.edu.ifrn.LogAPI.model.LogRegistro;
import br.org.edu.ifrn.LogAPI.repository.LogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LogService {
    private static final Logger log = LoggerFactory.getLogger(LogService.class);
    private final LogRepository repository;

    public LogService(LogRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public LogRegistro salvar(LogMensagem mensagem) {
        LogRegistro registro = new LogRegistro();
        registro.setDataHora(mensagem.dataHora() != null ? mensagem.dataHora() : LocalDateTime.now());
        registro.setOperacao(mensagem.operacao());
        registro.setStatus(mensagem.status());
        registro.setUsuarioId(mensagem.usuarioId());
        registro.setUsuarioNome(mensagem.usuarioNome());
        registro.setMetodoHttp(mensagem.metodoHttp());
        registro.setEndpoint(mensagem.endpoint());
        registro.setDetalhes(mensagem.detalhes());

        LogRegistro salvo = repository.save(registro);
        log.info("Log armazenado no banco. id={} operacao={} status={}",
                salvo.getId(), salvo.getOperacao(), salvo.getStatus());
        return salvo;
    }

    @Transactional(readOnly = true)
    public List<LogRegistro> listarTodos() {
        return repository.findAll();
    }
}

package br.org.edu.ifrn.LogAPI.controller;

import br.org.edu.ifrn.LogAPI.model.LogRegistro;
import br.org.edu.ifrn.LogAPI.service.LogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {
    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping
    public List<LogRegistro> listarTodos() {
        return logService.listarTodos();
    }
}

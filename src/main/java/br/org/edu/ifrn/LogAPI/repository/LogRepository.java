package br.org.edu.ifrn.LogAPI.repository;

import br.org.edu.ifrn.LogAPI.model.LogRegistro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<LogRegistro, Long> {
}

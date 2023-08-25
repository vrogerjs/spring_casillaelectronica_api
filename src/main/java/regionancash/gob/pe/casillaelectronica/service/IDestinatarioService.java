package regionancash.gob.pe.casillaelectronica.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.casillaelectronica.model.Dependencia;
import regionancash.gob.pe.casillaelectronica.model.Destinatario;

public interface IDestinatarioService extends ICRUD<Destinatario, Integer>{
    Page<Destinatario> findAllPagination(Pageable page);
}

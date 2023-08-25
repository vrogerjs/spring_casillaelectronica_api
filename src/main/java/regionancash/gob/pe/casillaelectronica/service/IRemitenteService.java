package regionancash.gob.pe.casillaelectronica.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.casillaelectronica.model.Dependencia;
import regionancash.gob.pe.casillaelectronica.model.Remitente;

public interface IRemitenteService extends ICRUD<Remitente, Integer>{
    Page<Remitente> findAllPagination(Pageable page);
}

package regionancash.gob.pe.casillaelectronica.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.casillaelectronica.model.Notificacion;
import regionancash.gob.pe.casillaelectronica.model.Persona;

public interface IPersonaService extends ICRUD<Persona, Integer>{
    Page<Persona> findAllPagination(Pageable page);
}

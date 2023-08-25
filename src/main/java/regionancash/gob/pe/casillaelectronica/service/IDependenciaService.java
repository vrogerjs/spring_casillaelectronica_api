package regionancash.gob.pe.casillaelectronica.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.casillaelectronica.model.Dependencia;

public interface IDependenciaService extends ICRUD<Dependencia, Integer>{

    Page<Dependencia> findAllPagination(Pageable page);
}

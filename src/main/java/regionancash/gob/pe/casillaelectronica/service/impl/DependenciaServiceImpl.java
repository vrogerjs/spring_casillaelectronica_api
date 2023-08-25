package regionancash.gob.pe.casillaelectronica.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.casillaelectronica.model.Dependencia;
import regionancash.gob.pe.casillaelectronica.repository.IDependenciaRepository;
import regionancash.gob.pe.casillaelectronica.service.IDependenciaService;

@Service
public class DependenciaServiceImpl extends CRUDImpl<Dependencia, Integer> implements IDependenciaService {

    @Autowired
    private IDependenciaRepository repo;

    @Override
    protected JpaRepository<Dependencia, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Dependencia> findAllPagination(Pageable page) {
        return repo.findAll(page);
    }
}

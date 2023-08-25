package regionancash.gob.pe.casillaelectronica.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.casillaelectronica.model.Persona;
import regionancash.gob.pe.casillaelectronica.repository.IPersonaRepository;
import regionancash.gob.pe.casillaelectronica.service.IPersonaService;

@Service
public class PersonaServiceImpl extends CRUDImpl<Persona, Integer> implements IPersonaService {

    @Autowired
    private IPersonaRepository repo;

    @Override
    protected JpaRepository<Persona, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Persona> findAllPagination(Pageable page) {
        return repo.findAll(page);
    }
}

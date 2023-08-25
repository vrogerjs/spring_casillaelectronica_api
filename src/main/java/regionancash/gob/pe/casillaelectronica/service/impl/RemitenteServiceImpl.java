package regionancash.gob.pe.casillaelectronica.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.casillaelectronica.model.Remitente;
import regionancash.gob.pe.casillaelectronica.repository.IRemitenteRepository;
import regionancash.gob.pe.casillaelectronica.service.IRemitenteService;

@Service
public class RemitenteServiceImpl extends CRUDImpl<Remitente, Integer> implements IRemitenteService {

    @Autowired
    private IRemitenteRepository repo;

    @Override
    protected JpaRepository<Remitente, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Remitente> findAllPagination(Pageable page) {
        return repo.findAll(page);
    }
}

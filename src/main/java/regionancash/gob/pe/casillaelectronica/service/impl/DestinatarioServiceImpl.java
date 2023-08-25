package regionancash.gob.pe.casillaelectronica.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.casillaelectronica.model.Destinatario;
import regionancash.gob.pe.casillaelectronica.repository.IDestinatarioRepository;
import regionancash.gob.pe.casillaelectronica.service.IDestinatarioService;

@Service
public class DestinatarioServiceImpl extends CRUDImpl<Destinatario, Integer> implements IDestinatarioService {

    @Autowired
    private IDestinatarioRepository repo;

    @Override
    protected JpaRepository<Destinatario, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Destinatario> findAllPagination(Pageable page) {
        return repo.findAll(page);
    }
}

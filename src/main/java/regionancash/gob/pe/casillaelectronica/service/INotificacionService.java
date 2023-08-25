package regionancash.gob.pe.casillaelectronica.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.casillaelectronica.model.Notificacion;

public interface INotificacionService extends ICRUD<Notificacion, Integer>{
    Page<Notificacion> findAllPagination(Pageable page);

    Page<Notificacion> findAllByEstado(Pageable page, String estado, Integer uid);

    int changeEstado(Integer id, String estado);

}

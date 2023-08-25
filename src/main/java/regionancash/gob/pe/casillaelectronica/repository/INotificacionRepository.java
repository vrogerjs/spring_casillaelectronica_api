package regionancash.gob.pe.casillaelectronica.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import regionancash.gob.pe.casillaelectronica.model.Notificacion;

public interface INotificacionRepository extends IGenericRepo<Notificacion, Integer>{

    @Query("SELECT n FROM Notificacion n WHERE (:uid IS NULL OR n.persona.id=:uid) AND (:estado IS NULL OR n.estado=:estado)")
    Page<Notificacion> findAllByEstado(Pageable pageable, String estado, Integer uid);

    @Transactional
    @Modifying
    @Query("UPDATE Notificacion n SET n.estado=:estado WHERE n.id=:id")
    int changeEstadoOne(Integer id, String estado);

}

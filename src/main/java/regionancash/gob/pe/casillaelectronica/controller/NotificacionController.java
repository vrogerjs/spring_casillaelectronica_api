package regionancash.gob.pe.casillaelectronica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import regionancash.gob.pe.casillaelectronica.model.Notificacion;
import regionancash.gob.pe.casillaelectronica.service.INotificacionService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notificacion")
public class NotificacionController {
    @Autowired
    private INotificacionService service;

    @GetMapping
    public List<Notificacion> readAll() throws Exception {
        return service.readAll();
    }

    @GetMapping("/all/{from}/{to}")
    public ResponseEntity<Page<Notificacion>> findAllPagination(
            @PathVariable(value = "from") int from,
            @PathVariable(value = "to") int to) {
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "id"));
        var pageable = PageRequest.of(from, to, sort);
        Page<Notificacion> p = service.findAllPagination(pageable);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/{from}/{to}")
    public ResponseEntity<Page<Notificacion>> findAllPaginationByUid(
            @PathVariable(value = "from") int from,
            @PathVariable(value = "to") int to,
            @RequestParam(name = "estado", required = false, defaultValue = "1") String estado,
            @RequestParam(name = "uid") Integer uid) {
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "id"));
        var pageable = PageRequest.of(from, to, sort);
        Page<Notificacion> p = service.findAllByEstado(pageable, estado, uid);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Notificacion readById(@PathVariable("id") Integer id) throws Exception {
        return service.readById(id);
    }

    @PostMapping
    public Notificacion create(@RequestBody Notificacion notificacion) throws Exception {
        return service.create(notificacion);
    }

    @PutMapping
    public Notificacion update(@RequestBody Notificacion notificacion) throws Exception {
        return service.update(notificacion);
    }

    @GetMapping("/change/{id}")
    public int changeEstado(@PathVariable("id") Integer id, @RequestParam(name = "estado") String estado) throws Exception {
        return service.changeEstado(id, estado);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}

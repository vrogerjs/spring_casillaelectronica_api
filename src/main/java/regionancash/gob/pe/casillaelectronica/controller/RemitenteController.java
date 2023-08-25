package regionancash.gob.pe.casillaelectronica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import regionancash.gob.pe.casillaelectronica.model.Remitente;
import regionancash.gob.pe.casillaelectronica.service.IRemitenteService;

import java.util.List;

@RestController
@RequestMapping("/remitente")
public class RemitenteController {
    @Autowired
    private IRemitenteService service;

    @GetMapping
    public List<Remitente> readAll() throws Exception {
        return service.readAll();
    }

    @GetMapping("/{from}/{to}")
    public ResponseEntity<Page<Remitente>> findAllPagination(@PathVariable(value = "from") int from, @PathVariable(value = "to") int to) {
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "id"));
        var pageable = PageRequest.of(from, to, sort);
        Page<Remitente> p = service.findAllPagination(pageable);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Remitente readById(@PathVariable("id") Integer id) throws Exception {
        return service.readById(id);
    }

    @PostMapping
    public Remitente create(@RequestBody Remitente remitente) throws Exception {
        return service.create(remitente);
    }

    @PutMapping
    public Remitente update(@RequestBody Remitente remitente) throws Exception {
        return service.update(remitente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}

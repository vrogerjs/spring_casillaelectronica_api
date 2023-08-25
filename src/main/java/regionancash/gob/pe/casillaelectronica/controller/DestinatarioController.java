package regionancash.gob.pe.casillaelectronica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import regionancash.gob.pe.casillaelectronica.model.Destinatario;
import regionancash.gob.pe.casillaelectronica.service.IDestinatarioService;

import java.util.List;

@RestController
@RequestMapping("/destinatario")
public class DestinatarioController {
    @Autowired
    private IDestinatarioService service;

    @GetMapping
    public List<Destinatario> readAll() throws Exception {
        return service.readAll();
    }

    @GetMapping("/{from}/{to}")
    public ResponseEntity<Page<Destinatario>> findAllPagination(@PathVariable(value = "from") int from, @PathVariable(value = "to") int to) {
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "id"));
        var pageable = PageRequest.of(from, to, sort);
        Page<Destinatario> p = service.findAllPagination(pageable);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Destinatario readById(@PathVariable("id") Integer id) throws Exception {
        return service.readById(id);
    }

    @PostMapping
    public Destinatario create(@RequestBody Destinatario destinatario) throws Exception {
        return service.create(destinatario);
    }

    @PutMapping
    public Destinatario update(@RequestBody Destinatario destinatario) throws Exception {
        return service.update(destinatario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}

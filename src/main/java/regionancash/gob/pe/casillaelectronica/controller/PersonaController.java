package regionancash.gob.pe.casillaelectronica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import regionancash.gob.pe.casillaelectronica.model.Persona;
import regionancash.gob.pe.casillaelectronica.service.IPersonaService;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    private IPersonaService service;

    @GetMapping
    public List<Persona> readAll() throws Exception {
        return service.readAll();
    }

    @GetMapping("/{from}/{to}")
    public ResponseEntity<Page<Persona>> findAllPagination(@PathVariable(value = "from") int from, @PathVariable(value = "to") int to) {
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "id"));
        var pageable = PageRequest.of(from, to, sort);
        Page<Persona> p = service.findAllPagination(pageable);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Persona readById(@PathVariable("id") Integer id) throws Exception {
        return service.readById(id);
    }

    @PostMapping
    public Persona create(@RequestBody Persona persona) throws Exception {
        return service.create(persona);
    }

    @PutMapping
    public Persona update(@RequestBody Persona persona) throws Exception {
        return service.update(persona);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}

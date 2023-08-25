package regionancash.gob.pe.casillaelectronica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import regionancash.gob.pe.casillaelectronica.model.Dependencia;
import regionancash.gob.pe.casillaelectronica.service.IDependenciaService;

import java.util.List;

@RestController
@RequestMapping("/dependencia")
public class DependenciaController {
    @Autowired
    private IDependenciaService service;

    @GetMapping
    public List<Dependencia> readAll() throws Exception {
        return service.readAll();
    }

    @GetMapping("/{from}/{to}")
    public ResponseEntity<Page<Dependencia>> findAllPagination(@PathVariable(value = "from") int from, @PathVariable(value = "to") int to) {
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "id"));
        var pageable = PageRequest.of(from, to, sort);
        Page<Dependencia> p = service.findAllPagination(pageable);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Dependencia readById(@PathVariable("id") Integer id) throws Exception {
        return service.readById(id);
    }

    @PostMapping
    public Dependencia create(@RequestBody Dependencia dependencia) throws Exception {
        return service.create(dependencia);
    }

    @PutMapping
    public Dependencia update(@RequestBody Dependencia dependencia) throws Exception {
        return service.update(dependencia);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}

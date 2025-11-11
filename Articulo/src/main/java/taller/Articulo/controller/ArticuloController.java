package taller.Articulo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import taller.Articulo.dto.ArticuloRequest;
import taller.Articulo.dto.ArticuloResponse;
import taller.Articulo.service.ArticuloService;

import java.util.List;

@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {

    private final ArticuloService service;
    private static final Logger log = LoggerFactory.getLogger(ArticuloController.class);

    public ArticuloController(ArticuloService service) {
        this.service = service;
    }

    // Listar todos los artículos
    @GetMapping
    public List<ArticuloResponse> getAll() {
        log.info("Obteniendo todos los artículos");
        return service.findAll();
    }

    // Crear un nuevo artículo
    @PostMapping
    public ArticuloResponse create(@RequestBody ArticuloRequest request) {
        log.info("Creando artículo: {}", request.getNombre());
        return service.save(request);
    }

    // Actualizar un artículo existente
    @PutMapping("/{id}")
    public ArticuloResponse update(@PathVariable Long id, @RequestBody ArticuloRequest request) {
        log.info("Actualizando artículo con ID {}", id);
        return service.update(id, request);
    }

    // Eliminar un artículo por ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        log.info("Eliminando artículo con ID {}", id);
        service.delete(id);
    }
}

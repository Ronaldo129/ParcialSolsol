package taller.Articulo.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import taller.Articulo.dto.ArticuloRequest;
import taller.Articulo.dto.ArticuloResponse;
import taller.Articulo.model.Articulo;
import taller.Articulo.repository.ArticuloRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticuloService {

    private final ArticuloRepository repository;
    private static final Logger log = LoggerFactory.getLogger(ArticuloService.class);

    public ArticuloService(ArticuloRepository repository) {
        this.repository = repository;
    }

    // Obtener todos los artículos
    public List<ArticuloResponse> findAll() {
        log.debug("Buscando todos los artículos en la base de datos");
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    // Guardar nuevo artículo
    public ArticuloResponse save(ArticuloRequest request) {
        Articulo articulo = new Articulo();
        articulo.setNombre(request.getNombre());
        articulo.setPrecio(request.getPrecio());
        Articulo saved = repository.save(articulo);
        log.debug("Artículo guardado con ID {}", saved.getId());
        return toResponse(saved);
    }

    
    public ArticuloResponse update(Long id, ArticuloRequest request) {
        Articulo existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artículo no encontrado con ID " + id));

        existing.setNombre(request.getNombre());
        existing.setPrecio(request.getPrecio());

        Articulo updated = repository.save(existing);
        log.debug("Artículo actualizado con ID {}", updated.getId());
        return toResponse(updated);
    }

    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artículo no encontrado con ID " + id));
        repository.deleteById(id);
        log.debug("Artículo eliminado con ID {}", id);
    }

    
    private ArticuloResponse toResponse(Articulo articulo) {
        ArticuloResponse response = new ArticuloResponse();
        response.setId(articulo.getId());
        response.setNombre(articulo.getNombre());
        response.setPrecio(articulo.getPrecio());
        return response;
    }
}

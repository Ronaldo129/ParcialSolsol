package taller.Articulo.repository;
import taller.Articulo.model.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  ArticuloRepository extends JpaRepository<Articulo, Long> {}

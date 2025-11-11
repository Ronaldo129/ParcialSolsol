package taller.Articulo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "articulos")

public class Articulo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private double precio;
}

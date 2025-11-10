package edu.cibertec.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name="Producto", description = "Entidad que representa un producto")
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String nombre;
    @Column(name = "description")
    private String descripcion;
    @Column(name = "category")
    private String categoria;
    @Column(name = "size")
    private String talla;
    @Column(name = "colour")
    private String color;
    @Column(name = "price")
    private double precio;
    @Column(name = "photourl")
    private String fotoUrl;
    @Column(name = "estado")
    private int estado;
}

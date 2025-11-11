package edu.cibertec.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    @JsonProperty("nombre")
    private String nombre;
    @Column(name = "description")
    @JsonProperty("descripcion")
    private String descripcion;
    @Column(name = "category")
    @JsonProperty("categoria")
    private String categoria;
    @Column(name = "size")
    @JsonProperty("talla")
    private String talla;
    @Column(name = "colour")
    @JsonProperty("color")
    private String color;
    @Column(name = "price")
    @JsonProperty("precio")
    private double precio;
    @Column(name = "photourl")
    @JsonProperty("fotoUrl")
    private String fotoUrl;
    @Column(name = "estado")
    @JsonProperty("estado")
    private int estado;
}

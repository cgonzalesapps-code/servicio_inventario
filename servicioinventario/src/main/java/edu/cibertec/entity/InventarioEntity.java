package edu.cibertec.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

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
@Table(name = "Stock")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name="Inventario", description = "Entidad que representa el inventario")
public class InventarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "productid")
    @JsonProperty("productoID")
    private Integer productoID;
    @Column(name = "branchid")
    @JsonProperty("sucursalID")
    private Integer sucursalID;
    @Column(name = "quantity")
    @JsonProperty("cantidad")
    private Integer cantidad;
    @Column(name = "estado")
    @JsonProperty("estado")
    private int estado;
    
}

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
@Table(name = "Sucursal")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name="Sucursal", description = "Entidad que representa un Sucursal")
public class SucursalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String nombre;
    @Column(name = "description")
    private String descripcion;
    @Column(name = "address")
    private String direccion;
    @Column(name = "phone")
    private String telefono;
    @Column(name = "estado")
    private int estado;
}

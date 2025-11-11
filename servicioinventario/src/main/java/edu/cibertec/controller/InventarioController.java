package edu.cibertec.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import edu.cibertec.entity.ErrorEntity;
import edu.cibertec.entity.InventarioEntity;
import edu.cibertec.entity.ProductoEntity;
import edu.cibertec.service.InventarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/inventario")
@Tag(name = "Inventario", description = "Api de inventario")


public class InventarioController {
     private final InventarioService inventarioService;

    @ExceptionHandler(ResponseStatusException.class)
    private ResponseEntity<ErrorEntity> capturadorErrores(ResponseStatusException ex) {
        ErrorEntity error = new ErrorEntity();
        error.setStatus(ex.getStatusCode().toString());
        error.setMessage(ex.getReason());
        error.setError(ex.getStatusCode().value());
        HttpStatus statusCode =(HttpStatus) ex.getStatusCode();
        return ResponseEntity.status(statusCode).body(error);
    }

    @GetMapping
    public ResponseEntity<List<InventarioEntity>> listarInventario() {
       return ResponseEntity.ok(inventarioService.listarinventario());
    }

     @GetMapping("{id}")
    public InventarioEntity obtenerInventarioPorId(@PathVariable Integer id) {
        return inventarioService.obtenerInventario(id);
    }
    @PostMapping
    public ResponseEntity<InventarioEntity> registrarProducto(@RequestBody InventarioEntity inventario) {
        try {
            return ResponseEntity.created(new URI("/api/v1/productos/" + inventario.getId()))
                                    .body(inventarioService.registrarInventario(inventario));
        } catch(Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED,"No se pudo procesar el curso:" + inventario.getId(),null);
        }

    }
    @PutMapping("{id}")
    public ResponseEntity<InventarioEntity> actualizarCurso(@PathVariable Integer id, @RequestBody InventarioEntity inventario) {
        inventario.setId(id);
        return new ResponseEntity<InventarioEntity>(inventarioService.actualizarInventario(inventario), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity eliminarInventario(@PathVariable Integer id) {
        inventarioService.eliminarInventario(id);
        return ResponseEntity.noContent().build();
    }

}

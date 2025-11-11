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
import edu.cibertec.entity.ProductoEntity;

import edu.cibertec.service.ProductoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/productos")
@Tag(name = "Producto", description = "Api de producto")

public class ProductoController {
    private final ProductoService productoService;

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
    public ResponseEntity<List<ProductoEntity>> listarProductos() {
        return ResponseEntity.ok(productoService.listarProductos());
    }

    @GetMapping("{id}")
    public ProductoEntity obtenerProductoPorId(@PathVariable Integer id) {
        return productoService.obtenerProducto(id);
    }
    @PostMapping
    public ResponseEntity<ProductoEntity> registrarProducto(@RequestBody ProductoEntity producto) {
        try {
            return ResponseEntity.created(new URI("/api/v1/productos/" + producto.getId()))
                                    .body(productoService.registrarProducto(producto));
        } catch(Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED,"No se pudo procesar el curso:" + producto.getId(),null);
        }

    }
    @PutMapping("{id}")
    public ResponseEntity<ProductoEntity> actualizarCurso(@PathVariable Integer id, @RequestBody ProductoEntity producto) {
        producto.setId(id);
        return new ResponseEntity<ProductoEntity>(productoService.actualizarProducto(producto), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity eliminarCurso(@PathVariable Integer id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}

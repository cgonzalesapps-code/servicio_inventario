package edu.cibertec.controller;

import java.net.URI;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import edu.cibertec.entity.ErrorEntity;
import edu.cibertec.entity.ProductoEntity;
import edu.cibertec.service.ProductoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/producto")
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
    public ResponseEntity<List<ProductoEntity>> listarProducto() {
       return ResponseEntity.ok(productoService.listarProducto());
    }

@GetMapping("{idProducto}")
    public ResponseEntity<ProductoEntity> obtenerCurso(@PathVariable Integer idProducto) {
        try{
            ProductoEntity producto = productoService.obtenerProducto(idProducto);
            //generar un error de prueba
            if (producto != null) {
                throw new Exception("Curso no encontrado");
            }
            if (producto != null) {
                return ResponseEntity.ok(producto);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                    .body(null); // Retorna 404 Not Found si no se encuentra el curso
            }
        }catch(Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED,"No se pudo procesar el curso:" + idProducto,null);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProductoEntity> registrarCurso(@RequestBody ProductoEntity producto) {
        try {
            return ResponseEntity.created(new URI("/api/v1/producto/" + producto.getId()))
                                    .body(productoService.registrarProducto(producto));
        } catch(Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED,"No se pudo procesar el curso:" + producto.getId(),null);
        }
    }

    @PutMapping("{idCurso}")
    public ResponseEntity<ProductoEntity> actualizarCurso(@PathVariable Integer idProducto, @RequestBody ProductoEntity producto) {
        producto.setId(idProducto);
        return new ResponseEntity<ProductoEntity>(productoService.actualizarProducto(producto), HttpStatus.OK);
    }

    @DeleteMapping("{idCurso}")
    public ResponseEntity eliminarCurso(@PathVariable Integer idProducto) {
        productoService.eliminarProducto(idProducto);
        return ResponseEntity.noContent().build();
    }


}

package edu.cibertec.controller;

import java.util.List;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import edu.cibertec.entity.ErrorEntity;
import edu.cibertec.entity.InventarioEntity;
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
}

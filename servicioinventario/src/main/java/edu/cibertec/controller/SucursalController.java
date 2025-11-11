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
import edu.cibertec.entity.SucursalEntity;

import edu.cibertec.service.SucursalService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/sucursal")
@Tag(name = "Sucursal", description = "Api de sucursal")

public class SucursalController {
     private final SucursalService sucursalService;

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
    public ResponseEntity<List<SucursalEntity>> listarSucursal() {
       return ResponseEntity.ok(sucursalService.listarSucursal());
    }

    @GetMapping("{id}")
    public SucursalEntity obtenerSucursalPorId(@PathVariable Integer id) {
        return sucursalService.obtenerSucursal(id);
    }

    @PostMapping
    public ResponseEntity<SucursalEntity> registrarSucursal(@RequestBody SucursalEntity sucursal) {
        try {
            return ResponseEntity.created(new URI("/api/v1/sucursal/" + sucursal.getId()))
                                    .body(sucursalService.registrarSucursal(sucursal));
        } catch(Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED,"No se pudo procesar el curso:" + ex.getMessage(),null);
        }

    }

    @PutMapping("{id}")
    public ResponseEntity<SucursalEntity> actualizarSucursal(@PathVariable Integer id, @RequestBody SucursalEntity sucursal) {
        sucursal.setId(id);
        return new ResponseEntity<SucursalEntity>(sucursalService.actualizarSucursal(sucursal), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity eliminarSucursal(@PathVariable Integer id) {
        sucursalService.eliminarSucursal(id);
        return ResponseEntity.noContent().build();
    }

}

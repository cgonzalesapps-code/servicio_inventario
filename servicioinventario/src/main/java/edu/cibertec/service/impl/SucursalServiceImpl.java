package edu.cibertec.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.cibertec.entity.SucursalEntity;
import edu.cibertec.repository.SucursalRepository;
import edu.cibertec.service.SucursalService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SucursalServiceImpl implements SucursalService {
    private final SucursalRepository sucursalRepository;

     @Override
    public List<SucursalEntity> listarSucursal() {
        return sucursalRepository.findAll();
    }

     @Override
     public SucursalEntity obtenerSucursal(Integer id) {
        return sucursalRepository.findById(id).orElse(null);
     }

     @Override
     public SucursalEntity registrarSucursal(SucursalEntity sucursal) {
      return sucursalRepository.save(sucursal);
     }

     @Override
     public SucursalEntity actualizarSucursal(SucursalEntity sucursal) {
        return sucursalRepository.save(sucursal);
     }

     @Override
     public SucursalEntity eliminarSucursal(Integer id) {
        SucursalEntity sucursal = obtenerSucursal(id);
        if (sucursal != null) {
            sucursal.setEstado(0);
            sucursalRepository.save(sucursal);
        }
        return sucursal;
     }

}

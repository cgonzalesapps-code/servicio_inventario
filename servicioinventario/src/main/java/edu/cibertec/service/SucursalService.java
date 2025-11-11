package edu.cibertec.service;

import java.util.List;

import edu.cibertec.entity.SucursalEntity;



public interface SucursalService {
    public List<SucursalEntity> listarSucursal();
    public SucursalEntity obtenerSucursal(Integer id);
    public SucursalEntity registrarSucursal(SucursalEntity sucursal);
    public SucursalEntity actualizarSucursal(SucursalEntity sucursal);
    public SucursalEntity eliminarSucursal(Integer id);
}
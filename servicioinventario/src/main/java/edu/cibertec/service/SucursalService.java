package edu.cibertec.service;

import java.util.List;

import edu.cibertec.entity.SucursalEntity;

public interface SucursalService {
    public List<SucursalEntity> listarSucursal();
    public SucursalEntity obtenerSucursal(Integer idSucursal);
    public SucursalEntity registrarSucursal(SucursalEntity sucursal);
    public SucursalEntity actualizarSucursal(SucursalEntity sucursal);
    public SucursalEntity eliminarSucursal(Integer idSucursal);
}

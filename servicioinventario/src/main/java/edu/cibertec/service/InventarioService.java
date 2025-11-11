package edu.cibertec.service;

import java.util.List;

import edu.cibertec.entity.InventarioEntity;

public interface InventarioService {
    public List<InventarioEntity> listarinventario();
    public InventarioEntity obtenerInventario(Integer id);
    public InventarioEntity registrarInventario(InventarioEntity inventario);
    public InventarioEntity actualizarInventario(InventarioEntity inventario);
    public InventarioEntity eliminarInventario(Integer id);
}

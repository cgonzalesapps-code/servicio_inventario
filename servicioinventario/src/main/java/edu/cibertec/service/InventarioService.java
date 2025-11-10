package edu.cibertec.service;

import java.util.List;

import edu.cibertec.entity.InventarioEntity;

public interface InventarioService {
    public List<InventarioEntity> listarinventario();
    public InventarioEntity obtenerCurso(Integer idinventario);
    public InventarioEntity registrarCurso(InventarioEntity inventario);
    public InventarioEntity actualizarCurso(InventarioEntity inventario);
    public InventarioEntity eliminarCurso(Integer idinventario);
}

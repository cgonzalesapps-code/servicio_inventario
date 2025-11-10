package edu.cibertec.service;

import java.util.List;

import edu.cibertec.entity.ProductoEntity;

public interface ProductoService {

    public List<ProductoEntity> listarProducto();

    public ProductoEntity obtenerProducto(Integer idProducto);
    public ProductoEntity registrarProducto(ProductoEntity producto);
    public ProductoEntity actualizarProducto(ProductoEntity producto);
    public ProductoEntity eliminarProducto(Integer idProducto);

}

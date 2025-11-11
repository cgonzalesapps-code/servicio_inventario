package edu.cibertec.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.cibertec.entity.ProductoEntity;
import edu.cibertec.repository.ProductoRepository;
import edu.cibertec.service.ProductoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService{

    private final ProductoRepository productoRepository;
    @Override
    public List<ProductoEntity> listarProductos() {
                return productoRepository.findAll();
    }

    @Override
    public ProductoEntity obtenerProducto(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public ProductoEntity registrarProducto(ProductoEntity producto) {
        return productoRepository.save(producto);
    }

    @Override
    public ProductoEntity actualizarProducto(ProductoEntity producto) {
        return productoRepository.save(producto);
    }

    @Override
    public ProductoEntity eliminarProducto(Integer id) {
        ProductoEntity producto = obtenerProducto(id);
        if (producto != null) {
            producto.setEstado(0);
            productoRepository.save(producto);
        }
        return producto;
    }
    
}

package edu.cibertec.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import edu.cibertec.entity.ProductoEntity;
import edu.cibertec.repository.ProductoRepository;
import edu.cibertec.service.ProductoService;


@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {
    private final ProductoRepository productoRepository;

     @Override
    public List<ProductoEntity> listarProducto() {
        return productoRepository.findAll();
    }

     @Override
     public ProductoEntity obtenerProducto(Integer idProducto) {
          return productoRepository.findById(idProducto).orElse(null);
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
     public ProductoEntity eliminarProducto(Integer idProducto) {
        ProductoEntity producto = obtenerProducto(idProducto);
        if (producto != null) {
            //producto.set(0);
            productoRepository.save(producto);
        }
        return producto;
     }
}

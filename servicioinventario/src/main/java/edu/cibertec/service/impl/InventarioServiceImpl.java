package edu.cibertec.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import edu.cibertec.entity.InventarioEntity;
import edu.cibertec.repository.InventarioRepository;
import edu.cibertec.service.InventarioService;

@Service
@RequiredArgsConstructor
public class InventarioServiceImpl implements InventarioService {
    private final InventarioRepository inventarioRepository;

     @Override
    public List<InventarioEntity> listarinventario() {
        return inventarioRepository.findAll();
    }

     @Override
     public InventarioEntity obtenerInventario(Integer id) {
        return inventarioRepository.findById(id).orElse(null);
     }

     @Override
     public InventarioEntity registrarInventario(InventarioEntity inventario) {
        return inventarioRepository.save(inventario);
     }

     @Override
     public InventarioEntity actualizarInventario(InventarioEntity inventario) {
        return inventarioRepository.save(inventario);
     }

     @Override
     public InventarioEntity eliminarInventario(Integer id) {
        InventarioEntity inventario = obtenerInventario(id);
        if (inventario != null) {
            inventario.setEstado(0);
            inventarioRepository.save(inventario);
        }
        return inventario;
     }
}

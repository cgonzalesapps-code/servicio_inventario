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
     public InventarioEntity obtenerCurso(Integer idinventario) {
        return inventarioRepository.findById(idinventario).orElse(null);
     }

     @Override
     public InventarioEntity registrarCurso(InventarioEntity inventario) {
        return inventarioRepository.save(inventario);
     }

     @Override
     public InventarioEntity actualizarCurso(InventarioEntity inventario) {
        return inventarioRepository.save(inventario);
     }

     @Override
     public InventarioEntity eliminarCurso(Integer idinventario) {
        InventarioEntity inventario = obtenerCurso(idinventario);
        if (inventario != null) {
            //inventario.setEstado(0);
            inventarioRepository.save(inventario);
        }
        return inventario;
     }
}

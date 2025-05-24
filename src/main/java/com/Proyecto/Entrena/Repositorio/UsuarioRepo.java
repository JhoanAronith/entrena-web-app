package com.Proyecto.Entrena.Repositorio;

import com.Proyecto.Entrena.Modelo.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {
    
    public Usuario findByEmail(String email);
    List<Usuario> findByRol(String rol);
    
}

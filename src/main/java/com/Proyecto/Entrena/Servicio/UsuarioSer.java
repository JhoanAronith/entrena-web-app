package com.Proyecto.Entrena.Servicio;

import com.Proyecto.Entrena.Modelo.Usuario;
import com.Proyecto.Entrena.Repositorio.UsuarioRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UsuarioSer implements UserDetailsService {
    
    @Autowired
    private UsuarioRepo repo;
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = repo.findByEmail(email);
        if (usuario!=null) {
            var springUser = User.withUsername(usuario.getEmail())
                    .password(usuario.getContrasena())
                    .roles(usuario.getRol().toUpperCase())
                    .build();
            return springUser;
        }
        return null;
    }
    
    public List<Usuario> listarPorRol(String rol) {
        return repo.findByRol(rol);
    }
    
    public List<Usuario> listarTodos() {
        return repo.findAll();
    }
    
    public Optional<Usuario> buscarPorIdi(int idUsuario) {
        return repo.findById(idUsuario);
    }
    
    public Usuario guardarUsuario(Usuario usuario) {
        return repo.save(usuario);
    }
    
    public void eliminarUsuario(int idUsuario) {
        repo.deleteById(idUsuario);
    }
    
}

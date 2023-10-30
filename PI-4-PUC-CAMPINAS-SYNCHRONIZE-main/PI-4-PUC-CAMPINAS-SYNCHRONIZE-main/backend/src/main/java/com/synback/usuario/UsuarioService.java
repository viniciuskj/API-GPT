package com.synback.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuarios> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuarios> getUsuarioById(String id) {
        return usuarioRepository.findById(id);
    }

    public Usuarios createUsuario(Usuarios usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuarios updateUsuario(String id, Usuarios usuario) {
        if (usuarioRepository.existsById(id)) {
            return usuarioRepository.save(usuario);
        } else {
            // Você pode lidar com o cenário em que o usuário não existe, por exemplo, lançando uma exceção
            throw new RuntimeException("Usuário não encontrado com o ID: " + id);
        }
    }

    public void deleteUsuario(String id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        } else {
            // Você pode lidar com o cenário em que o usuário não existe, por exemplo, lançando uma exceção
            throw new RuntimeException("Usuário não encontrado com o ID: " + id);
        }
    }
}

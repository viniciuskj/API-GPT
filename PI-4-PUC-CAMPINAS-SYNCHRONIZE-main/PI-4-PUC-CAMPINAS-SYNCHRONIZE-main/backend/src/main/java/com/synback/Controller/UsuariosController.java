package com.synback.Controller;

import com.synback.usuario.UsuarioService;
import com.synback.usuario.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

    private final UsuarioService service;

    // Usando a injeção de dependência através do construtor
    @Autowired
    public UsuariosController(UsuarioService service) {
        this.service = service;
    }

    // Retorna todos os usuários
    @GetMapping
    public ResponseEntity<List<Usuarios>> getAllUsuarios() {
        List<Usuarios> usuarios = service.getAllUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    // Retorna um usuário específico pelo ID ou erro 404 se não encontrado
    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> getUsuarioById(@PathVariable String id) {
        return service.getUsuarioById(id)
                .map(usuario -> ResponseEntity.ok(usuario))
                .orElse(ResponseEntity.notFound().build());
    }

    // Cria um novo usuário
    @PostMapping
    public ResponseEntity<Usuarios> createUsuario(@RequestBody Usuarios usuario) {
        Usuarios createdUsuario = service.createUsuario(usuario);
        return ResponseEntity.ok(createdUsuario);
    }

    // Atualiza um usuário existente pelo ID
    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> updateUsuario(@PathVariable String id, @RequestBody Usuarios usuario) {
        try {
            Usuarios updatedUsuario = service.updateUsuario(id, usuario);
            return ResponseEntity.ok(updatedUsuario);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Exclui um usuário pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable String id) {
        try {
            service.deleteUsuario(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}

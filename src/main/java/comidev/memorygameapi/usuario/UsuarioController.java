package comidev.memorygameapi.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0/users")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{username}")
    public ResponseEntity<Boolean> existsUsername(@PathVariable String username) {
        boolean response = usuarioService.existsUsername(username);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Boolean> register(@RequestBody Usuario usuario) {
        boolean response = usuarioService.register(usuario);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsers() {
        List<Usuario> usuarios = usuarioService.getUsers();
        return usuarios != null ? ResponseEntity.ok(usuarios) : ResponseEntity.noContent().build();
    }
}

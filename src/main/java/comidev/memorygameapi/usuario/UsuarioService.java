package comidev.memorygameapi.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepo usuarioRepo;

    public boolean existsUsername(String username) {
        return usuarioRepo.findByUsername(username) != null;
    }

    public boolean register(Usuario usuario) {
        Usuario usuarioFound = usuarioRepo.findByUsername(usuario.getUsername());
        if (usuarioFound == null) {
            usuarioRepo.save(usuario);
            return true;
        }
        return false;
    }

    public List<Usuario> getUsers() {
        List<Usuario> usuarios = usuarioRepo.findAll();
        return usuarios != null ? sortByErroresAndTime(usuarios) : null;
    }

    private List<Usuario> sortByErroresAndTime(List<Usuario> usuarios) {
        usuarios.sort((a, b) -> {
            if (a.getErrores() != b.getErrores()) {
                if (a.getErrores() > b.getErrores()) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                if (a.getTime() > b.getTime()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        return usuarios;
    }
}

package comidev.memorygameapi.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private Integer errores;
    private Float time;

    public Usuario() {
    }

    public Usuario(String username, Integer errores, Float time) {
        this.username = username;
        this.errores = errores;
        this.time = time;
    }
}

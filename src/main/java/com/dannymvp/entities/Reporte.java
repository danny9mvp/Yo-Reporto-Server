package com.dannymvp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Reporte {
    private int repoId;
    private String repoTitulo;
    private String repoDescripcion;
    private String repoUsuario;
    private int repoUbicacion;
    private byte[] foto;
    private Usuario usuarioByRepoUsuario;
    private Ubicacion ubicacionByRepoUbicacion;

    @Id
    @Column(name = "repo_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getRepoId() {
        return repoId;
    }

    public void setRepoId(int repoId) {
        this.repoId = repoId;
    }

    @Basic
    @Column(name = "repo_titulo")
    @JsonProperty("titulo")
    public String getRepoTitulo() {
        return repoTitulo;
    }

    public void setRepoTitulo(String repoTitulo) {
        this.repoTitulo = repoTitulo;
    }

    @Basic
    @Column(name = "repo_descripcion")
    @JsonProperty("descripcion")
    public String getRepoDescripcion() {
        return repoDescripcion;
    }

    public void setRepoDescripcion(String repoDescripcion) {
        this.repoDescripcion = repoDescripcion;
    }

    @Basic
    @Column(name = "repo_usuario")
    @JsonProperty("usuario")
    public String getRepoUsuario() {
        return repoUsuario;
    }

    public void setRepoUsuario(String repoUsuario) {
        this.repoUsuario = repoUsuario;
    }

    @Basic
    @Column(name = "repo_ubicacion")
    @JsonProperty("ubicacion")
    public int getRepoUbicacion() {
        return repoUbicacion;
    }

    public void setRepoUbicacion(int repoUbicacion) {
        this.repoUbicacion = repoUbicacion;
    }

    @Column(name="repo_foto", unique = true)
    @Lob
    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reporte reporte = (Reporte) o;
        return repoId == reporte.repoId &&
                repoUbicacion == reporte.repoUbicacion &&
                Objects.equals(repoTitulo, reporte.repoTitulo) &&
                Objects.equals(repoDescripcion, reporte.repoDescripcion) &&
                Objects.equals(repoUsuario, reporte.repoUsuario);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(repoId, repoTitulo, repoDescripcion, repoUsuario, repoUbicacion);
        result = 31 * result;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "repo_usuario", referencedColumnName = "usu_nick", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    public Usuario getUsuarioByRepoUsuario() {
        return usuarioByRepoUsuario;
    }

    public void setUsuarioByRepoUsuario(Usuario usuarioByRepoUsuario) {
        this.usuarioByRepoUsuario = usuarioByRepoUsuario;
    }

    @ManyToOne
    @JoinColumn(name = "repo_ubicacion", referencedColumnName = "ubi_id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    public Ubicacion getUbicacionByRepoUbicacion() {
        return ubicacionByRepoUbicacion;
    }

    public void setUbicacionByRepoUbicacion(Ubicacion ubicacionByRepoUbicacion) {
        this.ubicacionByRepoUbicacion = ubicacionByRepoUbicacion;
    }
}

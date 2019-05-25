package com.dannymvp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Usuario {
    private String usuNick;
    private String usuNombres;
    private String usuApellidos;
    private String usuPass;
    private String usuEmail;
    private Boolean usuActivo;
    private Collection<Reporte> reportesByUsuNick;
    private Collection<UsuarioResidencia> usuarioResidenciasByUsuNick;

    @Id
    @Column(name = "usu_nick")
    @JsonProperty("nick")
    public String getUsuNick() {
        return usuNick;
    }

    public void setUsuNick(String usuNick) {
        this.usuNick = usuNick;
    }

    @Basic
    @Column(name = "usu_nombres")
    @JsonProperty("nombres")
    public String getUsuNombres() {
        return usuNombres;
    }

    public void setUsuNombres(String usuNombres) {
        this.usuNombres = usuNombres;
    }

    @Basic
    @Column(name = "usu_apellidos")
    @JsonProperty("apellidos")
    public String getUsuApellidos() {
        return usuApellidos;
    }

    public void setUsuApellidos(String usuApellidos) {
        this.usuApellidos = usuApellidos;
    }

    @Basic
    @Column(name = "usu_pass")
    @JsonProperty("pass")
    public String getUsuPass() {
        return usuPass;
    }

    public void setUsuPass(String usuPass) {
        this.usuPass = usuPass;
    }

    @Basic
    @Column(name = "usu_email")
    @JsonProperty("email")
    public String getUsuEmail() {
        return usuEmail;
    }

    public void setUsuEmail(String usuEmail) {
        this.usuEmail = usuEmail;
    }

    @Basic
    @Column(name = "usu_activo")
    @JsonProperty("activo")
    public Boolean getUsuActivo() {
        return usuActivo;
    }

    public void setUsuActivo(Boolean usuActivo) {
        this.usuActivo = usuActivo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(usuNick, usuario.usuNick) &&
                Objects.equals(usuNombres, usuario.usuNombres) &&
                Objects.equals(usuApellidos, usuario.usuApellidos) &&
                Objects.equals(usuPass, usuario.usuPass) &&
                Objects.equals(usuEmail, usuario.usuEmail) &&
                Objects.equals(usuActivo, usuario.usuActivo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuNick, usuNombres, usuApellidos, usuPass, usuEmail, usuActivo);
    }

    @OneToMany(mappedBy = "usuarioByRepoUsuario")
    @JsonIgnore
    public Collection<Reporte> getReportesByUsuNick() {
        return reportesByUsuNick;
    }

    public void setReportesByUsuNick(Collection<Reporte> reportesByUsuNick) {
        this.reportesByUsuNick = reportesByUsuNick;
    }

    @OneToMany(mappedBy = "usuarioByUresUsuario")
    @JsonIgnore
    public Collection<UsuarioResidencia> getUsuarioResidenciasByUsuNick() {
        return usuarioResidenciasByUsuNick;
    }

    public void setUsuarioResidenciasByUsuNick(Collection<UsuarioResidencia> usuarioResidenciasByUsuNick) {
        this.usuarioResidenciasByUsuNick = usuarioResidenciasByUsuNick;
    }
}

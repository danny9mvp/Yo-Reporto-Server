package com.dannymvp.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "usuario_residencia", schema = "public", catalog = "d1scl7fg81vh22")
public class UsuarioResidencia {
    private int uresId;
    private String uresDireccion;
    private String uresUsuario;
    private int uresDepartamento;
    private int uresMunicipio;
    private Usuario usuarioByUresUsuario;
    private Departamento departamentoByUresDepartamento;
    private Municipio municipioByUresMunicipio;

    @Id
    @Column(name = "ures_id")
    public int getUresId() {
        return uresId;
    }

    public void setUresId(int uresId) {
        this.uresId = uresId;
    }

    @Basic
    @Column(name = "ures_direccion")
    @JsonProperty("direccion")
    public String getUresDireccion() {
        return uresDireccion;
    }

    public void setUresDireccion(String uresDireccion) {
        this.uresDireccion = uresDireccion;
    }

    @Basic
    @Column(name = "ures_usuario")
    @JsonProperty("usuario")
    public String getUresUsuario() {
        return uresUsuario;
    }

    public void setUresUsuario(String uresUsuario) {
        this.uresUsuario = uresUsuario;
    }

    @Basic
    @Column(name = "ures_departamento")
    @JsonProperty("departamento")
    public int getUresDepartamento() {
        return uresDepartamento;
    }

    public void setUresDepartamento(int uresDepartamento) {
        this.uresDepartamento = uresDepartamento;
    }

    @Basic
    @Column(name = "ures_municipio")
    @JsonProperty("municipio")
    public int getUresMunicipio() {
        return uresMunicipio;
    }

    public void setUresMunicipio(int uresMunicipio) {
        this.uresMunicipio = uresMunicipio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioResidencia that = (UsuarioResidencia) o;
        return uresId == that.uresId &&
                uresDepartamento == that.uresDepartamento &&
                uresMunicipio == that.uresMunicipio &&
                Objects.equals(uresDireccion, that.uresDireccion) &&
                Objects.equals(uresUsuario, that.uresUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uresId, uresDireccion, uresUsuario, uresDepartamento, uresMunicipio);
    }

    @ManyToOne
    @JoinColumn(name = "ures_usuario", referencedColumnName = "usu_nick", nullable = false, insertable = false, updatable = false)
    public Usuario getUsuarioByUresUsuario() {
        return usuarioByUresUsuario;
    }

    public void setUsuarioByUresUsuario(Usuario usuarioByUresUsuario) {
        this.usuarioByUresUsuario = usuarioByUresUsuario;
    }

    @ManyToOne
    @JoinColumn(name = "ures_departamento", referencedColumnName = "dept_id", nullable = false, insertable = false, updatable = false)
    public Departamento getDepartamentoByUresDepartamento() {
        return departamentoByUresDepartamento;
    }

    public void setDepartamentoByUresDepartamento(Departamento departamentoByUresDepartamento) {
        this.departamentoByUresDepartamento = departamentoByUresDepartamento;
    }

    @ManyToOne
    @JoinColumn(name = "ures_municipio", referencedColumnName = "muni_id", nullable = false, insertable = false, updatable = false)
    public Municipio getMunicipioByUresMunicipio() {
        return municipioByUresMunicipio;
    }

    public void setMunicipioByUresMunicipio(Municipio municipioByUresMunicipio) {
        this.municipioByUresMunicipio = municipioByUresMunicipio;
    }
}

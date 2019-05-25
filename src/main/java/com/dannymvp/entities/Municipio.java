package com.dannymvp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "MUNICIPIO")
public class Municipio {
    private int muniId;
    private String muniNombre;
    private int muniDepartamento;
    private Departamento departamentoByMuniDepartamento;
    private Collection<UsuarioResidencia> usuarioResidenciasByMuniId;

    @Id
    @Column(name = "muni_id")
    @JsonProperty("id")
    public int getMuniId() {
        return muniId;
    }

    public void setMuniId(int muniId) {
        this.muniId = muniId;
    }

    @Basic
    @Column(name = "muni_nombre")
    @JsonProperty("nombre")
    public String getMuniNombre() {
        return muniNombre;
    }

    public void setMuniNombre(String muniNombre) {
        this.muniNombre = muniNombre;
    }

    @Basic
    @Column(name = "muni_departamento")
    public int getMuniDepartamento() {
        return muniDepartamento;
    }

    public void setMuniDepartamento(int muniDepartamento) {
        this.muniDepartamento = muniDepartamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Municipio municipio = (Municipio) o;
        return muniId == municipio.muniId &&
                muniDepartamento == municipio.muniDepartamento &&
                Objects.equals(muniNombre, municipio.muniNombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(muniId, muniNombre, muniDepartamento);
    }

    @ManyToOne
    @JoinColumn(name = "muni_departamento", referencedColumnName = "dept_id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    public Departamento getDepartamentoByMuniDepartamento() {
        return departamentoByMuniDepartamento;
    }

    public void setDepartamentoByMuniDepartamento(Departamento departamentoByMuniDepartamento) {
        this.departamentoByMuniDepartamento = departamentoByMuniDepartamento;
    }

    @OneToMany(mappedBy = "municipioByUresMunicipio")
    @JsonIgnore
    public Collection<UsuarioResidencia> getUsuarioResidenciasByMuniId() {
        return usuarioResidenciasByMuniId;
    }

    public void setUsuarioResidenciasByMuniId(Collection<UsuarioResidencia> usuarioResidenciasByMuniId) {
        this.usuarioResidenciasByMuniId = usuarioResidenciasByMuniId;
    }
}

package com.dannymvp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Departamento {
    private int deptId;
    private String deptNombre;
    private Collection<Municipio> municipiosByDeptId;
    private Collection<UsuarioResidencia> usuarioResidenciasByDeptId;

    @Id
    @Column(name = "dept_id")
    @JsonProperty("id")
    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    @Basic
    @Column(name = "dept_nombre")
    @JsonProperty("nombre")
    public String getDeptNombre() {
        return deptNombre;
    }

    public void setDeptNombre(String deptNombre) {
        this.deptNombre = deptNombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departamento that = (Departamento) o;
        return deptId == that.deptId &&
                Objects.equals(deptNombre, that.deptNombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptId, deptNombre);
    }

    @OneToMany(mappedBy = "departamentoByMuniDepartamento")
    @JsonIgnore
    public Collection<Municipio> getMunicipiosByDeptId() {
        return municipiosByDeptId;
    }

    public void setMunicipiosByDeptId(Collection<Municipio> municipiosByDeptId) {
        this.municipiosByDeptId = municipiosByDeptId;
    }

    @OneToMany(mappedBy = "departamentoByUresDepartamento")
    @JsonIgnore
    public Collection<UsuarioResidencia> getUsuarioResidenciasByDeptId() {
        return usuarioResidenciasByDeptId;
    }

    public void setUsuarioResidenciasByDeptId(Collection<UsuarioResidencia> usuarioResidenciasByDeptId) {
        this.usuarioResidenciasByDeptId = usuarioResidenciasByDeptId;
    }
}

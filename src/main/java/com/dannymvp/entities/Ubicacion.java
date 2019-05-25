package com.dannymvp.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Ubicacion {
    private int ubiId;
    private float ubiLongitud;
    private float ubiLatitud;
    private Collection<Reporte> reportesByUbiId;

    @Id
    @Column(name = "ubi_id")
    public int getUbiId() {
        return ubiId;
    }

    public void setUbiId(int ubiId) {
        this.ubiId = ubiId;
    }

    @Basic
    @Column(name = "ubi_longitud")
    public float getUbiLongitud() {
        return ubiLongitud;
    }

    public void setUbiLongitud(float ubiLongitud) {
        this.ubiLongitud = ubiLongitud;
    }

    @Basic
    @Column(name = "ubi_latitud")
    public float getUbiLatitud() {
        return ubiLatitud;
    }

    public void setUbiLatitud(float ubiLatitud) {
        this.ubiLatitud = ubiLatitud;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ubicacion ubicacion = (Ubicacion) o;
        return ubiId == ubicacion.ubiId &&
                Float.compare(ubicacion.ubiLongitud, ubiLongitud) == 0 &&
                Float.compare(ubicacion.ubiLatitud, ubiLatitud) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ubiId, ubiLongitud, ubiLatitud);
    }

    @OneToMany(mappedBy = "ubicacionByRepoUbicacion")
    public Collection<Reporte> getReportesByUbiId() {
        return reportesByUbiId;
    }

    public void setReportesByUbiId(Collection<Reporte> reportesByUbiId) {
        this.reportesByUbiId = reportesByUbiId;
    }
}

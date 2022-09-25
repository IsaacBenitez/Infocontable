package com.infocontable.infocontable.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.infocontable.infocontable.config.Rol;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User {


    @Id
    @Column(nullable = false)
    private String nit;

    @Column(nullable = false)
    private String contrasena;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private String empresa;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<ReporteContable> reportesContables;

    @Column
    @Enumerated(EnumType.STRING)
    private Rol rol;



    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @JsonManagedReference
    public List<ReporteContable> getReportesContables() {
        return reportesContables;
    }

    public void setReportesContables(List<ReporteContable> reportesContables) {
        this.reportesContables = reportesContables;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }


}

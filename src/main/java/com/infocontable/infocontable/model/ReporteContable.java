package com.infocontable.infocontable.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reportescontables")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ReporteContable {

    @EmbeddedId
    private ReporteContableId reporteContableId = new ReporteContableId();

    @Column
    private String num_cuenta;

    @Column
    private String metodo_pago;

    @Column
    private Double valor;

    @Column
    private String descripcion;

    @Column
    private LocalDate fecha;

    @Column
    private String comentarios;

    @Column
    private String nombre_tercero;

    @ManyToOne
    @JoinColumn(name = "user_nit")
    private User user;


    public ReporteContableId getReporteContableId() {
        return reporteContableId;
    }

    public void setReporteContableId(ReporteContableId reporteContableId) {
        this.reporteContableId = reporteContableId;
    }

    public String getNum_cuenta() {
        return num_cuenta;
    }

    public void setNum_cuenta(String num_cuenta) {
        this.num_cuenta = num_cuenta;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getNombre_tercero() {
        return nombre_tercero;
    }

    public void setNombre_tercero(String nombre_tercero) {
        this.nombre_tercero = nombre_tercero;
    }

    @JsonBackReference
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

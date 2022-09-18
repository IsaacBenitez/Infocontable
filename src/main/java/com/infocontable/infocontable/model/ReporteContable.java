package com.infocontable.infocontable.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reportescontables")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ReporteContable {

    @EmbeddedId
    private ReporteContableId reporteContableId;

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


}

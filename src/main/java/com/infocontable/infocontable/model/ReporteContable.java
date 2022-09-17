package com.infocontable.infocontable.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reportecontable")
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
    private Date fecha;

    @Column
    private String comentarios;

    @Column
    private String nombre_tercero;

    @ManyToOne
    @JoinColumn(name = "user_nit")
    private User user;


}

package com.infocontable.infocontable.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReporteContableId implements Serializable {


    private String tipo_soporte;
    private String num_soporte;
    private String id_tercero;


}

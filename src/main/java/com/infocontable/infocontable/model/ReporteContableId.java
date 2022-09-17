package com.infocontable.infocontable.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
public class ReporteContableId implements Serializable {

    private String tipo_soporte;
    private String num_soporte;
    private String id_tercero;
}

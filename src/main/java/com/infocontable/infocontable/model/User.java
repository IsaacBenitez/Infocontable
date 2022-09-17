package com.infocontable.infocontable.model;

import com.infocontable.infocontable.config.Rol;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TBL_USER")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {


    @Id
    @Column(nullable = false)
    private String nit;

    @Column(nullable = false)
    private String contraseña;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private String empresa;

    @Column
    private String codigo_auth;

    @OneToMany
    private List<ReporteContable> reportesContables;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Rol rol;


}

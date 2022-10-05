package com.infocontable.infocontable.controller;


import com.infocontable.infocontable.model.ReporteContable;
import com.infocontable.infocontable.model.ReporteContableId;
import com.infocontable.infocontable.model.User;
import com.infocontable.infocontable.repository.UserRepository;
import com.infocontable.infocontable.service.ReporteContableService;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/reportes")
public class ReporteContableController {

    @Autowired
    private ReporteContableService reporteContableService;


    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("listarReportes")
    public String listarReportesContables(Model model){
        model.addAttribute("reportes", reporteContableService.getReporteContableList());
        return "menuPrincipalCliente";
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("buscarReporte")
    public ReporteContable buscarReporteContable(@RequestBody ReporteContableId reporteContableId){
        return reporteContableService.getReporteContable(reporteContableId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("ingresarReporte")  //Dirige hacia el formulario para crear reporte contable.
    public String formIngresarReporte(ReporteContable reporteContable){
        return "crearReporteContable";
    }
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PostMapping("crearReporte")    //Persiste la creacion del reporte contable.
    public String crearReporteContable(ReporteContable reporteContable){
        reporteContableService.addReporteContable(reporteContable);
        return "redirect:listarReportes";
    }

    //TODO: ELIMINAR REPORTE Y ACTUALIZAR.
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @DeleteMapping("eliminarReporte")
    public void eliminarReporteContable(@RequestBody ReporteContableId reporteContableId){
        reporteContableService.deleteReporteContable(reporteContableId);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PutMapping("editarReporte")
    public void editarReporteContable(@RequestBody ReporteContable reporteContable){
        reporteContableService.updateReporteContable(reporteContable);
    }
}

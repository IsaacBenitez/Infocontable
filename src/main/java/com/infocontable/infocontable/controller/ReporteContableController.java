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

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
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

    // TODO: ELIMINAR REPORTE Y ACTUALIZAR.
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("eliminarReporte/{tipo}/{num}/{id}")
    public String eliminarReporteContable(@PathVariable("tipo") String tipo_soporte, @PathVariable("num") String num_soporte, @PathVariable("id") String id_tercero){
        reporteContableService.deleteReporteContable(tipo_soporte,num_soporte,id_tercero);
        return "redirect:/api/reportes/listarReportes";
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PutMapping("editarReporte")
    public void editarReporteContable(@RequestBody ReporteContable reporteContable){
        reporteContableService.updateReporteContable(reporteContable);
    }
}

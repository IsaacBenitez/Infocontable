package com.infocontable.infocontable.controller;


import com.infocontable.infocontable.model.ReporteContable;
import com.infocontable.infocontable.model.ReporteContableId;
import com.infocontable.infocontable.model.User;
import com.infocontable.infocontable.repository.UserRepository;
import com.infocontable.infocontable.service.ReporteContableService;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReporteContableController {

    @Autowired
    private ReporteContableService reporteContableService;


    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("listarReportes")
    public List<ReporteContable> listarReportesContables(){return reporteContableService.getReporteContableList();}

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("buscarReporte")
    public ReporteContable buscarReporteContable(@RequestBody ReporteContableId reporteContableId){
        return reporteContableService.getReporteContable(reporteContableId);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PostMapping("crearReporte")
    public void crearReporteContable(@RequestBody ReporteContable reporteContable){
        reporteContableService.addReporteContable(reporteContable);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @DeleteMapping("eliminarReporte")
    public void eliminarReporteContable(@RequestParam ReporteContableId reporteContableId){
        reporteContableService.deleteReporteContable(reporteContableId);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PutMapping("editarReporte")
    public void editarReporteContable(@RequestBody ReporteContable reporteContable){
        reporteContableService.updateReporteContable(reporteContable);
    }
}

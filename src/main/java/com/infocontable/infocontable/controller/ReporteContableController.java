package com.infocontable.infocontable.controller;


import com.infocontable.infocontable.model.ReporteContable;
import com.infocontable.infocontable.model.ReporteContableId;
import com.infocontable.infocontable.service.ReporteContableService;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReporteContableController {

    @Autowired
    private ReporteContableService reporteContableService;

    @GetMapping("listar")
    public List<ReporteContable> listarReportesContables(){return reporteContableService.getReporteContableList();}

    @GetMapping
    public ReporteContable buscarReporteContable(@RequestParam ReporteContableId reporteContableId){
        return reporteContableService.getReporteContable(reporteContableId);
    }

    @PostMapping
    public void crearReporteContable(@RequestBody ReporteContable reporteContable){
        reporteContableService.addReporteContable(reporteContable);
    }

    @DeleteMapping
    public void eliminarReporteContable(@RequestParam ReporteContableId reporteContableId){
        reporteContableService.deleteReporteContable(reporteContableId);
    }

    @PutMapping
    public void editarReporteContable(@RequestBody ReporteContable reporteContable){
        reporteContableService.updateReporteContable(reporteContable);
    }
    // TODO: PROBAR EL ENDPOINT DE EDITAR REPORTE CONTABLE
}

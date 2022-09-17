package com.infocontable.infocontable.controller;


import com.infocontable.infocontable.model.ReporteContable;
import com.infocontable.infocontable.model.ReporteContableId;
import com.infocontable.infocontable.service.ReporteContableService;
import com.sun.xml.bind.v2.TODO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReporteContableController {

    private ReporteContableService reporteContableService;

    public List<ReporteContable> listarReportesContables(){return reporteContableService.getReporteContableList();}

    public ReporteContable buscarReporteContable(@RequestParam ReporteContableId reporteContableId){
        return reporteContableService.getReporteContable(reporteContableId);
    }

    public void crearReporteContable(@RequestBody ReporteContable reporteContable){
        reporteContableService.addReporteContable(reporteContable);
    }

    public void eliminarReporteContable(@RequestParam ReporteContableId reporteContableId){
        reporteContableService.deleteReporteContable(reporteContableId);
    }

    // TODO: CREAR EL ENDPOINT DE ACTUALIZAR REPORTE CONTABLE
}

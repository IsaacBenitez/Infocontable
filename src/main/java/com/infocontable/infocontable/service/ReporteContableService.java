package com.infocontable.infocontable.service;

import com.infocontable.infocontable.model.ReporteContable;
import com.infocontable.infocontable.model.ReporteContableId;
import com.infocontable.infocontable.repository.ReporteContableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteContableService {

    private ReporteContableRepository reporteContableRepository;
    public List<ReporteContable> getReporteContableList() {return reporteContableRepository.findAll();
    }

    public ReporteContable getReporteContable(ReporteContableId reporteContableId) { return reporteContableRepository.buscarReporteContableId(reporteContableId);   }

    public void addReporteContable(ReporteContable reporteContable) { reporteContableRepository.save(reporteContable);
    }

    public void deleteReporteContable(ReporteContableId reporteContableId) { reporteContableRepository.deleteById(reporteContableId);
    }
}

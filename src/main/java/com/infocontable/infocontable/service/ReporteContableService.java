package com.infocontable.infocontable.service;

import com.infocontable.infocontable.model.ReporteContable;
import com.infocontable.infocontable.model.ReporteContableId;
import com.infocontable.infocontable.model.User;
import com.infocontable.infocontable.repository.ReporteContableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ReporteContableService {

    @Autowired
    private ReporteContableRepository reporteContableRepository;
    public List<ReporteContable> getReporteContableList() {return reporteContableRepository.findAll();
    }

    public ReporteContable getReporteContable(ReporteContableId reporteContableId) { return reporteContableRepository.buscarReporteContableId(reporteContableId);   }

    public void addReporteContable(ReporteContable reporteContable) { reporteContableRepository.save(reporteContable);
    }

    public void deleteReporteContable(ReporteContableId reporteContableId) { reporteContableRepository.deleteById(reporteContableId);
    }
    @Transactional
    public void updateReporteContable(ReporteContable reporteContable) {
        ReporteContable original = reporteContableRepository.findById(reporteContable.getReporteContableId()).orElseThrow(() -> new IllegalStateException("Student with id does not exist"));
        original.setNum_cuenta(reporteContable.getNum_cuenta());
        original.setMetodo_pago(reporteContable.getMetodo_pago());
        original.setValor(reporteContable.getValor());
        original.setDescripcion(reporteContable.getDescripcion());
        original.setFecha(reporteContable.getFecha());
        original.setComentarios(reporteContable.getComentarios());
        original.setNombre_tercero(reporteContable.getNombre_tercero());
    }
}

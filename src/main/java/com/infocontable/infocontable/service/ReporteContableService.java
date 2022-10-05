package com.infocontable.infocontable.service;

import com.infocontable.infocontable.model.ReporteContable;
import com.infocontable.infocontable.model.ReporteContableId;
import com.infocontable.infocontable.model.SecurityUser;
import com.infocontable.infocontable.model.User;
import com.infocontable.infocontable.repository.ReporteContableRepository;
import com.infocontable.infocontable.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ReporteContableService {

    @Autowired
    private ReporteContableRepository reporteContableRepository;

    @Autowired
    private UserRepository userRepository;


    public List<ReporteContable> getReporteContableList() {return reporteContableRepository.findAll();
    }

    public ReporteContable getReporteContable(ReporteContableId reporteContableId) { return reporteContableRepository.buscarReporteContableId(reporteContableId);   }

    public void addReporteContable(ReporteContable reporteContable) {
        Optional<ReporteContable> rcOptional = reporteContableRepository.findById(reporteContable.getReporteContableId());
        if(rcOptional.isPresent()){
            throw new IllegalStateException("El reporte que desea ingresar ya existe");
        }
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();
            Optional<User> user = userRepository.buscarPorNit(username);
            reporteContable.setUser(user.get());
        } else {
            String username = principal.toString();
        }

        reporteContableRepository.save(reporteContable);
    }

    public void deleteReporteContable(ReporteContableId reporteContableId) {
        boolean exists = reporteContableRepository.existsById(reporteContableId);
        if(!exists){
            throw new IllegalStateException("El reporte " + reporteContableId +" no existe");
        }
        reporteContableRepository.deleteById(reporteContableId);
    }
    @Transactional
    public void updateReporteContable(ReporteContable reporteContable) {
        ReporteContable original = reporteContableRepository.findById(reporteContable.getReporteContableId()).orElseThrow(() -> new IllegalStateException("El reporte contable que desea editar no existe"));
        original.setNum_cuenta(reporteContable.getNum_cuenta());
        original.setMetodo_pago(reporteContable.getMetodo_pago());
        original.setValor(reporteContable.getValor());
        original.setDescripcion(reporteContable.getDescripcion());
        original.setFecha(reporteContable.getFecha());
        original.setComentarios(reporteContable.getComentarios());
        original.setNombre_tercero(reporteContable.getNombre_tercero());
    }
}

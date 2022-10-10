package com.infocontable.infocontable.controller;

import com.infocontable.infocontable.model.User;
import com.infocontable.infocontable.repository.ReporteContableRepository;
import com.infocontable.infocontable.service.ReporteContableService;
import com.infocontable.infocontable.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@Controller
@RequestMapping("/api/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ReporteContableService reporteContableService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("listarUsuarios") // Lista todos los usuarios
    public String listarUsuarios(Model model){
        model.addAttribute("users", userService.getUsersList());
        return "menuPrincipalContador";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("registrarUsuario") // Dirige al formulario para registrar un usuario.
    public String formRegistrarUsuario(User user){
        return "crearUsuario";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("crearUsuario") // Registra un usuario
    public String crearUsuario(User user){
        userService.addUser(user);
        return "redirect:listarUsuarios";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("buscarUsuario/{nit}")
    public Optional<User> buscarUsuario(@PathVariable("nit") String nit){return userService.getUser(nit);}


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("eliminarUsuario/{nit}") // Elimina un usuario
    public String eliminarUsuario(@PathVariable("nit") String nit) {
        userService.deleteUser(nit);
        return "redirect:/api/usuarios/listarUsuarios";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("editarUsuario/{nit}") // Dirige al formulario para editar un usuario.
    public String editarUsuario(@PathVariable("nit") String nit, Model model){
        model.addAttribute("user",userService.getUser(nit).get());
        return "editarUsuario";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("actualizarUsuario/{nit}") // Actualiza la informacion del usuario
    public String actualizarUsuario(@PathVariable("nit") String nit, User user){
        userService.updateUser(nit,user);
        return "redirect:/api/usuarios/listarUsuarios";
    }

    @PreAuthorize("hasRole('ADMIN')") //Muestra los registros del cliente por nit
    @GetMapping("consultarReportesCliente/{nit}")
    public String verReportesCliente(@PathVariable("nit") String nit, Model model){
        model.addAttribute("reportes", reporteContableService.getReporteContableList());
        model.addAttribute("user", userService.getUser(nit).get());
        return "verRegistrosCliente";

    }
}

package com.infocontable.infocontable.controller;

import com.infocontable.infocontable.model.User;
import com.infocontable.infocontable.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/api/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("principal")
    public String viewHomePage(){
        return "menuPrincipalContador";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("crearCliente_")
    public String MostrarcrearCliente(User user) {

        return "crearCliente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("process_register")
    public String processRegistration(User user) {
        userService.addUser(user);

        return "redirect:/api/usuarios/crearCliente_";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("consultarListaClientes")
    public String verListaUsuarios(Model model) {
        List<User> listUsers = userService.getUsersList();
        model.addAttribute("listUsers", listUsers);
        return "consultarClienteContador";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("eliminarInfoClientes")  //
    public String verEliminarUsuarios(Model model) {
        List<User> listUsers = userService.getUsersList();
        model.addAttribute("listUsers", listUsers);
        return "eliminarClienteContador";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("process_delete/{nit}")
    public String processDelete(@PathVariable("nit") String nit) {
        userService.deleteUser(nit);
        return "redirect:/api/usuarios/eliminarInfoClientes";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("modificarClienteContador")
    public String verUsuarios(Model model) {
        List<User> listUsers = userService.getUsersList();
        model.addAttribute("listUsers", listUsers);
        return "modificarInfoClienteContador";

    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/modificar/{nit}")
    public String verUsuarioPorNit(@PathVariable("nit") String nit, Model model) {
        User user = userService.getUser(nit).get();
        model.addAttribute("user", user);

        return "procesoModificacionContador";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("process_update/{nit}")
    public String processUpdate(@PathVariable("nit") String nit, User user) {
        userService.updateUser(nit,user);
        return "redirect:/api/usuarios/modificarClienteContador";

    }


}

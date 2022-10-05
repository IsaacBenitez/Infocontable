package com.infocontable.infocontable.controller;

import com.infocontable.infocontable.model.User;
import com.infocontable.infocontable.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("listarUsuarios")
    public String listarUsuarios(Model model){
        model.addAttribute("usuarios", userService.getUsersList());
        return "menuPrincipalContador";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("buscarUsuario/{nit}")
    public Optional<User> buscarUsuario(@PathVariable("nit") String nit){return userService.getUser(nit);}

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("crearUsuario")
    public void crearUsuario(@RequestBody User user){
        userService.addUser(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("eliminarUsuario/{nit}")
    public void eliminarUsuario(@PathVariable("nit") String nit) {
        userService.deleteUser(nit);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("editarUsuario")
    public void editarUsuario(@RequestBody User user){
        userService.updateUser(user);
    }

}

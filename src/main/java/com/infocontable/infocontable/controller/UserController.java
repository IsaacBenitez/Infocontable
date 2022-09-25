package com.infocontable.infocontable.controller;

import com.infocontable.infocontable.model.User;
import com.infocontable.infocontable.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("listarUsuarios")
    public List<User> listarUsuarios(){
        return userService.getUsersList();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("buscarUsuario")
    public User buscarUsuario(@RequestParam String nit){return userService.getUser(nit);}

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("crearUsuario")
    public void crearUsuario(@RequestBody User user){
        userService.addUser(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("eliminarUsuario")
    public void eliminarUsuario(@RequestParam String nit){
        userService.deleteUser(nit);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("editarUsuario")
    public void editarUsuario(@RequestBody User user){
        userService.updateUser(user);
    }

}

package com.infocontable.infocontable.controller;

import com.infocontable.infocontable.model.User;
import com.infocontable.infocontable.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("clientes")
    public List<User> listarUsuarios(){
        return userService.getUsersList();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public User buscarUsuario(@RequestParam String nit){return userService.getUser(nit);}

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public void crearUsuario(@RequestBody User user){
        userService.addUser(user);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping
    public void eliminarUsuario(@RequestParam String nit){
        userService.deleteUser(nit);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping
    public void editarUsuario(@RequestBody User user){
        userService.updateUser(user);
    }

}

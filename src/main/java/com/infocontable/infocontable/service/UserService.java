package com.infocontable.infocontable.service;

import com.infocontable.infocontable.model.User;
import com.infocontable.infocontable.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> getUsersList() { return userRepository.findAll();}

    public Optional<User> getUser(String nit) {return userRepository.findById(nit);}
    public void addUser(User user) {
        Optional<User> userOptional = userRepository.findById(user.getNit());
        if(userOptional.isPresent()){
            throw new IllegalStateException("Ya existe un usuario para este nit");
        }
        userRepository.save(user);}

    public void deleteUser(String nit) {
        boolean exists = userRepository.existsById(nit);
        if(!exists){
            throw new IllegalStateException("El usuario con el nit " + nit +" no existe");
        }
        userRepository.deleteById(nit);}

    @Transactional
    public void updateUser(User user) {
        User original = userRepository.findById(user.getNit()).orElseThrow(() -> new IllegalStateException("El usuario que desea editar no existe"));
        original.setNombre(user.getNombre());
        original.setApellido(user.getApellido());
        original.setContrasena(user.getContrasena());
        original.setEmpresa(user.getEmpresa());
    }


}

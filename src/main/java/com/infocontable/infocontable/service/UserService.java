package com.infocontable.infocontable.service;

import com.infocontable.infocontable.model.User;
import com.infocontable.infocontable.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> getUsersList() { return userRepository.findAll();}

    public User getUser(String nit) {
        return userRepository.buscarPorNit(nit);
    }
    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(String nit) {
        userRepository.deleteById(nit);
    }

    @Transactional
    public void updateUser(User user) {
        User original = userRepository.findById(user.getNit()).orElseThrow(() -> new IllegalStateException("Student with id does not exist"));
        original.setNombre(user.getNombre());
        original.setApellido(user.getApellido());
        original.setContrasena(user.getContrasena());
        original.setEmpresa(user.getEmpresa());
//        original.setCodigo_auth(user.getCodigo_auth());
    }


}

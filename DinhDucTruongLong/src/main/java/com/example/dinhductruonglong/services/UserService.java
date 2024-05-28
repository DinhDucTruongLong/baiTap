package com.example.dinhductruonglong.services;

import com.example.dinhductruonglong.Entitys.User;
import com.example.dinhductruonglong.RequestEntities.RequestCreateUser;
import com.example.dinhductruonglong.repositorys.RoleRepository;
import com.example.dinhductruonglong.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository repository;
    public User CreateUser(RequestCreateUser requestCreateUser) {
        try {
            User student = new User();
            student.setFirstName(requestCreateUser.getFirstName());
            student.setUsername(requestCreateUser.getUsername());
            student.setLastName(requestCreateUser.getLastName());
            student.setEmail(requestCreateUser.getEmail());
            student.setPassword(requestCreateUser.getPassword());
            student.setRole(requestCreateUser.getRole());
            userRepository.save(student);
            return student;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User with id " + id + " not found")
        );
    }

    public User updateUser(String id, User requestUpdateUser) {
        try {
            User user = getUserById(id);
            user.setFirstName(requestUpdateUser.getFirstName());
            user.setLastName(requestUpdateUser.getLastName());
            user.setPassword(requestUpdateUser.getPassword());
            user.setUsername(requestUpdateUser.getUsername());
            user.setRole(requestUpdateUser.getRole());
            return userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }


}

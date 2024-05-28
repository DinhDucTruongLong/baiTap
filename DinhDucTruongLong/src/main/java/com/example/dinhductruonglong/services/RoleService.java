package com.example.dinhductruonglong.services;
import com.example.dinhductruonglong.Entitys.Role;
import com.example.dinhductruonglong.repositorys.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }
    public Role getRoleById(String id) {
        return roleRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Role not found")
        );
    }
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }
    public Role updateRole(String id, Role roleDetails) {
        Role role = roleRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Role not found")
        );
        role.setRole_name(roleDetails.getRole_name());
        return roleRepository.save(role);
    }

    public void deleteRole(String id) {
        Role role = roleRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Role not found")
        );
        roleRepository.delete(role);
    }
}

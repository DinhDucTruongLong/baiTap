package com.example.dinhductruonglong.repositorys;
import com.example.dinhductruonglong.Entitys.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RoleRepository extends JpaRepository<Role, String>{
}

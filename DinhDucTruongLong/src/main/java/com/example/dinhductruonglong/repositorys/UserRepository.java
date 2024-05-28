package com.example.dinhductruonglong.repositorys;

import com.example.dinhductruonglong.Entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository


public interface UserRepository extends JpaRepository<User, String> {



}

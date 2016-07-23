package com.udogan.baklavaborek.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udogan.baklavaborek.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);
    List<User> findAll();
    User findOne(Long id);
    <S extends User>S saveAndFlush(S user);
    void delete(User user);
}
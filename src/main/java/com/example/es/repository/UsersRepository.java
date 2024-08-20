package com.example.es.repository;

import com.example.es.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    List<Users> findFirst2ByUsernameLikeOrderByIDDesc(String name);
}

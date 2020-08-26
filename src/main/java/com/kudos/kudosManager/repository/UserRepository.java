package com.kudos.kudosManager.repository;

import com.kudos.kudosManager.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    List<UserEntity> findByLastName(String lastName);
}

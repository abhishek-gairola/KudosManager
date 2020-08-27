package com.kudos.kudosManager.repository;

import com.kudos.kudosManager.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    List<UserEntity> findByLastName(String lastName);

    @Query("FROM UserEntity ORDER BY kudoPoints ASC")
    List<UserEntity> findAllOrderByKudosAsc();



    @Query("update ProjectUserEntity pue set pue.status='Accepted' where pue.id=?1")
    int setUserStatus(int id);
}

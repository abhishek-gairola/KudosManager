package com.kudos.kudosManager.repository;

import com.kudos.kudosManager.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity,Long> {
    List<ProjectEntity> findByname(String name);

    @Query("select pe.name from ProjectEntity pe join ProjectUserEntity  pue where pue.id= ?1   ")
    List<ProjectEntity> findAllProjectByUserId(int id);
}

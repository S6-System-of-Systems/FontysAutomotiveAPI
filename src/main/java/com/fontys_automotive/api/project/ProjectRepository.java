package com.fontys_automotive.api.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

//    Optional<Project> findProjectByProjectNaam(String title);
//    Optional<Project> findProjectByProjectNaamOrProjectCode(String title, String projectShortCode);
//    Optional<Project> addTeacherToProject(Long teacherId, Long projectId);
}

package com.fontys_automotive.api.project;

import com.fontys_automotive.api.exceptions.BadRequestException;
import com.fontys_automotive.api.exceptions.NotFoundException;
import com.fontys_automotive.api.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService{

    private final ProjectRepository projectRepository;
    private final TeacherService teacherService;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, TeacherService teacherService) {
        this.teacherService = teacherService;
        this.projectRepository = projectRepository;
    }

//    public Project findProjectByTitle(String title)
//    {
//        Optional<Project> foundProject = projectRepository.findProjectByProjectNaam(title);
//        if(foundProject.isEmpty())
//        {
//            throw new NotFoundException("no project found");
//        }
//        return foundProject.get();
//    }

//    public Project addProject(Project project)
//    {
//        Optional<Project> foundProject = projectRepository.findProjectByProjectNaamOrProjectCode(project.getProjectNaam(), project.getProjectCode());
//        if(foundProject.isPresent())
//        {
//            throw new BadRequestException("Project already exists");
//        }
//        Project createdProject = projectRepository.save(project);
//        return createdProject;
//    }

    public List<Project> getAllProjects()
    {
        List<Project> projects = projectRepository.findAll();
        if(projects.size() < 1)
        {
            throw new NotFoundException("no projects");
        }

        return projects;
    }

//    public Project addTeacher(Long teacherId, Long projectId) {
//        Project projectToModify = projectRepository.getById(projectId);
//        if(projectToModify == null)
//        {
//            throw new NotFoundException("project not found");
//        }
//        projectToModify.getInvolvedTeachers().add(teacherService.getTeacherById(teacherId).get());
//        Project modifiedProject = projectRepository.save(projectToModify);
//        return modifiedProject;
//    }
}

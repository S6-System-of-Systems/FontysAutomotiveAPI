package com.fontys_automotive.api.project;

import com.fontys_automotive.api.exceptions.BadRequestException;
import com.fontys_automotive.api.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectService{

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project findProjectByTitle(String title)
    {
        Optional<Project> foundProject = projectRepository.findProjectByProjectTitle(title);
        if(foundProject.isEmpty())
        {
            throw new NotFoundException("no project found");
        }
        return foundProject.get();
    }

    public Project addProject(Project project)
    {
        Optional<Project> foundProject = projectRepository.findProjectByProjectTitle(project.getProjectTitle());
        if(foundProject.isPresent())
        {
            throw new BadRequestException("Project already exists");
        }
        Project createdProject = projectRepository.save(project);
        return createdProject;
    }


}

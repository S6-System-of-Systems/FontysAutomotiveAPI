package com.fontys_automotive.api.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "project")
public class ProjectController {


    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService)
    {
        this.projectService = projectService;
    }

    //Get all projects
    @GetMapping()
    public List<Project> getAll()
    {
        return projectService.getAllProjects();
    }

    //create new project
//    @PostMapping()
//    public Project addProject(@RequestBody Project project)
//    {
//        Project createdProject = projectService.addProject(project);
//        return createdProject;
//    }

    //Get project by title
//    @GetMapping("{title}")
//    public Project getProject(@PathVariable String title) {
//        Project foundProject = projectService.findProjectByTitle(title);
//        return foundProject;
//    }

    //addTeacherToProject
//    @PostMapping("addTeacher")
//    public Project registerTeacher(@RequestParam Long teacherId, @RequestParam Long projectId)
//    {
//        Project createdProject = projectService.addTeacher(teacherId, projectId);
//        return createdProject;
//    }


}

package com.fontys_automotive.api.project;

import com.fontys_automotive.api.teacher.Teacher;
import com.fontys_automotive.api.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "project")
public class ProjectController {


    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("registerProject")
    public Project addProject(@RequestBody Project project)
    {
        System.out.println("KANKER");
        Project createdProject = projectService.addProject(project);
        return createdProject;
    }

    @GetMapping("getProject/{title}")
    public Project getProject(@PathVariable String title) {
        Project foundProject = projectService.findProjectByTitle(title);
        return foundProject;
    }

}

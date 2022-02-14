package com.fontys_automotive.api.teacher;

import com.fontys_automotive.api.respones.InvalidResponse;
import com.fontys_automotive.api.respones.Response;
import com.fontys_automotive.api.respones.ValidResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService _teacherService) {
        this.teacherService = _teacherService;
    }

    @GetMapping("getTeachers")
    public Response getTeachers()
    {
        return new ValidResponse(teacherService.getTeachers());

    }

    @PostMapping("registerTeacher")
    @ResponseBody
    public Response registerTeacher(@RequestBody Teacher teacher)
    {
        teacherService.addNewTeacher(teacher);
        Optional<Teacher> createdTeacher = teacherService.getTeacherByEmail(teacher.getEmail());
        if(createdTeacher.isPresent())
        {
            return new InvalidResponse("Teacher was not successfully created");
            //return new ValidResponse(createdTeacher);
        }
        else
        {
            return new InvalidResponse("Teacher was not successfully created");
        }
    }
}

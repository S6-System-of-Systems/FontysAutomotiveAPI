package com.fontys_automotive.api.teacher;

import com.fontys_automotive.api.exceptions.BadRequestException;
import com.fontys_automotive.api.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService _teacherService)
    {
        this.teacherService = _teacherService;
    }

    //Get all teachers
    @GetMapping()
    public List<Teacher> getTeachers()
    {
        return teacherService.getTeachers();
    }

    //Create teacher
    @PostMapping()
    public Teacher registerTeacher(@RequestBody Teacher teacher)
    {
         Teacher newTeacher = teacherService.addNewTeacher(teacher);
         return newTeacher;
    }

    //Get teacher by email
    @GetMapping("{email}")
    public Teacher getTeacher(@PathVariable String email)
    {
         Optional<Teacher> teacher = teacherService.getTeacherByEmail(email);
         if(teacher.isEmpty())
         {
             throw new NotFoundException("No teacher was found");
         }
         else
         {
             return teacher.get();
         }
    }
}

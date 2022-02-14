package com.fontys_automotive.api.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getTeachers()
    {
        return teacherRepository.findAll();
    }

    public Optional<Teacher> getTeacherByEmail(String email)
    {
        return teacherRepository.findTeacherByEmail(email);
    }

    public void addNewTeacher(Teacher teacher) {
        Optional<Teacher> foundTeacher = teacherRepository.findTeacherByEmail(teacher.getEmail());
        if(foundTeacher.isPresent()){
            //response
            throw new IllegalStateException("email taken");
        }
        teacherRepository.save(teacher);
    }
}

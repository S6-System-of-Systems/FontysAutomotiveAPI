package com.fontys_automotive.api.teacher;

import com.fontys_automotive.api.exceptions.BadRequestException;
import com.fontys_automotive.api.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public Optional<Teacher> getTeacherById(Long id)
    {
        Optional<Teacher> foundTeacher = teacherRepository.findById(id);
        if(foundTeacher.isEmpty())
        {
            throw new NotFoundException("teacher not found");
        }
        return foundTeacher;
    }


    public Teacher addNewTeacher(Teacher teacher) throws BadRequestException {
        Optional<Teacher> foundTeacher = teacherRepository.findTeacherByEmail(teacher.getEmail());
        if(foundTeacher.isPresent())
        {
            throw new BadRequestException("leraar bestaat al");
        }
        return teacherRepository.save(teacher);
    }
}

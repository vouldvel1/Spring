package com.vouldvell.spring.service;

import com.vouldvell.spring.Model.Student;

import java.time.LocalDate;
import java.util.List;

public interface StudentService {

    List<Student> FindAllStudents();

    /// Создание аккаунта
    Student CreateAccount(Student student);

    /// Сохранение студента
    Student SetInfoStudent(String login, String password, Student student);

    /// Поиск по имейлу
    Student findByEmail(String email);

    /// Поиск по индексу
    Student findByID(int id);

    /// Обновить данные
    Student updateStudent(Student student);

    /// Удалить студента
    void deleteStudent(int id);
}

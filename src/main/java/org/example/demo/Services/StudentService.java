package org.example.demo.Services;

import org.example.demo.Repository.Student;
import org.example.demo.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void AdministratorLogin(String login, String password) {
        if(login.equals("admin") && password.equals("admin")) {

        }
    }


    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student Create(Student student) {
        var std = studentRepository.findByLogin(student.getLogin());

        if (std.isPresent()) {
            throw new IllegalStateException("User already exists");
        }

        return studentRepository.save(student);
    }
    public void Delete(String login, String password) {
        studentRepository.delete(authenticate(login, password));
    }

    public void update(String login, String password, Student updatedStudent) {
        // Аутентифицируем пользователя
        Student authenticatedStudent = authenticate(login, password);

        // Обновляем поля аутентифицированного пользователя
        authenticatedStudent.setBirthday(updatedStudent.getBirthday());
        authenticatedStudent.setSurname(updatedStudent.getSurname());
        authenticatedStudent.setName(updatedStudent.getName());
        authenticatedStudent.setEmail(updatedStudent.getEmail());
        // Добавьте другие поля, которые нужно обновить

        // Сохраняем обновленные данные в базу данных
        studentRepository.save(authenticatedStudent);
    }

    public Student authenticate(String login, String password) {
        // Ищем пользователя по логину
        Optional<Student> optionalStudent = studentRepository.findByLogin(login);

        // Если пользователь не найден, выбрасываем исключение
        if (optionalStudent.isEmpty()) {
            throw new IllegalStateException("User does not exist");
        }

        Student studentObj = optionalStudent.get();

        // Проверяем пароль
        if (!studentObj.getLogin().equals(login) && !studentObj.getPassword().equals(password)) {
            throw new IllegalStateException("Wrong password");
        }

        return studentObj;
    }


}

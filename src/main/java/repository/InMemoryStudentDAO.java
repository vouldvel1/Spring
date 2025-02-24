package repository;

import com.vouldvell.spring.Model.Student;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryStudentDAO {

    private final List<Student> STUDENTS = new ArrayList<>();

    public List<Student> FindAllStudents() {
        return STUDENTS;
    }

    public Student CreateAccount(Student student) {
        STUDENTS.add(student);
        return student;
    }

    public Student SetInfoStudent(String login, String password, @RequestBody Student student) {
        var stud = STUDENTS.stream().filter(x -> x.getLogin().equals(login) && x.getPassword().equals(password)).findFirst().orElse(null);
        stud.SetInfo(student.getFirstName(), student.getLastName(), student.getDateOfBirth(), student.getEmail());
        return student;
    }

    public Student findByEmail(String email) {
        return STUDENTS.stream().
                filter(student -> student.getEmail().
                equals(email)).findFirst().orElse(null);
    }

    public Student findById(int id) {
        return STUDENTS.stream().
                filter(std -> std.getId() == id).findFirst().orElse(null);
    }

    public Student updateStudent(Student student) {

        var studentIndex = IntStream.range(0, STUDENTS.size()).
                filter(index -> STUDENTS.get(index).getEmail().
                equals(student.getEmail())).findFirst().orElse(-1);

        if(studentIndex > -1){
            STUDENTS.set(studentIndex, student);
        }

        return null;

    }

    public void deleteStudent(int id) {
        var student = findById(id);

        if (student != null) STUDENTS.remove(student);


    }
}

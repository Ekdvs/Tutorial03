package com.flower.practical_02.Controller;
import com.flower.practical_02.Model.Student;
import com.flower.practical_02.ServiceImplementation.StudentServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentServiceImplementation studentService;

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("/getAllStudent")
    public List<Student> getAllStudent() {
        return studentService.getAllStudents();
    }

    @GetMapping("/getStudentById/{id}")
    public Optional<Student> getStudentById(@PathVariable("id") Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/updateStudent/{id}")
    public Student updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        return studentService.updateStudent(student, id);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudentById(id);
    }

    @GetMapping("/getByYear/{YearOfEnrollment}")
    public ResponseEntity<List<Student>> getByYear(@PathVariable("YearOfEnrollment") String YearOfEnrollment) {
        List<Student> student=studentService.getStudentsByEnrolledYear(YearOfEnrollment);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    @GetMapping("/getByDepartment/{id}")
    public ResponseEntity<String> getByDepartmentById(@PathVariable("id") Long id) {
        String department= studentService.getDepartmentNameById(id);
        if(department!=null){
            return ResponseEntity.ok(department);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteByYear/{YearOfEnrollment}")
    public ResponseEntity<String> removeStudentsByEnrolmentYear(@PathVariable("YearOfEnrollment")String YearOfEnrollment){
        studentService.removeStudentsByEnrolmentYear(YearOfEnrollment);
        return ResponseEntity.ok("Studnets enrolled in "+YearOfEnrollment+"have benn deleted");
    }
}

package com.flower.practical_02.Repository;
import com.flower.practical_02.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

package com.flower.practical_02.Repository;
import com.flower.practical_02.Model.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.beans.Transient;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByYearOfEnrollment(String YearOfEnrollment);

    @Query("SELECT S.department FROM Student S WHERE S.id = :id")
    String findDepartmentNameById(Long id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Student s where s.yearOfEnrollment=:year_of_enrollment")
    void deleteByYearOfEnrollmentyear(@Param("year_of_enrollment") String yearOfEnrollment);
}

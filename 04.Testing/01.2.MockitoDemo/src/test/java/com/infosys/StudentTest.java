package com.infosys;

import com.infosys.Entity.Student;
import com.infosys.Service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StudentTest {
    StudentService studentService= Mockito.mock(StudentService.class);
    Student student= new Student(studentService);

    @Test
    void testAverage(){
        int expected=50;
        Mockito.when(studentService.getTotalMArks()).thenReturn(500);
        Mockito.when(studentService.getTotalStudents()).thenReturn(10);

        Assertions.assertEquals(expected,student.getAverageMarks());
    }
}

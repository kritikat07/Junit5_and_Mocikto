import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    void shouldReturnStudentWhenStudentExists() {

        Student student =
                new Student(1L, "Kritika", "CSE AIML");

        when(studentRepository.findById(1L))
                .thenReturn(Optional.of(student));

        Student result = studentService.getStudent(1L);

        assertNotNull(result);
        assertEquals("Kritika", result.getName());
        assertEquals("CSE AIML", result.getDepartment());

        verify(studentRepository).findById(1L);
    }
}

import java.util.Optional;

public interface StudentRepository {

    Optional<Student> findById(Long id);

    boolean existsById(Long id);
}
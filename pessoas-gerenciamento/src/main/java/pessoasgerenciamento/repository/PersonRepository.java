package pessoasgerenciamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pessoasgerenciamento.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}

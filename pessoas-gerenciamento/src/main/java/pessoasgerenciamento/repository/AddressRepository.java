package pessoasgerenciamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pessoasgerenciamento.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    public Address findByPersonId(Long personId);
}

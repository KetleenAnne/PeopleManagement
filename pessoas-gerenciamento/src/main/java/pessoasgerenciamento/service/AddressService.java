package pessoasgerenciamento.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pessoasgerenciamento.model.Address;
import pessoasgerenciamento.model.Person;
import pessoasgerenciamento.repository.AddressRepository;


@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    
    @Autowired
    private PersonService personService;

    public Address save(Address address){
        return addressRepository.save(address);
    }

    public Address findById(Long id){
        return addressRepository.findById(id).orElse(null);
    }

    public void delete(Long id){
        addressRepository.deleteById(id);
    }

    public Address update(Long id, Address address){
        Address address1 = addressRepository.findById(id).orElse(null);
        if(address1 == null){
            return null;
        }
        address.setId(address1.getId());
        return addressRepository.save(address);
    }

    public Address setPerson(Long id, Long personId) {
        Address address = addressRepository.findById(id).orElse(null);
        if (address == null) {
            return null;
        }
        Person person = personService.findById(personId);
        if (person == null) {
            return null;
        }
        address.setPerson(person);
        return addressRepository.save(address);
    }

}

package pessoasgerenciamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pessoasgerenciamento.model.Address;
import pessoasgerenciamento.model.Person;
import pessoasgerenciamento.repository.PersonRepository;

import java.util.List;


@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person save(Person person){
        return personRepository.save(person);
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public Person findById(Long id){
        return personRepository.findById(id).orElse(null);
    }

    public void delete(Long id){
        personRepository.deleteById(id);
    }

    public void setPrincipalAddress(Long id, Long addressId){
        Person person = personRepository.findById(id).orElse(null);
        if(person == null){
            return;
        }
        person.setPrincipalAddressId(addressId);
        personRepository.save(person);
    }

    public Person addAddress(Long id, Address address){
        Person person = personRepository.findById(id).orElse(null);
        if(person == null){
            return null;
        }
        person.getAddresses().add(address);
        return personRepository.save(person);
    }
}

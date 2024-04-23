package pessoasgerenciamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pessoasgerenciamento.dto.AddressDTO;
import pessoasgerenciamento.dto.PersonDTO;
import pessoasgerenciamento.model.Person;
import pessoasgerenciamento.service.PersonService;

import java.util.List;

@Controller
@RequestMapping("/api/pessoas")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping
    public List<PersonDTO> findAll() {
        return personService.findAll()
                .stream()
                .map(PersonDTO::fromEntity)
                .toList();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) {
        return PersonDTO.fromEntity(personService.findById(id));
    }

    @PostMapping
    public PersonDTO save(@RequestBody PersonDTO personDTO) {
        return PersonDTO.fromEntity(
                personService.save(personDTO.toEntity(personDTO)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        personService.delete(id);
    }

    @PostMapping("/{id}/addresses/{addressId}")
    public void setPrincipalAddress(@PathVariable Long id, @PathVariable Long addressId) {
        personService.setPrincipalAddress(id, addressId);
    }

    @PostMapping("/{id}/addresses")
    public PersonDTO addAddress(@PathVariable Long id, @RequestBody AddressDTO AddressDTO) {
        return PersonDTO.fromEntity(
                personService.addAddress(id, AddressDTO.toEntity(AddressDTO)));
    }
}

package pessoasgerenciamento.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import lombok.*;
import pessoasgerenciamento.model.Person;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {
    private Long id;
    private String fullName;
    private LocalDate birthDate;
    private List<AddressDTO> addresses;
    private Long principalAddressId;

    public static PersonDTO fromEntity(Person person) {
        PersonDTO dto = new PersonDTO();
        dto.setId(person.getId());
        dto.setFullName(person.getFullName());
        dto.setBirthDate(person.getBirthDate());
        dto.setAddresses(person.getAddresses().stream()
                .map(AddressDTO::fromEntity)
                .collect(Collectors.toList()));
        dto.setPrincipalAddressId(person.getPrincipalAddressId());
        return dto;
    }

    public Person toEntity(PersonDTO dto) {
        Person person = new Person();
        person.setId(dto.getId());
        person.setFullName(dto.getFullName());
        person.setBirthDate(dto.getBirthDate());
        person.setAddresses(dto.getAddresses().stream()
                .map(addressDTO -> addressDTO.toEntity(addressDTO))
                .collect(Collectors.toList()));
        person.setPrincipalAddressId(dto.getPrincipalAddressId());
        return person;
    }
}

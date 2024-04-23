package pessoasgerenciamento.dto;

import lombok.*;
import pessoasgerenciamento.model.Address;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private Long id;
    private String street;
    private String zipCode;
    private String number;
    private String city;
    private String state;

    public static AddressDTO fromEntity(Address address) {
        AddressDTO dto = new AddressDTO();
        dto.setId(address.getId());
        dto.setStreet(address.getStreet());
        dto.setZipCode(address.getZipCode());
        dto.setNumber(address.getNumber());
        dto.setCity(address.getCity());
        dto.setState(address.getState());
        return dto;
    }

    public Address toEntity(AddressDTO dto) {
        Address address = new Address();
        address.setId(dto.getId());
        address.setStreet(dto.getStreet());
        address.setZipCode(dto.getZipCode());
        address.setNumber(dto.getNumber());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        return address;
    }
}

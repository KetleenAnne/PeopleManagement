package pessoasgerenciamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pessoasgerenciamento.dto.AddressDTO;
import pessoasgerenciamento.service.AddressService;

@Controller
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/save")
    public AddressDTO save(@RequestBody AddressDTO addressDTO){
        return AddressDTO.fromEntity
                (addressService.save(addressDTO.toEntity(addressDTO)));

    }

    @DeleteMapping("/{id}")
    public void delete(@RequestBody Long id){
        addressService.delete(id);
    }

    @PostMapping("/{id}/person/{personId}")
    public AddressDTO setPerson(@RequestBody Long id, @RequestBody Long personId){
        return AddressDTO.fromEntity
                (addressService.setPerson(id, personId));
    }

    @PostMapping("/{id}")
    public AddressDTO findById(@RequestBody Long id){
        return AddressDTO.fromEntity
                (addressService.findById(id));
    }

    @PostMapping("/{id}/update")
    public AddressDTO update(@RequestBody Long id, @RequestBody AddressDTO addressDTO){
        return AddressDTO.fromEntity
                (addressService.update(id, addressDTO.toEntity(addressDTO)));
    }

}

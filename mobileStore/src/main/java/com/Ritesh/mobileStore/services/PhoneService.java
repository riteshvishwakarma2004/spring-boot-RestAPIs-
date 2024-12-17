package com.Ritesh.mobileStore.services;

import com.Ritesh.mobileStore.model.Phone;
import com.Ritesh.mobileStore.model.PhonesAddingResponse;
import com.Ritesh.mobileStore.repository.PhoneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneService {

    @Autowired
    private PhoneRepo repo;

    @Autowired
    private PhonesAddingResponse response;

    public PhonesAddingResponse addPhone(List<Phone> phones){
        int length = phones.size();
        for(Phone phone : phones ){
            length--;
            repo.save(phone);
        }
        if(length == 0){
            response.setPhones(phones);
            response.setMessage("Added successfully");
            return response;
        }else{
            response.setPhones(phones);
            response.setMessage("unsuccessful");
            return response;
        }

    }

    public List<Phone> findAll(String brand) {
        return repo.findBybrandName(brand);
    }

    public List<Phone> findAll() {
        return repo.findAll();
    }

    public Phone getPhone(String brand, String phone) {
        return repo.findBybrandNameAndphoneName(brand,phone);
    }

    public Optional<List<Phone>> searchPhonesByDetail(String detail) {
        Optional<List<Phone>>phone = repo.findByDetail(detail);
        System.out.println(phone);
                return phone;

    }
}

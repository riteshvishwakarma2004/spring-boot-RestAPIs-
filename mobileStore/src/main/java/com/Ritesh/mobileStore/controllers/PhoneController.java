package com.Ritesh.mobileStore.controllers;

import com.Ritesh.mobileStore.model.Phone;
import com.Ritesh.mobileStore.model.PhonesAddingResponse;
import com.Ritesh.mobileStore.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PhoneController {

    @Autowired
    private PhoneService service;


    //addind phone of any brand
//    @PostMapping("/{brand}/phone")
//    public Phone addPhone(@RequestBody Phone phone){
//        System.out.println("entered");
//        Phone returnPhone = service.addPhone(phone);
//        return returnPhone;
//    }

    //addind phone of any brand
    @PostMapping("/{brand}/phone")
    public PhonesAddingResponse addPhone(@RequestBody List<Phone> phone){
        System.out.println("entered");
        PhonesAddingResponse response = service.addPhone(phone);
        return response;
    }

    @GetMapping("/phones")
    public List<Phone> getAllPhones(){
        List<Phone> phones = service.findAll();
        return phones;
    }

    //fetch all phones of a brand
    @GetMapping("/{brand}")
    public List<Phone> getAllByBrand(@PathVariable("brand") String brand){
        List<Phone> phones = service.findAll(brand);
        return phones;
    }

    //fetch details of a single phone of a brand
    @GetMapping("/{brand}/{phone}")
    public Phone getPhone(@PathVariable("brand") String brand, @PathVariable("phone") String phone){
        Phone returnPhone = service.getPhone(brand,phone);
        return returnPhone;
    }
}

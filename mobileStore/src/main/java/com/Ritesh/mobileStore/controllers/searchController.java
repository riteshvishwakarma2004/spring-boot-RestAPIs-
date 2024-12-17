package com.Ritesh.mobileStore.controllers;


import com.Ritesh.mobileStore.model.Phone;
import com.Ritesh.mobileStore.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/search")
public class searchController {

    @Autowired
    private PhoneService service;


    @GetMapping("/{detail}")
    public ResponseEntity<Optional<List<Phone>>> searchPhones(@PathVariable("detail") String detail){
        Optional<List<Phone>> phone =  service.searchPhonesByDetail(detail);

       return ResponseEntity.ok(phone);


    }


}

package com.Ritesh.mobileStore.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PhonesAddingResponse {
    private List<Phone> phones;
    private String message;

    public PhonesAddingResponse() {
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

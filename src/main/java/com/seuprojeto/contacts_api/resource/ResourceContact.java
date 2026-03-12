package com.seuprojeto.contacts_api.resource;

import com.seuprojeto.contacts_api.entities.Contact;
import com.seuprojeto.contacts_api.services.ServiceContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class ResourceContact {
    @Autowired
    ServiceContact serviceContact;
    @GetMapping
    public ResponseEntity<List<Contact>> findAll() {
        List<Contact> contacts = serviceContact.findAll();
        return ResponseEntity.ok().body(contacts);
    }
    @GetMapping
    public ResponseEntity<Contact> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(serviceContact.findById(id));
    }
}

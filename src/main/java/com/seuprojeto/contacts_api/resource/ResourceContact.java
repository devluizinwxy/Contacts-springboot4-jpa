package com.seuprojeto.contacts_api.resource;

import com.seuprojeto.contacts_api.entities.Contact;
import com.seuprojeto.contacts_api.services.ServiceContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    public ResponseEntity<Contact> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(serviceContact.findById(id));
    }
    @PostMapping
    public ResponseEntity<Contact> insert(@RequestBody Contact contact){
        Contact contact1 = serviceContact.insert(contact);
        return ResponseEntity.ok().body(contact);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Contact> delete(@PathVariable Long id){
        serviceContact.delete(id);
        return ResponseEntity.noContent().build();
    }
 @PutMapping("/{id}")
    public ResponseEntity<Contact> update(@PathVariable Long id,@RequestBody Contact contact){
        Contact contact1 = serviceContact.update(contact,id);
        return ResponseEntity.ok().body(contact1);

 }
}

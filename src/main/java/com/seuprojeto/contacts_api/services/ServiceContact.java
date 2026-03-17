package com.seuprojeto.contacts_api.services;


import com.seuprojeto.contacts_api.entities.Contact;
import com.seuprojeto.contacts_api.repositories.ContactRepository;
import com.seuprojeto.contacts_api.services.exeptions.DatabaseException;
import com.seuprojeto.contacts_api.services.exeptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceContact {
    @Autowired
    ContactRepository contactRepository;

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Contact findById(Long id) {
        Optional<Contact> obj = contactRepository.findById(id);
        return obj.orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public void delete(Long id) {
        if (!contactRepository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
     try {
        contactRepository.deleteById(id);

     }catch (DataIntegrityViolationException e){
         throw new DatabaseException(e.getMessage());
     }
    }

    public Contact update(Contact obj, long id) {
        try {Contact entity = contactRepository.getReferenceById(id);
        updateData(entity, obj);
        return contactRepository.save(entity);}catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    public void updateData(Contact entity, Contact obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

    public Contact insert(Contact contact) {
        return contactRepository.save(contact);
    }
}

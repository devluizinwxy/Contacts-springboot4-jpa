package com.seuprojeto.contacts_api.services;


import com.seuprojeto.contacts_api.entities.Contact;
import com.seuprojeto.contacts_api.repositories.ContactRepository;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceContact {
    @Autowired
    ContactRepository contactRepository;
    public List<Contact> findAll(){
        return contactRepository.findAll();
    }
    public Contact findById(Long id){
       Optional<Contact> obj = contactRepository.findById(id);
        return obj.get();
    }
    public void delete(Long id){
        if (!contactRepository.existsById(id)){
            throw new IllegalArgumentException("erro");
        }
    }
    public void Insert(Contact obj,long id){
        Contact entity = contactRepository.getReferenceById(id);
        updateData(entity,obj);
        contactRepository.save(entity);
    }
    public void updateData(Contact entity, Contact obj){
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
    public Contact insert (Contact contact){
       return contactRepository.save(contact);
    }
}

package com.seuprojeto.contacts_api.repositories;

import com.seuprojeto.contacts_api.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {

}

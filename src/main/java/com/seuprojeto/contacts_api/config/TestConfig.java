package com.seuprojeto.contacts_api.config;

import com.seuprojeto.contacts_api.entities.Contact;
import com.seuprojeto.contacts_api.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
   @Autowired
    private ContactRepository contactRepository;

    @Override
    public void run(String... args) throws Exception {
        Contact contact = new Contact(null,"Luis Fernandes","luis@gmail.com","799999999","111111111");
        Contact contact2 = new Contact(null,"Joao Fernandes","luis@gmail.com","799999999","111111111");
        Contact contact3 = new Contact(null,"Lucas Fernandes","luis@gmail.com","799999999","111111111");
    }
}

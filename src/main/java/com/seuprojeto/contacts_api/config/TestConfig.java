package com.seuprojeto.contacts_api.config;

import com.seuprojeto.contacts_api.entities.Contact;
import com.seuprojeto.contacts_api.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
   @Autowired
    private ContactRepository contactRepository;

    @Override
    public void run(String... args) throws Exception {
        Contact c1 = new Contact(
                null,
                "Luis Fernandes",
                "luis@gmail.com",
                "(79) 99999-9999",
                "39053344705"
        );

        Contact c2 = new Contact(
                null,
                "Maria Silva",
                "maria@gmail.com",
                "(11) 98888-7777",
                "12345678909"
        );

        Contact c3 = new Contact(
                null,
                "Joao Santos",
                "joao@gmail.com",
                "(21) 97777-6666",
                "52998224725"
        );

        contactRepository.saveAll(Arrays.asList(c1, c2, c3));
    }
}

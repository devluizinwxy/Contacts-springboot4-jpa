package com.seuprojeto.contacts_api.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_contact")
public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @NotNull
    private String name;
    @Email
    private String email;

    private String phone;
    @CPF
    private String cpf;

    public Contact() {
    }

    public Contact(Long id, String name, String email, String phone, String cpf) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Contact contact = (Contact) object;
        return Objects.equals(id, contact.id) && Objects.equals(name, contact.name) && Objects.equals(email, contact.email) && Objects.equals(phone, contact.phone) && Objects.equals(cpf, contact.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, phone, cpf);
    }

}

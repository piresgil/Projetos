package com.daniel.bank.message_generator.model;


import jakarta.persistence.Table;

@Table(name = "tb_user", schema = "message_generator")
public class User {

    private String name;
    private String lastName;
    private String login;
    private Integer age;
}

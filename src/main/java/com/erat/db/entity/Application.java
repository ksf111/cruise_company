package com.erat.db.entity;

import java.sql.Date;

public class Application {
    String login, name, surname, status;
    Date birthdate;
    Long id;

    public Application() {
    }

    public Application(String login, String name, String surname, Date birtday) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.birthdate = birtday;
        this.status = "In progress";
        this.id = 0L;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Application{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birtday=" + birthdate +
                '}';
    }
}

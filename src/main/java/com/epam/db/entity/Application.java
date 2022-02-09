package com.epam.db.entity;

import java.sql.Date;

public class Application {
    String login, name, surname, status;
    Date birthdate;
    Long id, cruiseId;

    public Application() {
    }

    public Application(String login, String name, String surname, Date birthdate) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.status = "Pending";
        this.id = 0L;
        this.cruiseId = null;


    }

    public Long getCruiseId() {
        return cruiseId;
    }

    public void setCruiseId(Long cruiseId) {
        this.cruiseId = cruiseId;
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
                ", status='" + status + '\'' +
                ", cruiseId='" + cruiseId + '\'' +
                ", birthdate=" + birthdate +
                ", id=" + id +
                '}';
    }
}

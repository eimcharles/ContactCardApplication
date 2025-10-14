package org.eimc.contactcardapplication.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.util.Objects;

/*
 *       Contact Domain
 * */

@Entity
@Table(name = "contacts")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)                     // only includes fields whose values are different from their default values
public class Contact {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)          // Auto-incremented primary key
    @Column(name = "id", unique = true, updatable = false)
    private Long id;
    private String name;
    private String email;
    private String title;
    private String phoneNumber;
    private String location;
    private String status;
    private String photoURL;

    /*
     *       Parametrized Constructor
     * */

    public Contact(String name, String email, String title, String phoneNumber, String location, String status, String photoURL) {
        this.name = name;
        this.email = email;
        this.title = title;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.status = status;
        this.photoURL = photoURL;
    }

    /*
     *       No Args Constructor
     * */
    public Contact() {

    }

    /*
    *       Setters
    * */

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLocation(String city) {
        this.location = city;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    /*
     *       Getters
     * */

    public Long getId() {
        return id;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    /*
     *       Equals
     * */

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(id, contact.id) && Objects.equals(name, contact.name) &&
                Objects.equals(email, contact.email) && Objects.equals(title, contact.title) &&
                Objects.equals(phoneNumber, contact.phoneNumber) && Objects.equals(location, contact.location) &&
                Objects.equals(status, contact.status) && Objects.equals(photoURL, contact.photoURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, title, phoneNumber, location, status, photoURL);
    }
}

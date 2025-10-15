package org.eimc.contactcardapplication.repository;

import org.eimc.contactcardapplication.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
 *       Contact Repository
 * */

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    Optional<Contact> findById(Long id);            // May or may not contain a Contact object.

    Optional<Contact> findByNameAndEmailAndPhoneNumber(String name, String email, String phoneNumber);
}

package org.eimc.contactcardapplication.service;

import jakarta.transaction.Transactional;
import org.eimc.contactcardapplication.domain.Contact;
import org.eimc.contactcardapplication.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


/*
*   Service Class (Business Layer)
*
* */

@Service
@Transactional(rollbackOn = Exception.class)            // Rolls back transactions only for unchecked exceptions
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact createContact(Contact contact) {
        Optional<Contact> contactExists = contactRepository
                .findByNameAndEmailAndPhoneNumber(
                        contact.getName(),
                        contact.getEmail(),
                        contact.getPhoneNumber());

        if (contactExists.isPresent()) {
            throw new RuntimeException("Contact with the same name, email, and phone number already exists.");
        }

        return contactRepository.save(contact);
    }

    public Contact getContactById(long id) {
        return contactRepository.findById(id).orElseThrow(() -> new RuntimeException("Contact not found"));
    }

}

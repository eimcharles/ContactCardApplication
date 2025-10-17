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

    public void updateContactById(Long id, Contact contact) {

        Contact findContactByIdExists = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invalid entity primary key id: " + id + " not found"));

        Optional<Contact> contactExists = contactRepository
                .findByNameAndEmailAndPhoneNumber(
                        contact.getName(),
                        contact.getEmail(),
                        contact.getPhoneNumber());

        if (contactExists.isPresent()) {
            throw new RuntimeException("Contact with the same name, email, and phone number already exists.");
        }

        findContactByIdExists.setName(contact.getName());
        findContactByIdExists.setEmail(contact.getEmail());
        findContactByIdExists.setTitle(contact.getTitle());
        findContactByIdExists.setPhoneNumber(contact.getPhoneNumber());
        findContactByIdExists.setLocation(contact.getLocation());
        findContactByIdExists.setStatus(contact.getStatus());
        findContactByIdExists.setPhotoURL(contact.getPhotoURL());
        contactRepository.save(findContactByIdExists);
    }

    public void deleteContactById(Long id) {
        boolean findContactByIdExists = contactRepository.existsById(id);
        if (!findContactByIdExists) {
            throw new RuntimeException("Invalid contact id: " + id);
        }

        contactRepository.deleteById(id);
    }


}

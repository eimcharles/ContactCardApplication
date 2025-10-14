package org.eimc.contactcardapplication.service;

import jakarta.transaction.Transactional;
import org.eimc.contactcardapplication.repository.ContactRepository;
import org.springframework.stereotype.Service;


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
}

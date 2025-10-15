package org.eimc.contactcardapplication.resource;
/*
 *       Contact Ressource
 * */

import org.eimc.contactcardapplication.service.ContactService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
public class ContactResource {

    private final ContactService contactService;

    public ContactResource(ContactService contactService) {
        this.contactService = contactService;
    }
}

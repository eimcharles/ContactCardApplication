package org.eimc.contactcardapplication.resource;

import org.eimc.contactcardapplication.domain.Contact;
import org.eimc.contactcardapplication.service.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

/*
 *       Contact Ressource (Controller)
 * */

@RestController
@RequestMapping("/contacts")
public class ContactResource {

    private final ContactService contactService;

    public ContactResource(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        return ResponseEntity.created(URI.create("/contacts/userId/")).body(contactService.createContact(contact));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(contactService.getContactById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        contactService.deleteContactById(id);
        return ResponseEntity.noContent().build();
    }
}

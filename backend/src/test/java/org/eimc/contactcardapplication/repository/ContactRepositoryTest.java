package org.eimc.contactcardapplication.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest                                        // Loads JPA Components for testing
public class ContactRepositoryTest {

    @Autowired
    private ContactRepository contactRepository;

    @Test
    void testFindByEmail() {

        // Given

        // When

        // Then

    }
}

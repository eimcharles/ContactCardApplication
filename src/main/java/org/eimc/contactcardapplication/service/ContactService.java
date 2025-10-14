package org.eimc.contactcardapplication.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional(rollbackOn = Exception.class)            // Rolls back transactions only for unchecked exceptions
public class ContactService {

}

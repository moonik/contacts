package pl.roman.mysan.contacts.contact.asm;

import pl.roman.mysan.contacts.contact.domain.Contact;
import pl.roman.mysan.contacts.contact.domain.EmailAddress;
import pl.roman.mysan.contacts.contact.domain.PhoneNumber;
import pl.roman.mysan.contacts.contact.model.ContactDTO;
import pl.roman.mysan.contacts.contact.model.EmailAddressDTO;
import pl.roman.mysan.contacts.contact.model.PhoneNumberDTO;
import pl.roman.mysan.contacts.person.domain.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ContactAsm {

    public static Contact createEntityObject(ContactDTO contactDTO, Person person) {
        if (contactDTO instanceof PhoneNumberDTO) {
            return new PhoneNumber(person, ((PhoneNumberDTO) contactDTO).getValue());
        } else
            return new EmailAddress(person, ((EmailAddressDTO) contactDTO).getValue());
    }

    public static ContactDTO createDtoObject(Contact contact) {
        if (contact instanceof PhoneNumber) {
            return new PhoneNumberDTO(contact.getId(), ((PhoneNumber) contact).getValue());
        } else
            return new EmailAddressDTO(contact.getId(), ((EmailAddress) contact).getValue());
    }

    public static List<ContactDTO> collectContacts(List<EmailAddressDTO> emails, List<PhoneNumberDTO> phones) {
        List<ContactDTO> contacts = new ArrayList<>();
        contacts.addAll(emails);
        contacts.addAll(phones);
        return contacts;
    }
}

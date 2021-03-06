package pl.roman.mysan.contacts.person.asm;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.roman.mysan.contacts.contact.asm.ContactAsm;
import pl.roman.mysan.contacts.contact.domain.Contact;
import pl.roman.mysan.contacts.contact.model.ContactDTO;
import pl.roman.mysan.contacts.person.domain.Person;
import pl.roman.mysan.contacts.person.model.PersonDTO;
import pl.roman.mysan.contacts.person.model.PersonInfoDTO;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonAsm {

    public static Person createEntityObject(PersonDTO personDTO) {
        return Person.builder()
                .name(personDTO.getName())
                .surname(personDTO.getSurname())
                .gender(personDTO.getGender())
                .birthDate(personDTO.getBirthDate())
                .pesel(personDTO.getPesel())
                .build();
    }

    public static PersonInfoDTO createPersonInfoDto(Person person) {
        return PersonInfoDTO.builder()
                .id(person.getId())
                .name(person.getName())
                .surname(person.getSurname())
                .gender(person.getGender())
                .birthDate(person.getBirthDate().toString())
                .pesel(person.getPesel())
                .contacts(convertContactsToDto(person.getContacts()))
                .build();
    }

    private static List<ContactDTO> convertContactsToDto(List<Contact> contacts) {
        return contacts.stream()
                .map(ContactAsm::createDtoObject)
                .collect(Collectors.toList());
    }
}

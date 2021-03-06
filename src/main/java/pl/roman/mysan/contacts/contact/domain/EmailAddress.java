package pl.roman.mysan.contacts.contact.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Pattern;

import static pl.roman.mysan.contacts.common.ApplicationConstants.EMAIL_PATTERN;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("email")
@NoArgsConstructor
@Getter @Setter
public class EmailAddress extends Contact {

    @Pattern(regexp= EMAIL_PATTERN)
    @Column(unique = true)
    private String email;

    public EmailAddress(String email) {
        this.email = email;
    }

    @Override
    public void edit(String value) {
        this.email = value;
    }
}

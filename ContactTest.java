package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContactTest {

    @Test
    void testContact() {
        Contact contact = new Contact(
                "12345",
                "Ilianna",
                "Chavez",
                "6615551234",
                "123 Main Street");

        assertEquals("12345", contact.getContactId());
        assertEquals("Ilianna", contact.getFirstName());
        assertEquals("Chavez", contact.getLastName());
        assertEquals("6615551234", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }
    
    @Test
    void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Ilianna", "Chavez",
                    "6615551234", "123 Main Street");
        });
    }

    @Test
    void testContactIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Ilianna", "Chavez",
                    "6615551234", "123 Main Street");
        });
    }

    @Test
    void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "IliannaLong", "Chavez",
                    "6615551234", "123 Main Street");
        });
    }

    @Test
    void testFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Chavez",
                    "6615551234", "123 Main Street");
        });
    }

    @Test
    void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ilianna", "ChavezLongName",
                    "6615551234", "123 Main Street");
        });
    }

    @Test
    void testLastNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ilianna", null,
                    "6615551234", "123 Main Street");
        });
    }

    @Test
    void testPhoneTooShort() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ilianna", "Chavez",
                    "661555123", "123 Main Street");
        });
    }

    @Test
    void testPhoneNotDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ilianna", "Chavez",
                    "66155ABCDE", "123 Main Street");
        });
    }

    @Test
    void testPhoneNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ilianna", "Chavez",
                    null, "123 Main Street");
        });
    }

    @Test
    void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ilianna", "Chavez",
                    "6615551234",
                    "123 This Address Is Definitely Way Too Long");
        });
    }

    @Test
    void testAddressNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ilianna", "Chavez",
                    "6615551234", null);
        });
    }
}
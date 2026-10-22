package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

    @Test
    void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact(
                "12345", "Ilianna", "Chavez",
                "6615551234", "123 Main Street");

        assertDoesNotThrow(() -> service.addContact(contact));
    }

    @Test
    void testAddDuplicateContact() {
        ContactService service = new ContactService();

        Contact contact1 = new Contact(
                "12345", "Ilianna", "Chavez",
                "6615551234", "123 Main Street");

        Contact contact2 = new Contact(
                "12345", "John", "Smith",
                "6615555678", "456 Main Street");

        service.addContact(contact1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact(
                "12345", "Ilianna", "Chavez",
                "6615551234", "123 Main Street");

        service.addContact(contact);

        assertDoesNotThrow(() -> service.deleteContact("12345"));
    }

    @Test
    void testDeleteContactNotFound() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("99999");
        });
    }

    @Test
    void testUpdateFirstName() {
        ContactService service = new ContactService();
        Contact contact = new Contact(
                "12345", "Ilianna", "Chavez",
                "6615551234", "123 Main Street");

        service.addContact(contact);
        service.updateFirstName("12345", "Illy");

        assertEquals("Illy", contact.getFirstName());
    }

    @Test
    void testUpdateLastName() {
        ContactService service = new ContactService();
        Contact contact = new Contact(
                "12345", "Ilianna", "Chavez",
                "6615551234", "123 Main Street");

        service.addContact(contact);
        service.updateLastName("12345", "Smith");

        assertEquals("Smith", contact.getLastName());
    }

    @Test
    void testUpdatePhone() {
        ContactService service = new ContactService();
        Contact contact = new Contact(
                "12345", "Ilianna", "Chavez",
                "6615551234", "123 Main Street");

        service.addContact(contact);
        service.updatePhone("12345", "6615559999");

        assertEquals("6615559999", contact.getPhone());
    }

    @Test
    void testUpdateAddress() {
        ContactService service = new ContactService();
        Contact contact = new Contact(
                "12345", "Ilianna", "Chavez",
                "6615551234", "123 Main Street");

        service.addContact(contact);
        service.updateAddress("12345", "456 Oak Street");

        assertEquals("456 Oak Street", contact.getAddress());
    }
}
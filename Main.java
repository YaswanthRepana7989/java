import java.util.ArrayList;
import java.util.List;

class Contact {
    String name;
    String phoneNumber;
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public void display() {
        System.out.println("Name: " + name + ", Phone: " + phoneNumber);
    }
}
class Phonebook {
    private List<Contact> contacts;
    public Phonebook() {
        contacts = new ArrayList<>();
    }
    public void addContact(Contact contact) {
        contacts.add(contact);
    }
    public void bubbleSort() {
        int n = contacts.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (contacts.get(j).name.compareTo(contacts.get(j + 1).name) > 0) {
                    Contact temp = contacts.get(j);
                    contacts.set(j, contacts.get(j + 1));
                    contacts.set(j + 1, temp);
                }
            }
        }
    }
    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            for (Contact contact : contacts) {
                contact.display();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.addContact(new Contact("Yaswanth", "7989748050"));
        phonebook.addContact(new Contact("Raja", "9704451483"));
        phonebook.addContact(new Contact("Sabeel", "9989889335"));
        System.out.println("Contacts before sorting:");
        phonebook.displayContacts();
        phonebook.bubbleSort();
        System.out.println("\nContacts after sorting:");
        phonebook.displayContacts();
    }
}




/* output:
Contacts before sorting:
Name: Yaswanth, Phone: 7989748050
Name: Raja, Phone: 9704451483
Name: Sabeel, Phone: 9989889335

Contacts after sorting:
Name: Raja, Phone: 9704451483
Name: Sabeel, Phone: 9989889335
Name: Yaswanth, Phone: 7989748050
    */

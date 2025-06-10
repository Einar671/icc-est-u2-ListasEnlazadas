package controller;
import model.LinkedList;
import model.Contact;
public class ContactManager{
    private LinkedList<Contact<String,String>> contacts;

    public ContactManager(){
        this.contacts=new LinkedList<>();
    }
    public void addContacts(Contact<String,String> contact){
        Contact contact2 = new Contact("Alicia", "123-456-7890");
        addInitialContact("Roberto", "987-654-3210");
        addInitialContact("Carla", "555-111-2222");
        addInitialContact("Diego", "444-333-2222");
        addInitialContact("Elena", "777-888-9999");
        contacts.appendToTail(contact);
    }

    public Contact<String, String> findContactByName(String name) {
        Contact contact = new Contact(name,null);
        Contact contact2 = contacts.findByValue(contact);
        if(contact2==null) return null;
        return contact2;
    }
    
    public void deleteContactByName(String name){
        Contact contact = new Contact(name,null);
        contacts.deleteNode(findContactByName(name));
    }

    public void printList(){
        contacts.print();
    }

}
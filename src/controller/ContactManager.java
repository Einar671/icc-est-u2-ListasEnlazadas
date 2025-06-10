package controller;
import model.LinkedList;
import model.Contact;
public class ContactManager{
    private LinkedList<Contact<String,String>> contacts;

    public ContactManager(){
        this.contacts=new LinkedList<>();
        Contact<String, String> contact2 = new Contact<String, String>("Alicia", "123-456-7890");
        Contact<String, String> contact3= new Contact<String, String>("Roberto", "987-654-3210");
        Contact<String, String> contact4 = new Contact<String, String>("Carla", "555-111-2222");
        Contact<String, String> contact5 = new Contact<String, String>("Diego", "444-333-2222");
        Contact<String, String> contact6 = new Contact<String, String>("Elena", "777-888-9999");
        contacts.appendToTail(contact6);
        contacts.appendToTail(contact5);
        contacts.appendToTail(contact4);
        contacts.appendToTail(contact3);
        contacts.appendToTail(contact2);

    }
    public void addContacts(Contact<String,String> contact){

        contacts.appendToTail(contact);
    }

    public Contact<String, String> findContactByName(String name) {
        Contact<String, String> contact = new Contact<String, String>(name,null);
        Contact<String, String> contact2 = contacts.findByValue(contact);
        if(contact2==null) return null;
        return contact2;
    }
    
    public void deleteContactByName(String name){
        contacts.deleteNode(findContactByName(name));
    }

    public void printList(){
        contacts.print();
    }

}
package controller;
import model.LinkedList;
import model.Contact;
public class ContactManager{
    private LinkedList<Contact<String,String>> contacts;

    public ContactManager(){
        this.contacts=new LinkedList<>();
    }
    public void addContacts(Contact<String,String> contact){
        contacts.appendToTail(contact);
    }

    public Contact<String, String> findContactByName(String name) {
    }
    
    public void deleteContactByName(String name){

    }

    public void printList(){
        contacts.print();
    }

}
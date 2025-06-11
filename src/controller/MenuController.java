package controller;

import model.Contact; 
import view.ConsoleView;

public class MenuController {
    private ContactManager contactManager;
    private ConsoleView consoleView;

    public MenuController() { 
        this.consoleView = new ConsoleView();
        this.contactManager = new ContactManager(); 
        contactManager.printList(); 
    }

    public void start() {
        int option;
        do {
            consoleView.displayMenu();
            String input = consoleView.getInput("Opción: ");
            option = Integer.parseInt(input); 
            
            handleMenuOption(option);
            
        } while (option != 5);

        consoleView.closeScanner();
    }

    private void handleMenuOption(int option) {
        switch (option) {
            case 1: 
                addContact();
                break;
            case 2: 
                findContact();
                break;
            case 3:
                deleteContact();
                break;
            case 4:
                printList();
                break;
            case 5: 
                consoleView.showMessage("Saliendo del programa. ¡Hasta luego!");
                break;
            default:
                consoleView.showMessage("Opción no válida. Por favor, intente de nuevo.");
                break;
        }
    }

    private void addContact() {
        String name = consoleView.getInput("Ingrese el nombre del contacto: ");
        String phone = consoleView.getInput("Ingrese el número de teléfono: ");

        Contact<String, String> newContact = new Contact<String, String>(name, phone);

        if (contactManager.findContactByName(name) != null) {
            consoleView.showMessage("Error: El contacto '" + name + "' ya existe.");
        } else {
            contactManager.addContacts(newContact); 
            consoleView.showMessage("Contacto '" + name + "' añadido exitosamente.");
        }
    }

    private void findContact() {
        String nameToFind = consoleView.getInput("Ingrese el nombre del contacto a buscar: ");
        Contact<String, String> foundContact = contactManager.findContactByName(nameToFind);
        if (foundContact != null) {
            consoleView.showMessage("Contacto encontrado: " + foundContact);
        } else {
            consoleView.showMessage("Contacto '" + nameToFind + "' no encontrado.");
        }
    }

    private void deleteContact() {
        String nameToDelete = consoleView.getInput("Ingrese el nombre del contacto a eliminar: ");
        
        if (contactManager.findContactByName(nameToDelete) != null) { 

            contactManager.deleteContactByName(nameToDelete); 
            consoleView.showMessage("Contacto '" + nameToDelete + "' eliminado exitosamente.");
        } else {
            consoleView.showMessage("Error: El contacto '" + nameToDelete + "' no existe para ser eliminado.");
        }
    }

    private void printList() {
        consoleView.showMessage("\n--- Lista de Contactos ---");
        contactManager.printList();
        consoleView.showMessage("--------------------------");
    }
}
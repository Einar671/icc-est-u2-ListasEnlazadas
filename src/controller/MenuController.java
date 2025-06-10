package controller;

import model.Contact; 
import view.ConsoleView;

public class MenuController {
    private ContactManager contactManager;
    private ConsoleView consoleView;

    public MenuController() { 
        this.consoleView = new ConsoleView();
        this.contactManager = new ContactManager(); 
        System.out.println("\n>>> Contactos iniciales en la lista:");
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
            case 1: // Añadir Contacto
                addContact();
                break;
            case 2: // Buscar Contacto
                findContact();
                break;
            case 3: // Eliminar Contacto
                deleteContact();
                break;
            case 4: // Mostrar Todos los Contactos
                printList();
                break;
            case 5: // Salir
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

        Contact newContact = new Contact(name, phone);

        // findContactByName del ContactManager devuelve Contact<String, String> o null
        if (contactManager.findContactByName(name) != null) {
            consoleView.showMessage("Error: El contacto '" + name + "' ya existe.");
        } else {
            // CORRECCIÓN: Llamada a addContacts (en plural) según tu ContactManager
            contactManager.addContacts(newContact); // <--- AJUSTE AQUÍ
            consoleView.showMessage("Contacto '" + name + "' añadido exitosamente.");
        }
    }

    private void findContact() {
        String nameToFind = consoleView.getInput("Ingrese el nombre del contacto a buscar: ");
        // findContactByName del ContactManager devuelve Contact<String, String>
        Contact foundContact = contactManager.findContactByName(nameToFind);
        if (foundContact != null) {
            consoleView.showMessage("Contacto encontrado: " + foundContact);
        } else {
            consoleView.showMessage("Contacto '" + nameToFind + "' no encontrado.");
        }
    }

    private void deleteContact() {
        String nameToDelete = consoleView.getInput("Ingrese el nombre del contacto a eliminar: ");
        
        // findContactByName del ContactManager devuelve Contact<String, String>
        if (contactManager.findContactByName(nameToDelete) != null) { // Verifica existencia
            // Llamada directa a deleteContactByName, que a su vez llama a deleteNode.
            // OJO: Si el contacto no existe, findContactByName devolverá null,
            // y deleteContactByName en tu ContactManager llamará a deleteNode(null),
            // lo que podría causar un NullPointerException en LinkedList.
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
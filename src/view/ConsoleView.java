package view;
import java.util.Scanner;

public class ConsoleView{
    private Scanner scanner;
    
    public ConsoleView(){
        this.scanner = new Scanner(System.in);
    }
    public void displayMenu(){
        System.out.println();
        System.out.println("╔══════════════════════════╗");
        System.out.println("║      AGENDA DE CONTACTOS ║");
        System.out.println("╠══════════════════════════╣");
        System.out.println("║ 1. Agregar contacto      ║");
        System.out.println("║ 2. Buscar contacto       ║");
        System.out.println("║ 3. Eliminar contacto     ║");
        System.out.println("║ 4. Salir                 ║");
        System.out.println("╚══════════════════════════╝");
        System.out.println();
        System.out.print("Seleccione una opción: ");
    }

    public String getInput(String promp){
        return scanner.nextLine();
    }

    public void showMessage(String message){
        System.out.println(message);
    }
}
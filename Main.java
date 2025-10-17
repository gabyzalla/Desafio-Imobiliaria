import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        GerenciadorImoveis gerenciador = new GerenciadorImoveis(); 
        
        MenuImobiliaria menu = new MenuImobiliaria(gerenciador, scanner);

        menu.iniciar(); 
        
        scanner.close();
    }
}
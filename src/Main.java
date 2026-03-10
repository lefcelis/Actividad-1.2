import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Pila principal para almacenar el texto escrito
        Stack pilaPrincipal = new Stack();

        // Pila secundaria para almacenar acciones deshechas para rehacer
        Stack pilaSecundaria = new Stack();

        // Scanner para leer datos desde la consola
        Scanner scanner = new Scanner(System.in);

        int opcion;

        // Menú principal del programa
        do {

            System.out.println("\n===== EDITOR DE TEXTO =====");
            System.out.println("1. Escribir texto");
            System.out.println("2. Deshacer (Undo)");
            System.out.println("3. Rehacer (Redo)");
            System.out.println("4. Mostrar texto actual");
            System.out.println("5. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    // Permite ingresar una nueva línea de texto
                    System.out.print("Ingrese una línea de texto: ");
                    String texto = scanner.nextLine();

                    // Se guarda en la pila principal
                    pilaPrincipal.push(texto);

                    // Al escribir algo nuevo se limpia la pila de redo
                    pilaSecundaria = new Stack();

                    System.out.println("Texto agregado.");
                    break;

                case 2:

                    // Deshace la última acción
                    if (!pilaPrincipal.isEmpty()) {

                        String eliminado = pilaPrincipal.pop();
                        pilaSecundaria.push(eliminado);

                        System.out.println("Última acción deshecha.");

                    } else {

                        System.out.println("No hay acciones para deshacer.");

                    }

                    break;

                case 3:

                    // Rehace la última acción deshecha
                    if (!pilaSecundaria.isEmpty()) {

                        String restaurado = pilaSecundaria.pop();
                        pilaPrincipal.push(restaurado);

                        System.out.println("Acción rehecha.");

                    } else {

                        System.out.println("No hay acciones para rehacer.");

                    }

                    break;

                case 4:

                    // Muestra el contenido actual del editor
                    System.out.println("\n--- Texto actual ---");

                    if (pilaPrincipal.isEmpty()) {

                        System.out.println("(sin texto)");

                    } else {

                        System.out.println(pilaPrincipal);

                    }

                    break;

                case 5:

                    // Finaliza el programa
                    System.out.println("Saliendo del programa...");
                    break;

                default:

                    // Manejo de opción incorrecta
                    System.out.println("Opción inválida.");

            }

        } while (opcion != 5);

        // Cierra el scanner
        scanner.close();
    }
}
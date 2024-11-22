package GomezPalaciosDaniela;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends JFrame {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        Motocicleta motocicleta = new Motocicleta();
        Arriendo arriendo = new Arriendo();
    }
    //Menú
    int opcion;
    do {
        System.out.println("**** MotoRenta ****");
        System.out.println("1. Gestión de Clientes");
        System.out.println("2. Gestión de Motocicletas");
        System.out.println("3. Gestión de Arrendamientos");
        System.out.println("4. Despliegue de Reportes");
        System.out.println("5. Salir");
        System.out.print("Ingrese una opción: ");
        opcion = leerOpcion();

        switch (opcion) {
            case 1:
                gestionClientes(cliente);
                break;
            case 2:
                gestionMotocicletas(motocicleta);
                break;
            case 3:
                gestionArriendos(cliente, motocicleta, arriendo);
                break;
            case 4:
                despliegueReportes(arriendo);
                break;
            case 5:
                System.out.println("¡Hasta luego!");
                break;
            default:
                System.out.println("Opción inválida. Intente de nuevo.");
        }
    } while (opcion != 5);


private static int leerOpcion() {
    // Lógica para leer la opción del usuario
}
private static void gestionClientes(Cliente cliente) {
    // Llamada a los métodos de la clase Cliente
    cliente.agregarCliente();
    cliente.eliminarCliente();
    cliente.modificarCliente();
}

private static void gestionMotocicletas(Motocicleta motocicleta) {
    // Llamada al método de la clase Motocicleta
    motocicleta.registrarMotocicleta();
}

private static void gestionArriendos(Cliente cliente, Motocicleta motocicleta, Arriendo arriendo) {
    // Llamada al método de la clase Arriendo
    arriendo.realizarArriendo();
}

private static void despliegueReportes(Arriendo arriendo) {
    // Llamada a los métodos de la clase Arriendo para generar reportes
    arriendo.listarArriendosAlta();
    arriendo.listarArriendosBaja();
}

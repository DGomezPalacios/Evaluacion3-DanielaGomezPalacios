package GomezPalaciosDaniela;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    private String rut;
    private String nombreCompleto;
    private String telefono;
    private String correo;

    private static ArrayList<Cliente> clientes = new ArrayList<>();
    //Constructor
    public Cliente() {
    }
    //Constructor con parámetros
    public Cliente(String rut, String nombreCompleto, String telefono, String correo) {
        this.rut = rut;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.correo = correo;
    }
    //Getters y Setters
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    //To String
    @Override
    public String toString() {
        return "Cliente{" +
                "rut='" + rut + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }

    //Metodos
    public void agregarCliente(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese rut:");
        String rut= scanner.nextLine();
        System.out.println("Ingrese nombre completo:");
        String nombreCompleto = scanner.nextLine();
        System.out.println("Ingrese Teléfono:");
        String telefono = scanner.nextLine();
        System.out.println("Ingrese Correo:");
        String correo = scanner.nextLine();

        clientes.add(new Cliente(rut, nombreCompleto, telefono, correo));
        System.out.println("Cliente agregado exitosamente.");
    }
    public void eliminarCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese RUT del cliente a eliminar:");
        String rut = sc.nextLine();
        clientes.removeIf(cliente -> cliente.rut.equals(rut));
        System.out.println("Cliente eliminado, si existía.");
    }
    public void modificarCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese RUT del cliente a modificar:");
        String rut = sc.nextLine();

        for (Cliente cliente : clientes) {
            if (cliente.rut.equals(rut)) {
                System.out.println("Ingrese Nuevo Nombre:");
                cliente.nombreCompleto = sc.nextLine();
                System.out.println("Ingrese Nuevo Teléfono:");
                cliente.telefono = sc.nextLine();
                System.out.println("Ingrese Nuevo Correo:");
                cliente.correo = sc.nextLine();
                System.out.println("Cliente modificado exitosamente.");
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }
}

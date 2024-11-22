package GomezPalaciosDaniela;

import javax.swing.*;
import java.util.ArrayList;

public class Cliente {
    private String rut;
    private String nombreCompleto;
    private String telefono;
    private String correo;
    private static ArrayList<Cliente> clientes = new ArrayList<>();

    public Cliente(String rut, String nombreCompleto, String telefono, String correo) {
        this.rut = rut;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.correo = correo;
    }

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    //Metodos
    public static void agregarCliente() {
        JTextField campoRut = new JTextField();
        JTextField campoNombre = new JTextField();
        JTextField campoTelefono = new JTextField();
        JTextField campoCorreo = new JTextField();

        Object[] mensaje = {
                "RUT:", campoRut,
                "Nombre Completo:", campoNombre,
                "Teléfono:", campoTelefono,
                "Correo Electrónico:", campoCorreo
        };

        int opcion = JOptionPane.showConfirmDialog(null, mensaje, "Agregar Cliente", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            try {
                String rut = campoRut.getText();
                String nombre = campoNombre.getText();
                String telefono = campoTelefono.getText();
                String correo = campoCorreo.getText();

                if (rut.isEmpty() || nombre.isEmpty() || telefono.isEmpty() || correo.isEmpty()) {
                    throw new IllegalArgumentException("Todos los campos son obligatorios.");
                }

                Cliente nuevoCliente = new Cliente(rut, nombre, telefono, correo);
                clientes.add(nuevoCliente);
                JOptionPane.showMessageDialog(null, "Cliente agregado exitosamente.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void eliminarCliente() {
        JComboBox<Cliente> comboClientes = new JComboBox<>(clientes.toArray(new Cliente[0]));
        int opcion = JOptionPane.showConfirmDialog(null, comboClientes, "Seleccione Cliente a Eliminar", JOptionPane.OK_CANCEL_OPTION);

        if (opcion == JOptionPane.OK_OPTION) {
            Cliente seleccionado = (Cliente) comboClientes.getSelectedItem();
            if (seleccionado != null) {
                clientes.remove(seleccionado);
                JOptionPane.showMessageDialog(null, "Cliente eliminado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se seleccionó ningún cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void modificarCliente() {
        JComboBox<Cliente> comboClientes = new JComboBox<>(clientes.toArray(new Cliente[0]));
        int opcion = JOptionPane.showConfirmDialog(null, comboClientes, "Seleccione Cliente a Modificar", JOptionPane.OK_CANCEL_OPTION);

        if (opcion == JOptionPane.OK_OPTION) {
            Cliente seleccionado = (Cliente) comboClientes.getSelectedItem();
            if (seleccionado != null) {
                JTextField campoRut = new JTextField(seleccionado.rut);
                JTextField campoNombre = new JTextField(seleccionado.nombreCompleto);
                JTextField campoTelefono = new JTextField(seleccionado.telefono);
                JTextField campoCorreo = new JTextField(seleccionado.correo);

                Object[] mensaje = {
                        "RUT:", campoRut,
                        "Nombre Completo:", campoNombre,
                        "Teléfono:", campoTelefono,
                        "Correo Electrónico:", campoCorreo
                };

                int modificar = JOptionPane.showConfirmDialog(null, mensaje, "Modificar Cliente", JOptionPane.OK_CANCEL_OPTION);
                if (modificar == JOptionPane.OK_OPTION) {
                    try {
                        seleccionado.rut = campoRut.getText();
                        seleccionado.nombreCompleto = campoNombre.getText();
                        seleccionado.telefono = campoTelefono.getText();
                        seleccionado.correo = campoCorreo.getText();

                        JOptionPane.showMessageDialog(null, "Cliente modificado exitosamente.");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error al modificar cliente.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se seleccionó ningún cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public String toString() {
        return nombreCompleto + " (" + rut + ")";
    }
}

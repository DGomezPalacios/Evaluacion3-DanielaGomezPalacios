package GomezPalaciosDaniela;

import javax.swing.*;
import java.util.ArrayList;

public class Arriendo {
    private String fecha;
    private String hora;
    private double valorArriendo;
    private Cliente cliente;
    private Motocicleta motocicleta;
    private static ArrayList<Arriendo> arriendos = new ArrayList<>();

    public Arriendo(String fecha, String hora, double valorArriendo, Cliente cliente, Motocicleta motocicleta) {
        this.fecha = fecha;
        this.hora = hora;
        this.valorArriendo = valorArriendo;
        this.cliente = cliente;
        this.motocicleta = motocicleta;
    }

    public static void realizarArriendo() {
        // Formularios para ingresar datos
        JTextField campoFecha = new JTextField();
        JTextField campoHora = new JTextField();
        JTextField campoValor = new JTextField();
        JComboBox<Cliente> comboClientes = new JComboBox<>(Cliente.getClientes().toArray(new Cliente[0]));
        JComboBox<Motocicleta> comboMotocicletas = new JComboBox<>(Motocicleta.getMotocicletas().toArray(new Motocicleta[0]));

        Object[] mensaje = {
                "Fecha (dd-mm-aaaa):", campoFecha,
                "Hora (hh:mm):", campoHora,
                "Valor del Arriendo:", campoValor,
                "Cliente:", comboClientes,
                "Motocicleta:", comboMotocicletas
        };

        int opcion = JOptionPane.showConfirmDialog(null, mensaje, "Realizar Arriendo", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            try {
                String fecha = campoFecha.getText();
                String hora = campoHora.getText();
                double valorArriendo = Double.parseDouble(campoValor.getText());
                Cliente clienteSeleccionado = (Cliente) comboClientes.getSelectedItem();
                Motocicleta motocicletaSeleccionada = (Motocicleta) comboMotocicletas.getSelectedItem();

                Arriendo nuevoArriendo = new Arriendo(fecha, hora, valorArriendo, clienteSeleccionado, motocicletaSeleccionada);
                arriendos.add(nuevoArriendo);

                JOptionPane.showMessageDialog(null, "Arriendo registrado exitosamente.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese datos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void listarArriendos() {
        StringBuilder datos = new StringBuilder("Arriendos Registrados:\n");
        for (Arriendo arriendo : arriendos) {
            datos.append("Fecha: ").append(arriendo.fecha).append("\n")
                    .append("Hora: ").append(arriendo.hora).append("\n")
                    .append("Valor: $").append(arriendo.valorArriendo).append("\n")
                    .append("Cliente: ").append(arriendo.cliente.getNombreCompleto()).append("\n")
                    .append("Motocicleta: ").append(arriendo.motocicleta.getModelo()).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, datos.toString(), "Lista de Arriendos", JOptionPane.INFORMATION_MESSAGE);
    }
}

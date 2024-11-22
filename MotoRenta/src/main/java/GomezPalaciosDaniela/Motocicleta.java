package GomezPalaciosDaniela;

import javax.swing.*;
import java.util.ArrayList;

public class Motocicleta {
    private String patente;
    private String marca;
    private String modelo;
    private int maxVelocidad;
    private int cilindrada;
    private int rendimiento;
    private boolean abs;
    private static ArrayList<Motocicleta> motocicletas = new ArrayList<>();

    public Motocicleta(String patente, String marca, String modelo, int maxVelocidad, int cilindrada, int rendimiento, boolean abs) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.maxVelocidad = maxVelocidad;
        this.cilindrada = cilindrada;
        this.rendimiento = rendimiento;
        this.abs = abs;
    }
    public static ArrayList<Motocicleta> getMotocicletas() {
        return motocicletas;
    }


    public String getModelo() {
        return modelo;
    }

//Metodos

    public static void registrarMotocicleta() {
        JTextField campoPatente = new JTextField();
        JTextField campoMarca = new JTextField();
        JTextField campoModelo = new JTextField();
        JTextField campoMaxVelocidad = new JTextField();
        JTextField campoCilindrada = new JTextField();
        JTextField campoRendimiento = new JTextField();
        JCheckBox checkAbs = new JCheckBox("¿Tiene ABS?");

        Object[] mensaje = {
                "Patente:", campoPatente,
                "Marca:", campoMarca,
                "Modelo:", campoModelo,
                "Velocidad Máxima (km/h):", campoMaxVelocidad,
                "Cilindrada (cc):", campoCilindrada,
                "Rendimiento (km/l):", campoRendimiento,
                checkAbs
        };

        int opcion = JOptionPane.showConfirmDialog(null, mensaje, "Registrar Motocicleta", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            try {
                String patente = campoPatente.getText();
                String marca = campoMarca.getText();
                String modelo = campoModelo.getText();
                int maxVelocidad = Integer.parseInt(campoMaxVelocidad.getText());
                int cilindrada = Integer.parseInt(campoCilindrada.getText());
                int rendimiento = Integer.parseInt(campoRendimiento.getText());
                boolean abs = checkAbs.isSelected();

                Motocicleta nuevaMoto = new Motocicleta(patente, marca, modelo, maxVelocidad, cilindrada, rendimiento, abs);
                motocicletas.add(nuevaMoto);

                JOptionPane.showMessageDialog(null, "Motocicleta registrada exitosamente.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese datos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public static void listarMotocicletasPorCilindrada() {
        StringBuilder altaCilindrada = new StringBuilder("Motocicletas de Alta Cilindrada:\n");
        StringBuilder bajaCilindrada = new StringBuilder("Motocicletas de Baja Cilindrada:\n");

        for (Motocicleta moto : motocicletas) {
            if (moto.esAltaCilindrada()) {
                altaCilindrada.append("Patente: ").append(moto.patente).append(", ")
                        .append("Marca: ").append(moto.marca).append(", ")
                        .append("Modelo: ").append(moto.modelo).append(", ")
                        .append("Cilindrada: ").append(moto.cilindrada).append(" cc\n");
            } else if (moto.esBajaCilindrada()) {
                bajaCilindrada.append("Patente: ").append(moto.patente).append(", ")
                        .append("Marca: ").append(moto.marca).append(", ")
                        .append("Modelo: ").append(moto.modelo).append(", ")
                        .append("Cilindrada: ").append(moto.cilindrada).append(" cc\n");
            }
        }

        JTextArea textArea = new JTextArea(altaCilindrada + "\n" + bajaCilindrada);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane.setPreferredSize(new java.awt.Dimension(500, 400));
        JOptionPane.showMessageDialog(null, scrollPane, "Reporte de Motocicletas por Cilindrada", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean esAltaCilindrada() {
        return cilindrada >= 650 && cilindrada <= 1250;
    }

    public boolean esBajaCilindrada() {
        return cilindrada >= 100 && cilindrada <= 600;
    }

    @Override
    public String toString() {
        return marca + " " + modelo + " (" + cilindrada + " cc)";
    }

}


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
        return motocicletas; //
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getMaxVelocidad() {
        return maxVelocidad;
    }

    public void setMaxVelocidad(int maxVelocidad) {
        this.maxVelocidad = maxVelocidad;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public int getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(int rendimiento) {
        this.rendimiento = rendimiento;
    }

    public boolean isAbs() {
        return abs;
    }

    public void setAbs(boolean abs) {
        this.abs = abs;
    }

    public static void setMotocicletas(ArrayList<Motocicleta> motocicletas) {
        Motocicleta.motocicletas = motocicletas;
    }
    @Override
    public String toString() {
        return marca + " " + modelo;
    }


    public static void registrarMotocicleta() {
        // Crear formulario para ingresar los datos
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

    public static void mostrarDatos() {
        StringBuilder datos = new StringBuilder("Motocicletas Registradas:\n");
        for (Motocicleta moto : motocicletas) {
            datos.append("Patente: ").append(moto.patente).append("\n")
                    .append("Marca: ").append(moto.marca).append("\n")
                    .append("Modelo: ").append(moto.modelo).append("\n")
                    .append("Velocidad Máxima: ").append(moto.maxVelocidad).append(" km/h\n")
                    .append("Cilindrada: ").append(moto.cilindrada).append(" cc\n")
                    .append("Rendimiento: ").append(moto.rendimiento).append(" km/l\n")
                    .append("ABS: ").append(moto.abs ? "Sí" : "No").append("\n\n");
        }
        JOptionPane.showMessageDialog(null, datos.toString(), "Lista de Motocicletas", JOptionPane.INFORMATION_MESSAGE);
    }
}


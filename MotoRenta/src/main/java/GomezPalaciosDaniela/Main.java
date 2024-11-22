package GomezPalaciosDaniela;

import javax.swing.*;

public class Main extends JFrame {

    public Main() {
        setTitle("Sistema de Administración de Ventas - MotoRenta");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        inicializarMenu();
    }

    private void inicializarMenu() {
        JMenuBar menuBar = new JMenuBar();

        // Menú Cliente
        JMenu menuCliente = new JMenu("Cliente");
        JMenuItem agregarCliente = new JMenuItem("Agregar Cliente");
        JMenuItem eliminarCliente = new JMenuItem("Eliminar Cliente");
        JMenuItem modificarCliente = new JMenuItem("Modificar Cliente");

        agregarCliente.addActionListener(e -> Cliente.agregarCliente());
        eliminarCliente.addActionListener(e -> Cliente.eliminarCliente());
        modificarCliente.addActionListener(e -> Cliente.modificarCliente());

        menuCliente.add(agregarCliente);
        menuCliente.add(eliminarCliente);
        menuCliente.add(modificarCliente);

        // Menú Motocicleta
        JMenu menuMotocicleta = new JMenu("Motocicleta");
        JMenuItem registrarMotocicleta = new JMenuItem("Registrar Motocicleta");

        registrarMotocicleta.addActionListener(e -> Motocicleta.registrarMotocicleta());

        menuMotocicleta.add(registrarMotocicleta);


        // Menú Arriendo
        JMenu menuArriendo = new JMenu("Arriendo");
        JMenuItem realizarArriendo = new JMenuItem("Realizar Arriendo");

        realizarArriendo.addActionListener(e -> Arriendo.realizarArriendo());

        menuArriendo.add(realizarArriendo);


        // Menú Reportes
        JMenu menuReportes = new JMenu("Reportes");
        JMenuItem reporteMotocicletas = new JMenuItem("Listar Motocicletas por Cilindrada");
        JMenuItem reporteArriendos = new JMenuItem("Listar Arriendos");

        reporteMotocicletas.addActionListener(e -> Motocicleta.listarMotocicletasPorCilindrada());
        reporteArriendos.addActionListener(e -> Arriendo.listarArriendos());

        menuReportes.add(reporteMotocicletas);
        menuReportes.add(reporteArriendos);

        // Menú Salir
        JMenu menuSalir = new JMenu("Salir");
        JMenuItem salir = new JMenuItem("Salir");
        salir.addActionListener(e -> System.exit(0));
        menuSalir.add(salir);

        menuBar.add(menuCliente);
        menuBar.add(menuMotocicleta);
        menuBar.add(menuArriendo);
        menuBar.add(menuReportes);
        menuBar.add(menuSalir);

        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main main = new Main();
            main.setVisible(true);
        });
    }
}

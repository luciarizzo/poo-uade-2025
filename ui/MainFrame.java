package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    private JComboBox<String> comboApartamentos;
    private JTextField campoNombre;
    private JTextArea areaResultado;
    private JButton botonAsignar;
    private JCheckBox cbDesayuno, cbSpa, cbLavanderia;

    public MainFrame() {
        setTitle("Gestión de Apartamentos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(550, 400);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout(10, 10));

        JPanel panelSuperior = new JPanel(new GridLayout(2, 2, 5, 5));
        panelSuperior.setBorder(BorderFactory.createTitledBorder("Datos del compatriota"));

        panelSuperior.add(new JLabel("Nombre:"));
        campoNombre = new JTextField();
        panelSuperior.add(campoNombre);

        panelSuperior.add(new JLabel("Apartamento:"));
        comboApartamentos = new JComboBox<>(new String[] {
                "Apto 101", "Apto 102", "Apto 103", "Apto 201", "Apto 202"
        });
        panelSuperior.add(comboApartamentos);

        add(panelSuperior, BorderLayout.NORTH);

        JPanel panelServicios = new JPanel(new GridLayout(1, 3));
        panelServicios.setBorder(BorderFactory.createTitledBorder("Servicios extra"));

        cbDesayuno = new JCheckBox("Calefacción ($500)");
        cbSpa = new JCheckBox("Rayo de sol ($1000)");
        cbLavanderia = new JCheckBox("Aire fresco ($800)");

        panelServicios.add(cbDesayuno);
        panelServicios.add(cbSpa);
        panelServicios.add(cbLavanderia);

        add(panelServicios, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new BorderLayout());

        areaResultado = new JTextArea(6, 40);
        areaResultado.setEditable(false);
        areaResultado.setBorder(BorderFactory.createTitledBorder("Resultado"));
        panelInferior.add(new JScrollPane(areaResultado), BorderLayout.CENTER);

        botonAsignar = new JButton("Asignar");
        botonAsignar.addActionListener(this::asignarApartamento);
        JPanel panelBoton = new JPanel();
        panelBoton.add(botonAsignar);
        panelInferior.add(panelBoton, BorderLayout.SOUTH);

        add(panelInferior, BorderLayout.SOUTH);
    }

    private void asignarApartamento(ActionEvent e) {
        String nombre = campoNombre.getText().trim();
        String apartamento = (String) comboApartamentos.getSelectedItem();

        if (nombre.isEmpty()) {
            areaResultado.setText("Ingrese un nombre válido.");
            return;
        }

        ArrayList<String> serviciosSeleccionados = new ArrayList<>();
        int costoServicios = 0;

        if (cbDesayuno.isSelected()) {
            serviciosSeleccionados.add("Calefacción ($500)");
            costoServicios += 500;
        }
        if (cbSpa.isSelected()) {
            serviciosSeleccionados.add("Rayo de Sol ($1000)");
            costoServicios += 1000;
        }
        if (cbLavanderia.isSelected()) {
            serviciosSeleccionados.add("Aire Fresco ($800)");
            costoServicios += 800;
        }

        StringBuilder resultado = new StringBuilder();
        resultado.append("Apartamento ").append(apartamento)
                .append(" asignado a ").append(nombre).append(".\n\n");

        if (!serviciosSeleccionados.isEmpty()) {
            resultado.append("Servicios extra seleccionados:\n");
            for (String servicio : serviciosSeleccionados) {
                resultado.append("- ").append(servicio).append("\n");
            }
            resultado.append("\nTotal servicios: $").append(costoServicios);
        } else {
            resultado.append("No se seleccionaron servicios extra.");
        }

        areaResultado.setText(resultado.toString());
    }
}
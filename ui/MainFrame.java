package ui;

import model.Apartamento;
import model.Inquilino;
import model.Reserva;
import model.ServiciosExtras;
import repository.RepositorioApartamentoEnMemoria;
import repository.RepositorioApartamentos;
import repository.RepositorioReservas;
import repository.RepositorioReservasEnMemoria;
import service.GestorReserva;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;


public class MainFrame extends JFrame {

    private JComboBox<Apartamento> comboApartamentos;
    private JTextField campoNombre, campoLibreta, campoMes;
    private JTextArea areaResultado;
    private JButton botonAsignar, botonMostrarReservas;
    //private JCheckBox cbDesayuno, cbSpa, cbLavanderia;
    private JCheckBox cbCalefacción, cbLuzSolar, cbAireFresco;
    private ServiciosExtras calefaccion, luzsolar, aireFresco;
    RepositorioReservas repositorioReservas = new RepositorioReservasEnMemoria();
    RepositorioApartamentos repositorioApartamentos = new RepositorioApartamentoEnMemoria();
    GestorReserva gestorReserva = new GestorReserva(repositorioReservas);

    public MainFrame() {
        setTitle("Gestión de Apartamentos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(550, 400);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout(10, 10));

        JPanel panelSuperior = new JPanel(new GridLayout(4, 4, 5, 5));
        panelSuperior.setBorder(BorderFactory.createTitledBorder("Datos del compatriota"));

        panelSuperior.add(new JLabel("Nombre:"));
        campoNombre = new JTextField();
        panelSuperior.add(campoNombre);

        panelSuperior.add(new JLabel("Libreta:"));
        campoLibreta = new JTextField();
        panelSuperior.add(campoLibreta);

        panelSuperior.add(new JLabel("Mes:"));
        campoMes = new JTextField();
        panelSuperior.add(campoMes);


        panelSuperior.add(new JLabel("Apartamento:"));
        List<Apartamento> apartamentosDisponibles = repositorioApartamentos.obtenerApartamentosDisponibles();
        comboApartamentos = new JComboBox<>();
        for (Apartamento a : apartamentosDisponibles) {
            comboApartamentos.addItem(a);
        }
        panelSuperior.add(comboApartamentos);

        add(panelSuperior, BorderLayout.NORTH);

        JPanel panelServicios = new JPanel(new GridLayout(1, 3));
        panelServicios.setBorder(BorderFactory.createTitledBorder("Servicios extra"));

        calefaccion = new ServiciosExtras("Calefaccion", 100);
        luzsolar = new ServiciosExtras("Luz solar", 200);
        aireFresco = new ServiciosExtras("Aire fresco", 300);

        cbCalefacción= new JCheckBox(calefaccion.getNombre());
        cbLuzSolar = new JCheckBox(luzsolar.getNombre());
        cbAireFresco = new JCheckBox(aireFresco.getNombre());

        panelServicios.add(cbLuzSolar);
        panelServicios.add(cbCalefacción);
        panelServicios.add(cbAireFresco);

        add(panelServicios, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new BorderLayout());

        areaResultado = new JTextArea(6, 40);
        areaResultado.setEditable(false);
        areaResultado.setBorder(BorderFactory.createTitledBorder("Resultado"));
        panelInferior.add(new JScrollPane(areaResultado), BorderLayout.CENTER);

        botonAsignar = new JButton("Asignar");
        botonAsignar.addActionListener(this::asignarApartamento);

        botonMostrarReservas = new JButton("Mostrar Reservas");
        botonMostrarReservas.addActionListener(this::mostrarReservas);

        //botones
        JPanel panelBotones = new JPanel();
        panelBotones.add(botonAsignar);
        panelBotones.add(botonMostrarReservas);

        panelInferior.add(panelBotones, BorderLayout.SOUTH);

        add(panelInferior, BorderLayout.SOUTH);
    }

    private void asignarApartamento(ActionEvent e) {
        String nombre = campoNombre.getText().trim();
        int libreta = Integer.parseInt(campoLibreta.getText());
        int mes = Integer.parseInt(campoMes.getText());

        Apartamento apartamento = (Apartamento) comboApartamentos.getSelectedItem();

        if (nombre.isEmpty()) {
            areaResultado.setText("Ingrese un nombre válido.");
            return;
        }

        //ArrayList<String> serviciosSeleccionados = new ArrayList<>();
        List<ServiciosExtras> serviciosSeleccionados = new ArrayList<>();

        int costoServicios = 0;

        if (cbLuzSolar.isSelected()) {
            serviciosSeleccionados.add(luzsolar);
        }
        if (cbAireFresco.isSelected()) {
            serviciosSeleccionados.add(aireFresco);
        }
        if (cbCalefacción.isSelected()) {
            serviciosSeleccionados.add(calefaccion);
        }

        // Crear Inquilino
        Inquilino inquilino = new Inquilino(nombre, libreta);

        // Crear Reserva real
        Reserva reserva = new Reserva(apartamento, inquilino, mes, serviciosSeleccionados);

        // Registrar la reserva en el sistema
        if(gestorReserva.crearReserva(reserva)) {

            double costoTotal = reserva.calcularCostoTotal();

            StringBuilder resultado = new StringBuilder();
            assert apartamento != null;
            resultado.append("Apartamento ").append(apartamento.getNumero())
                    .append(" asignado a ").append(nombre).append(".\n\n");

            if (!serviciosSeleccionados.isEmpty()) {
                resultado.append("Servicios extra seleccionados:\n");
                for (ServiciosExtras servicio : serviciosSeleccionados) {
                    resultado.append("- ").append(servicio).append("\n");
                }
                resultado.append("\nTotal servicios: $").append(costoTotal);
            } else {
                resultado.append("No se seleccionaron servicios extra.");
            }

            areaResultado.setText(resultado.toString());
        } else {
            areaResultado.setText("Este departamento está ocupado. Intente de nuevo.");
        }
    }

    private void mostrarReservas(ActionEvent e) {
        List<Reserva> reservas = repositorioReservas.obtenerTodas();

        if (reservas.isEmpty()) {
            areaResultado.setText("No hay reservas registradas.");
            return;
        }

        StringBuilder resultado = new StringBuilder("Reservas registradas:\n\n");

        for (Reserva r : reservas) {
            resultado.append("Inquilino: ").append(r.getInquilino().getNombre()).append("\n");
            resultado.append("Apartamento: ").append(r.getApartamento().getNumero()).append("\n");
            resultado.append("Costo total: $").append(r.calcularCostoTotal()).append("\n");
            resultado.append("Servicios: ");

            if (r.getServiciosExtras().isEmpty()) {
                resultado.append("ninguno");
            } else {
                for (ServiciosExtras s : r.getServiciosExtras()) {
                    resultado.append(s.getNombre()).append(" ($").append(s.getPrecio()).append("), ");
                }
                resultado.setLength(resultado.length() - 2);
            }

            resultado.append("\n\n");
        }

        areaResultado.setText(resultado.toString());
    }

}
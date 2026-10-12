package com.mycompany.facturacion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FormularioVenta extends javax.swing.JFrame {

    // Componentes de la VENTA (Cabecera de Caja)
    private JTextField txtIdVenta, txtNumComprobante, txtBusquedaCliente, txtNombreCliente;
    private JComboBox<String> cbTipoComprobante, cbVendedores, cbFormaPago;
    private JTextField txtTotal;

    // Componentes del DETALLE_VENTA
    private JTextField txtIdProducto, txtNombreProducto, txtPrecioUnitario, txtCantidad;
    private JButton btnAgregarProducto, btnEliminarProducto, btnRegistrarVenta;
    
    // Control de Caja, Vuelto y Saldos Pendientes
    private JTextField txtMontoRecibido, txtResultadoCaja;
    private JLabel lblResultadoCaja; 
    
    // Tabla del Carrito de Ventas
    private JTable tablaDetalle;
    private DefaultTableModel modeloTabla;

    // ID real del cliente seleccionado en la base de datos
    private int idClienteBD = 0;
    private boolean clienteSeleccionado = false;

    public FormularioVenta() {
        
        // Configuración y Dimensiones de la Ventana Principal
        setTitle("Punto de Venta - Módulo de Caja");
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
setLayout(new BorderLayout(10, 10));
setMinimumSize(new Dimension(900, 650));
setSize(1100, 750);
setLocationRelativeTo(null);

        // --- 1. PANEL SUPERIOR: SECCIÓN DE CABECERA DE VENTA ---
        JPanel panelCabecera = new JPanel(new GridLayout(4, 4, 10, 10));
        panelCabecera.setBorder(BorderFactory.createTitledBorder("Datos de la Venta"));

        panelCabecera.add(new JLabel(" Código de Venta:"));
        txtIdVenta = new JTextField();
        txtIdVenta.setEditable(false); 
        // ❌ AQUÍ ESTABA ANTES la línea generarCodigoVentaAutomatico(); SE BORRÓ DE AQUÍ.
        panelCabecera.add(txtIdVenta);

        panelCabecera.add(new JLabel(" Nro. Comprobante:"));
        txtNumComprobante = new JTextField(); // Se crea la casilla limpia primero
        panelCabecera.add(txtNumComprobante);

        panelCabecera.add(new JLabel(" DNI/ID Cliente + [ENTER]:"));
        txtBusquedaCliente = new JTextField();
        txtBusquedaCliente.setBackground(new Color(255, 255, 204));
        panelCabecera.add(txtBusquedaCliente);

        panelCabecera.add(new JLabel(" Nombre del Cliente:"));
        txtNombreCliente = new JTextField();
        txtNombreCliente.setEditable(false);
        panelCabecera.add(txtNombreCliente);

        panelCabecera.add(new JLabel(" Vendedor Comercial:"));
        cbVendedores = new JComboBox<>(new String[]{
            "1 - Carlos Mendoza", "2 - Ana Torres", "3 - Luis Ramirez", "4 - Maria Flores", "5 - Jose Quispe"
        });
        panelCabecera.add(cbVendedores);

        panelCabecera.add(new JLabel(" Tipo Comprobante:"));
        cbTipoComprobante = new JComboBox<>(new String[]{"BOLETA", "FACTURA"});
        panelCabecera.add(cbTipoComprobante);

        panelCabecera.add(new JLabel(" Método de Pago:"));
        cbFormaPago = new JComboBox<>(new String[]{"EFECTIVO", "YAPE", "TRANSFERENCIA"});
        panelCabecera.add(cbFormaPago);

        // =========================================================
        //  ¡AQUÍ SE QUEDA AHORA! (Justo antes de añadir el panel)
        // =========================================================
        generarCodigoVentaAutomatico(); 

        add(panelCabecera, BorderLayout.NORTH);

        // --- 2. PANEL CENTRAL: ELEMENTOS DEL CARRITO Y LÍNEAS DE DETALLE ---
        JPanel panelCentral = new JPanel(new BorderLayout(5, 5));
        
        JPanel panelAgregarProd = new JPanel(new GridLayout(2, 5, 8, 5));
        panelAgregarProd.setBorder(BorderFactory.createTitledBorder("Entrada de Productos"));

        panelAgregarProd.add(new JLabel("Código + [ENTER]:"));
        panelAgregarProd.add(new JLabel("Descripción:"));
        panelAgregarProd.add(new JLabel("Precio Unitario:"));
        panelAgregarProd.add(new JLabel("Cantidad:"));
        panelAgregarProd.add(new JLabel("Acciones:"));

        txtIdProducto = new JTextField();
        txtIdProducto.setBackground(new Color(255, 255, 204));
        panelAgregarProd.add(txtIdProducto);

        txtNombreProducto = new JTextField();
        txtNombreProducto.setEditable(false);
        panelAgregarProd.add(txtNombreProducto);

        txtPrecioUnitario = new JTextField();
        txtPrecioUnitario.setEditable(false);
        panelAgregarProd.add(txtPrecioUnitario);

        txtCantidad = new JTextField("1");
        panelAgregarProd.add(txtCantidad);

        JPanel panelBotonesTodo = new JPanel(new GridLayout(1, 2, 5, 5));
        btnAgregarProducto = new JButton("+");
        btnAgregarProducto.setBackground(new Color(40, 167, 69));
        btnAgregarProducto.setForeground(Color.WHITE);
        
        btnEliminarProducto = new JButton("-");
        btnEliminarProducto.setBackground(new Color(220, 53, 69));
        btnEliminarProducto.setForeground(Color.WHITE);
        
        panelBotonesTodo.add(btnAgregarProducto);
        panelBotonesTodo.add(btnEliminarProducto);
        panelAgregarProd.add(panelBotonesTodo);

        panelCentral.add(panelAgregarProd, BorderLayout.NORTH);

        // Configuración física de la Tabla de Despacho
        String[] columnas = {"Código", "Descripción", "Cantidad", "Precio", "Subtotal"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaDetalle = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tablaDetalle);
        panelCentral.add(scrollTabla, BorderLayout.CENTER);

        add(panelCentral, BorderLayout.CENTER);

        // --- 3. PANEL INFERIOR: FINANZAS Y LIQUIDACIÓN EN CAJA ---
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 10));
        panelInferior.setBorder(BorderFactory.createTitledBorder("Cierre de Caja"));
        
        panelInferior.add(new JLabel("TOTAL GASTADO S/.:"));
        txtTotal = new JTextField("0.00", 8);
        txtTotal.setEditable(false);
        txtTotal.setFont(new Font("Arial", Font.BOLD, 14));
        panelInferior.add(txtTotal);

        panelInferior.add(new JLabel("Dinero Entregado:"));
        txtMontoRecibido = new JTextField("0.00", 8);
        panelInferior.add(txtMontoRecibido);

        lblResultadoCaja = new JLabel("Vuelto:");
        panelInferior.add(lblResultadoCaja);
        txtResultadoCaja = new JTextField("0.00", 8);
        txtResultadoCaja.setEditable(false);
        txtResultadoCaja.setFont(new Font("Arial", Font.BOLD, 12));
        panelInferior.add(txtResultadoCaja);

        btnRegistrarVenta = new JButton("Completar Venta");
        btnRegistrarVenta.setBackground(new Color(0, 123, 255));
        btnRegistrarVenta.setForeground(Color.WHITE);
        panelInferior.add(btnRegistrarVenta);

        add(panelInferior, BorderLayout.SOUTH);

        // =========================================================
        // CONTROLADORES DE EVENTOS ASOCIADOS A INTERACCIONES
        // =========================================================

        // Evento ENTER: buscar cliente por ID o DNI directamente en MySQL/XAMPP
        txtBusquedaCliente.addActionListener(e -> {
            String dato = txtBusquedaCliente.getText().trim();

            if (dato.isEmpty()) {
                JOptionPane.showMessageDialog(
                    this,
                    "Ingrese el ID o DNI del cliente.",
                    "Dato requerido",
                    JOptionPane.WARNING_MESSAGE
                );
                clienteSeleccionado = false;
                idClienteBD = 0;
                txtNombreCliente.setText("");
                txtBusquedaCliente.requestFocus();
                return;
            }

            String sql = "SELECT id_cliente, nombre FROM cliente "
                       + "WHERE CAST(id_cliente AS CHAR) = ? "
                       + "OR numero_documento = ?";

            try (Connection con = conexion.conectar();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, dato);
                ps.setString(2, dato);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        idClienteBD = rs.getInt("id_cliente");
                        txtNombreCliente.setText(rs.getString("nombre"));
                        clienteSeleccionado = true;
                        txtIdProducto.requestFocus();
                    } else {
                        idClienteBD = 0;
                        clienteSeleccionado = false;
                        txtNombreCliente.setText("");
                        JOptionPane.showMessageDialog(
                            this,
                            "Cliente no registrado. Verifique el ID o DNI.",
                            "Cliente no encontrado",
                            JOptionPane.WARNING_MESSAGE
                        );
                        txtBusquedaCliente.requestFocus();
                        txtBusquedaCliente.selectAll();
                    }
                }
            } catch (SQLException ex) {
                idClienteBD = 0;
                clienteSeleccionado = false;
                txtNombreCliente.setText("");
                JOptionPane.showMessageDialog(
                    this,
                    "Error al consultar el cliente:\n" + ex.getMessage(),
                    "Error de base de datos",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        });

        // Evento ENTER: Búsqueda de Productos Real en XAMPP (precio_lista)
        txtIdProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idProd = txtIdProducto.getText().trim();
                if (!idProd.isEmpty()) {
                    String sql = "SELECT nombre, precio_lista FROM producto WHERE id_producto = ?";
                    try (Connection con = conexion.conectar();
                         PreparedStatement ps = con.prepareStatement(sql)) {
                        
                        ps.setInt(1, Integer.parseInt(idProd));
                        try (ResultSet rs = ps.executeQuery()) {
                            if (rs.next()) {
                                txtNombreProducto.setText(rs.getString("nombre"));

txtPrecioUnitario.setText(String.valueOf(rs.getDouble("precio_lista")));
txtCantidad.requestFocus();
txtCantidad.selectAll();
} else {
txtNombreProducto.setText("NO ENCONTRADO");
txtPrecioUnitario.setText("");
}
}
} catch (Exception ex) {
JOptionPane.showMessageDialog(null, "Error al buscar producto en XAMPP: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
}
}
});
txtCantidad.addActionListener(e -> btnAgregarProducto.doClick());
// Acción del Botón (+): Inserción en la tabla visual del carrito
btnAgregarProducto.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
try {
String id = txtIdProducto.getText().trim();
if (txtNombreProducto.getText().isEmpty() || txtNombreProducto.getText().equals("NO ENCONTRADO")) {
JOptionPane.showMessageDialog(null, "Escriba y busque un producto válido primero.", "Aviso", JOptionPane.WARNING_MESSAGE);
return;
}
int cantPedida = Integer.parseInt(txtCantidad.getText().trim());
if (cantPedida <= 0) throw new NumberFormatException();
double precio = Double.parseDouble(txtPrecioUnitario.getText());
double subtotal = cantPedida * precio;
modeloTabla.addRow(new Object[]{id, txtNombreProducto.getText(), cantPedida, precio, subtotal});
calcularTotal();
calcularCierreCaja();
// Limpiar campos de captura
txtIdProducto.setText("");
txtNombreProducto.setText("");
txtPrecioUnitario.setText("");
txtCantidad.setText("1");
txtIdProducto.requestFocus();
} catch (Exception ex) {
JOptionPane.showMessageDialog(null, "Por favor, digite una cantidad entera válida.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
}
}
});
// Acción del Botón (-): Quitar fila de la tabla
btnEliminarProducto.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
int fila = tablaDetalle.getSelectedRow();
if (fila >= 0) {
modeloTabla.removeRow(fila);
calcularTotal();
calcularCierreCaja();
} else {
JOptionPane.showMessageDialog(null, "Debe marcar una línea de la tabla inferior para removerla.", "Aviso", JOptionPane.WARNING_MESSAGE);
}
}
});
txtMontoRecibido.addActionListener(e -> calcularCierreCaja());
// Acción: Completar Venta, Descontar Stock y Generar Voucher Real
btnRegistrarVenta.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
if (!clienteSeleccionado || idClienteBD <= 0) {
JOptionPane.showMessageDialog(
    FormularioVenta.this,
    "Debe buscar y seleccionar un cliente válido antes de finalizar.",
    "Falta Cliente",
    JOptionPane.WARNING_MESSAGE
);
txtBusquedaCliente.requestFocus();
return;
}
if (modeloTabla.getRowCount() == 0) {
JOptionPane.showMessageDialog(null, "El carrito de compras está vacío.", "Falta Detalle", JOptionPane.WARNING_MESSAGE);
return;
}
try {
double totalGastado = Double.parseDouble(txtTotal.getText());
double dineroEntregado = Double.parseDouble(txtMontoRecibido.getText().trim());
double balanceSuelto = dineroEntregado - totalGastado;
String estadoFinalVenta = (balanceSuelto >= 0) ? "PAGADO" : "PENDIENTE";
Connection con = null;
PreparedStatement psVenta = null;
PreparedStatement psDetalle = null;
PreparedStatement psStock = null;
try {
con = conexion.conectar();
con.setAutoCommit(false); // Transacción segura abierta
// 1. Insertar en la tabla VENTA usando NOW() para la fecha
String sqlVenta = "INSERT INTO venta (numero_comprobante, fecha, total, estado, id_cliente, id_vendedor, id_tipo) VALUES (?, NOW(), ?, ?, ?, ?, ?)";
psVenta = con.prepareStatement(sqlVenta, PreparedStatement.RETURN_GENERATED_KEYS);
psVenta.setString(1, txtNumComprobante.getText().trim());
psVenta.setDouble(2, totalGastado);
psVenta.setString(3, estadoFinalVenta);
psVenta.setInt(4, idClienteBD); // Guarda la variable correcta de clase
psVenta.setInt(5, 1); // Vendedor por defecto
psVenta.setInt(6, cbTipoComprobante.getSelectedItem().toString().equals("BOLETA") ? 3 : 1);
psVenta.executeUpdate();
ResultSet rs = psVenta.getGeneratedKeys();
int idVentaGenerado = 0;
if (rs.next()) {
idVentaGenerado = rs.getInt(1);
}
// 2. Insertar en DETALLE_VENTA
String sqlDetalle = "INSERT INTO detalle_venta (cantidad, precio_unitario, subtotal, id_venta, id_producto) VALUES (?, ?, ?, ?, ?)";
psDetalle = con.prepareStatement(sqlDetalle);
// 3. Modificar el STOCK real en XAMPP
String sqlActualizarStock = "UPDATE producto SET stock = stock - ? WHERE id_producto = ?";
psStock = con.prepareStatement(sqlActualizarStock);
int unidadesTotales = 0;
for (int i = 0; i < modeloTabla.getRowCount(); i++) {
int idProd = Integer.parseInt(modeloTabla.getValueAt(i, 0).toString());
int cant = Integer.parseInt(modeloTabla.getValueAt(i, 2).toString());
double precio = Double.parseDouble(modeloTabla.getValueAt(i, 3).toString());
double subtotal = Double.parseDouble(modeloTabla.getValueAt(i, 4).toString());
unidadesTotales += cant;
// Lote de detalles
psDetalle.setInt(1, cant);
psDetalle.setDouble(2, precio);
psDetalle.setDouble(3, subtotal);
psDetalle.setInt(4, idVentaGenerado);
psDetalle.setInt(5, idProd);
psDetalle.addBatch();
// Lote de actualización de Stock
psStock.setInt(1, cant);
psStock.setInt(2, idProd);
psStock.addBatch();
}
psDetalle.executeBatch();
psStock.executeBatch(); // Ejecuta los descuentos reales de inventario
con.commit(); // CONFIRMAR OPERACIONES EN MYSQL
// 4. Renderizar el Ticket Final en Pantalla
StringBuilder ticket = new StringBuilder();
ticket.append("=========================================\n");
ticket.append("          TICKET DE PAGO REAL (BD)        \n");
ticket.append("=========================================\n");
ticket.append("Cod. Venta BD: ").append(idVentaGenerado).append("\n");
ticket.append("Nro. Doc:      ").append(txtNumComprobante.getText()).append("\n");
ticket.append("Tipo Comp:     ").append(cbTipoComprobante.getSelectedItem().toString()).append("\n");
ticket.append("Cliente:       ").append(txtNombreCliente.getText()).append("\n");
ticket.append("Medio Pago:    ").append(cbFormaPago.getSelectedItem().toString()).append("\n");
ticket.append("-----------------------------------------\n");
ticket.append("Cant. Artículos Totales: ").append(unidadesTotales).append(" unidades\n");
ticket.append("-----------------------------------------\n");
ticket.append("DINERO ENTREGADO:       S/. ").append(String.format("%.2f", dineroEntregado)).append("\n");
ticket.append("TOTAL GASTADO:          S/. ").append(String.format("%.2f", totalGastado)).append("\n");
ticket.append("-----------------------------------------\n");
if (balanceSuelto >= 0) {
ticket.append("SU VUELTO REAL:         S/. ").append(String.format("%.2f", balanceSuelto)).append("\n");
} else {
ticket.append("MONTO EN DEUDA:         S/. ").append(String.format("%.2f", Math.abs(balanceSuelto))).append("\n");
}
ticket.append("=========================================\n");
ticket.append(" ¡Guardado e Inventario Restado en MySQL! \n");
ticket.append("        ¡Gracias por su preferencia!     \n");
ticket.append("=========================================\n");
JTextArea textArea = new JTextArea(ticket.toString());
textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
textArea.setEditable(false);
JOptionPane.showMessageDialog(null, new JScrollPane(textArea), "Operación Procesada con Éxito", JOptionPane.INFORMATION_MESSAGE);
limpiarTodoFormulario();
} catch (SQLException ex) {
if (con != null) {
try { con.rollback(); } catch (SQLException e1) {}
}
JOptionPane.showMessageDialog(null, "Error SQL de procesamiento:\n" + ex.getMessage() + "\nCódigo de error: " + ex.getErrorCode(), "Fallo en Base de Datos", JOptionPane.ERROR_MESSAGE);
} finally {
try {
if (psVenta != null) psVenta.close();
if (psDetalle != null) psDetalle.close();
if (psStock != null) psStock.close();
if (con != null) con.close();
} catch (SQLException ex) {}
}
} catch (Exception ex) {
JOptionPane.showMessageDialog(null, "Verifique el monto recibido en caja.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
}
}
});
}
    private void generarCodigoVentaAutomatico() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        String fechaCodigo = sdf.format(new Date());
        
        // Genera el código interno de venta (Ej: V-202610101035)
        txtIdVenta.setText("V-" + fechaCodigo);
        
        // NUEVO: Genera un número de comprobante único automático (Ej: F261010-1035)
        SimpleDateFormat sdfComp = new SimpleDateFormat("yyMMdd-HHmm");
        txtNumComprobante.setText("F" + sdfComp.format(new Date()));
    }
private void calcularTotal() {
double total = 0.0;
for (int i = 0; i < modeloTabla.getRowCount(); i++) {
total += (double) modeloTabla.getValueAt(i, 4);
}
txtTotal.setText(String.format("%.2f", total));
}
private void calcularCierreCaja() {
        try {
            double totalGastado = Double.parseDouble(txtTotal.getText());
            double dineroEntregado = Double.parseDouble(txtMontoRecibido.getText().trim());
            double diferencia = dineroEntregado - totalGastado;
            if (diferencia >= 0) {
                lblResultadoCaja.setText("Vuelto:");
                txtResultadoCaja.setText(String.format("%.2f", diferencia));
                txtResultadoCaja.setForeground(new Color(40, 167, 69));
            } else {
                lblResultadoCaja.setText("En Deuda:");
                txtResultadoCaja.setText(String.format("%.2f", Math.abs(diferencia)));
                txtResultadoCaja.setForeground(Color.RED);
            }
        } catch (Exception ex) {
            txtResultadoCaja.setText("0.00");
        }
    }

    private void limpiarTodoFormulario() {
        modeloTabla.setRowCount(0);
        txtTotal.setText("0.00");
        txtMontoRecibido.setText("0.00");
        txtResultadoCaja.setText("0.00");
        lblResultadoCaja.setText("Vuelto:");
        txtResultadoCaja.setForeground(Color.BLACK);
        txtBusquedaCliente.setText("");
        txtNombreCliente.setText("");
         
        generarCodigoVentaAutomatico();
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new FormularioVenta().setVisible(true));
    }
}
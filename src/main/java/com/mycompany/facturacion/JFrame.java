package com.mycompany.facturacion;

public class JFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JFrame.class.getName());

    public JFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cliente = new javax.swing.JLabel();
        trabajador = new javax.swing.JLabel();
        ventas = new javax.swing.JLabel();
        productos = new javax.swing.JLabel();
        perfil1 = new javax.swing.JLabel();
        perfil2 = new javax.swing.JLabel();
        carrito = new javax.swing.JLabel();
        stock = new javax.swing.JLabel();
        JDesktop1 = new javax.swing.JDesktopPane();
        jPanel4 = new javax.swing.JPanel();
        nombreEmpresa = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 821, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        cliente.setBackground(new java.awt.Color(255, 255, 255));
        cliente.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        cliente.setForeground(new java.awt.Color(255, 255, 255));
        cliente.setText("Cliente >");
        cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clienteMouseClicked(evt);
            }
        });

        trabajador.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        trabajador.setForeground(new java.awt.Color(255, 255, 255));
        trabajador.setText("Trabajador >");
        trabajador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        trabajador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trabajadorMouseClicked(evt);
            }
        });

        ventas.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        ventas.setForeground(new java.awt.Color(255, 255, 255));
        ventas.setText("Ventas >");
        ventas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ventas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ventasMouseClicked(evt);
            }
        });

        productos.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        productos.setForeground(new java.awt.Color(255, 255, 255));
        productos.setText("Productos >");
        productos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productosMouseClicked(evt);
            }
        });

        perfil1.setBackground(new java.awt.Color(255, 255, 255));
        perfil1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cliente.png"))); // NOI18N
        perfil1.setMaximumSize(new java.awt.Dimension(512, 512));
        perfil1.setPreferredSize(new java.awt.Dimension(512, 512));

        perfil2.setBackground(new java.awt.Color(255, 255, 255));
        perfil2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/empleado.png"))); // NOI18N
        perfil2.setMaximumSize(new java.awt.Dimension(512, 512));
        perfil2.setPreferredSize(new java.awt.Dimension(512, 512));

        carrito.setBackground(new java.awt.Color(255, 255, 255));
        carrito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carrito.png"))); // NOI18N
        carrito.setMaximumSize(new java.awt.Dimension(512, 512));
        carrito.setPreferredSize(new java.awt.Dimension(512, 512));

        stock.setBackground(new java.awt.Color(255, 255, 255));
        stock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/stock.png"))); // NOI18N
        stock.setMaximumSize(new java.awt.Dimension(512, 512));
        stock.setPreferredSize(new java.awt.Dimension(512, 512));

        JDesktop1.setBackground(new java.awt.Color(255, 255, 255));
        JDesktop1.setPreferredSize(new java.awt.Dimension(596, 274));
        JDesktop1.setRequestFocusEnabled(false);

        javax.swing.GroupLayout JDesktop1Layout = new javax.swing.GroupLayout(JDesktop1);
        JDesktop1.setLayout(JDesktop1Layout);
        JDesktop1Layout.setHorizontalGroup(
            JDesktop1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
        );
        JDesktop1Layout.setVerticalGroup(
            JDesktop1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(carrito, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(perfil2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ventas)
                            .addComponent(trabajador)
                            .addComponent(productos)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(perfil1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cliente)))
                .addGap(18, 18, 18)
                .addComponent(JDesktop1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(perfil1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(cliente)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(perfil2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(trabajador)
                        .addGap(12, 12, 12)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(carrito, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(ventas)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(32, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(productos)
                        .addGap(46, 46, 46))))
            .addComponent(JDesktop1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(0, 51, 153));

        nombreEmpresa.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 36)); // NOI18N
        nombreEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        nombreEmpresa.setText("EMPRESA JH");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(nombreEmpresa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(nombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//MUESTRA EL INTERNAL FRAME DE PRODUCTOS
    private void productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productosMouseClicked
        this.JDesktop1.removeAll();

        com.mycompany.facturacion.productosFrame ventanaInterna = new com.mycompany.facturacion.productosFrame();

        ventanaInterna.setSize(704, 342);
        ventanaInterna.setClosable(true);
        ventanaInterna.setResizable(true);

        this.JDesktop1.add(ventanaInterna);

        this.JDesktop1.moveToFront(ventanaInterna);

        ventanaInterna.setVisible(true);
    }//GEN-LAST:event_productosMouseClicked

//MUESTRA EL INTERNAL FRAME DE VENTAS
    private void ventasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ventasMouseClicked
        this.JDesktop1.removeAll();

        com.mycompany.facturacion.ventasFrame ventanaInterna = new com.mycompany.facturacion.ventasFrame();

        ventanaInterna.setSize(704, 342);
        ventanaInterna.setClosable(true);
        ventanaInterna.setResizable(true);

        this.JDesktop1.add(ventanaInterna);

        this.JDesktop1.moveToFront(ventanaInterna);

        ventanaInterna.setVisible(true);
    }//GEN-LAST:event_ventasMouseClicked

//MUESTRA EL INTERNAL FRAME DE TRABAJADOR
    private void trabajadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trabajadorMouseClicked
        this.JDesktop1.removeAll();

        com.mycompany.facturacion.vendedoresFrame ventanaInterna = new com.mycompany.facturacion.vendedoresFrame();

        ventanaInterna.setSize(704, 342);
        ventanaInterna.setClosable(true);
        ventanaInterna.setResizable(true);

        this.JDesktop1.add(ventanaInterna);

        this.JDesktop1.moveToFront(ventanaInterna);

        ventanaInterna.setVisible(true);
    }//GEN-LAST:event_trabajadorMouseClicked

//MUESTRA EL INTERNAL FRAME DE CLIENTE
    private void clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clienteMouseClicked
        this.JDesktop1.removeAll();

        com.mycompany.facturacion.clienteFrame ventanaInterna = new com.mycompany.facturacion.clienteFrame();

        ventanaInterna.setSize(704, 342);
        ventanaInterna.setClosable(true);
        ventanaInterna.setResizable(true);

        this.JDesktop1.add(ventanaInterna);

        this.JDesktop1.moveToFront(ventanaInterna);

        ventanaInterna.setVisible(true);
    }//GEN-LAST:event_clienteMouseClicked
 

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new JFrame().setVisible(true));
    }                                       

                                
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane JDesktop1;
    private javax.swing.JLabel carrito;
    private javax.swing.JLabel cliente;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel nombreEmpresa;
    private javax.swing.JLabel perfil1;
    private javax.swing.JLabel perfil2;
    private javax.swing.JLabel productos;
    private javax.swing.JLabel stock;
    private javax.swing.JLabel trabajador;
    private javax.swing.JLabel ventas;
    // End of variables declaration//GEN-END:variables
}

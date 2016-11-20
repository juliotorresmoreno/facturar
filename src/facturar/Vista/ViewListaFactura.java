/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturar.Vista;

import facturar.Modelo.Cliente;
import facturar.Modelo.DetFactura;
import facturar.Modelo.Factura;
import facturar.Modelo.Repositorio;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hpajaro
 */
public class ViewListaFactura extends javax.swing.JFrame {

    private Repositorio<Cliente> regClientes = new Repositorio<>();
    private Repositorio<Factura> regFacturas = new Repositorio<>();
    private Repositorio<DetFactura> regDetFactura = new Repositorio<>();   
    
    
    public ViewListaFactura() {
        initComponents();
        regClientes.cargar("Cliente");
        List<Cliente> listaCli = regClientes.getLista();
        regFacturas.cargar("Factura");
        regDetFactura.cargar("DetFactura");
        
        List<Factura> listaFact = regFacturas.getLista();
        DefaultTableModel model = (DefaultTableModel) this.TablaFact.getModel();
        Object lista[] = new Object[5];
        for (int i = 0; i < listaFact.size(); i++) {
            lista[0] = (Integer) listaFact.get(i).getId();
            lista[1] = (String) listaFact.get(i).getNum();
            int xidcli = (Integer) listaFact.get(i).getIdCliente();
            Cliente cli = regClientes.traer(xidcli);
            lista[2] = cli.getRazonSocial();
            String DATE_FORMAT = "dd/MMMM/yyyy";
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            lista[3] = sdf.format(listaFact.get(i).getFecha());
            lista[4] = listaFact.get(i).getDireccion();
            model.addRow(lista);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaFact = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Num Fact", "Cliente", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Lista de  Facturas ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        TablaFact.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "No Fact", "Cliente", "Fecha", "Direccion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TablaFact);
        if (TablaFact.getColumnModel().getColumnCount() > 0) {
            TablaFact.getColumnModel().getColumn(0).setMinWidth(50);
            TablaFact.getColumnModel().getColumn(0).setPreferredWidth(50);
            TablaFact.getColumnModel().getColumn(0).setMaxWidth(50);
            TablaFact.getColumnModel().getColumn(1).setMinWidth(50);
            TablaFact.getColumnModel().getColumn(1).setPreferredWidth(50);
            TablaFact.getColumnModel().getColumn(1).setMaxWidth(50);
            TablaFact.getColumnModel().getColumn(2).setResizable(false);
            TablaFact.getColumnModel().getColumn(3).setMinWidth(120);
            TablaFact.getColumnModel().getColumn(3).setPreferredWidth(120);
            TablaFact.getColumnModel().getColumn(3).setMaxWidth(120);
            TablaFact.getColumnModel().getColumn(4).setMinWidth(300);
            TablaFact.getColumnModel().getColumn(4).setPreferredWidth(300);
            TablaFact.getColumnModel().getColumn(4).setMaxWidth(300);
        }

        jButton1.setText("Editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ViewFactura vfactura = new ViewFactura();
        vfactura.setLocationRelativeTo(null);
        vfactura.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        vfactura.setEstado("update");
        vfactura.txtId.setText(this.TablaFact.getModel().getValueAt(this.TablaFact.getSelectedRow(), 0).toString());
        vfactura.txtNum.setText(this.TablaFact.getModel().getValueAt(this.TablaFact.getSelectedRow(), 1).toString());
        
        int clienteid = Integer.parseInt(this.TablaFact.getModel().getValueAt(this.TablaFact.getSelectedRow(), 1).toString());
        for(int i = 0; i < regClientes.getLista().size(); i++) {
            if(regClientes.getLista().get(i).getId() == clienteid) {
                vfactura.cboClientes.setSelectedIndex(i);
                break;
            }
        }
        try {
            String[] tmp = TablaFact.getModel().getValueAt(this.TablaFact.getSelectedRow(), 3).toString().split("/");
            vfactura.datePicker.getModel().setYear(Integer.parseInt(tmp[0]));
            vfactura.datePicker.getModel().setMonth(Integer.parseInt(tmp[1]));
            vfactura.datePicker.getModel().setDay(Integer.parseInt(tmp[2]));
        }catch (Exception e) {}
        vfactura.txtDireccion.setText(this.TablaFact.getModel().getValueAt(this.TablaFact.getSelectedRow(), 4).toString());
        DefaultTableModel model = (DefaultTableModel)vfactura.TablaDet.getModel();
        double total = 0;
        for(int i = 0; i < regDetFactura.getLista().size(); i++) {
            DetFactura det = regDetFactura.getLista().get(i);
            if(det.getIdFactura() == Integer.parseInt(vfactura.txtId.getText())) {
                Object[] row = new Object[6];
                row[0] = det.getCodigo();
                row[1] = "";
                row[2] = det.getCant();
                row[3] = det.getPrecio();
                row[4] = det.getIva();
                row[5] = det.getCant() * det.getPrecio();
                total += det.getCant() * det.getPrecio();
                model.addRow(row);
            }
        }
        vfactura.txtSubtotal.setText(String.valueOf(total));
        
        vfactura.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewListaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewListaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewListaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewListaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewListaFactura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TablaFact;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

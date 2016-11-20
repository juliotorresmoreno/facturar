package facturar.Lib.Views;

import java.lang.reflect.Method;
import java.util.Properties;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.jdatepicker.impl.*;
import facturar.Lib.Model.Repositorio;

public class Formulario extends MasterForm {

    private Repositorio modelo;
    public Repositorio getModelo() {
        return modelo;
    }

    public void setModelo(Repositorio modelo) {
        this.modelo = modelo;
        this.construir();
    }

    public Formulario() {
        initComponents();
    }

    public void construir() {
        if(modelo == null)
            return;
        Method[] metodos = modelo.getClase().getMethods();
        Pattern valid = Pattern.compile("^(get)");
        for (int i = 0; i < metodos.length; i++) {
            String name = metodos[i].getName();
            Method metodo = metodos[i];
            if(!name.equals("getClass") && valid.matcher(name).find()) {
                int top = 18 * i;
                JLabel label = new JLabel();
                label.setSize(150, 30);
                label.setVisible(true);
                label.setLocation(10, top);
                label.setText(name.substring(3));
                pComponentes.add(label);
                switch(metodo.getReturnType().getName()) {
                    case "java.lang.String":                        
                        JTextField campoString = new JTextField();
                        campoString.setSize(260,30);
                        campoString.setVisible(true);
                        campoString.setLocation(200, top);
                        pComponentes.add(campoString);
                        break;
                    case "java.util.Date":
                        UtilDateModel model = new UtilDateModel();
                        Properties p = new Properties();
                        p.put("text.today", "Today");
                        p.put("text.month", "Month");
                        p.put("text.year", "Year");
                        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
                        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
                        
                        datePicker.setSize(260,30);
                        datePicker.setVisible(true);
                        datePicker.setLocation(200, top);
                        pComponentes.add(datePicker);
                        break;
                    case "int":
                        JTextField campoInt = new JTextField();
                        campoInt.setSize(260,30);
                        campoInt.setVisible(true);
                        campoInt.setLocation(200, top);
                        if(name.equals("getId")) {
                            campoInt.setEditable(false);
                        }
                        pComponentes.add(campoInt);                        
                        break;
                    default:
                        
                        break;
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pComponentes = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout pComponentesLayout = new javax.swing.GroupLayout(pComponentes);
        pComponentes.setLayout(pComponentesLayout);
        pComponentesLayout.setHorizontalGroup(
            pComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pComponentesLayout.setVerticalGroup(
            pComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 402, Short.MAX_VALUE)
        );

        jButton1.setText("Guardar");

        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pComponentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 266, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pComponentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCancelar)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bCancelarActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel pComponentes;
    // End of variables declaration//GEN-END:variables

    @Override
    public void loader() {
        
    }
}

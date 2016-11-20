package facturar.Controlador;

import facturar.Modelo.DetFactura;
import facturar.Modelo.Factura;
import facturar.Modelo.Helper;
import facturar.Modelo.Repositorio;
import facturar.Vista.ViewFactura;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FacturaControlador {
    Repositorio<DetFactura> regDetFactura = new Repositorio<>();
    Repositorio<Factura> regFactura = new Repositorio<>();
    
    public FacturaControlador() {
        regFactura = new Repositorio<>();
        regFactura.cargar("Factura");
        regDetFactura.cargar("DetFactura");
    }

    public void crear(ViewFactura vfact) {

        try {
            int idf = Integer.parseInt(vfact.txtId.getText());
            if (!(this.traer(idf) == null)) {
                JOptionPane.showMessageDialog(null, "Factura Existe.Verifique");
                return;
            }

            Factura fact = new Factura();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
            String fecha = vfact.getDatePicker().getModel().getDay() + "-" +
                           vfact.getDatePicker().getModel().getMonth()+ "-" +
                           vfact.getDatePicker().getModel().getYear();
            Date xfecha = formatoFecha.parse(fecha);
            fact.setFecha(xfecha);
            String ele = vfact.cboClientes.getSelectedItem().toString();
            String idCli = Helper.getKeyByValue(vfact.mapCli, ele);
            fact.setIdCliente(Integer.parseInt(idCli));
            fact.setId(Integer.parseInt(vfact.txtId.getText()));
            fact.setNum(vfact.txtNum.getText());
            fact.setDireccion(vfact.txtDireccion.getText());

            regFactura.adicionar(fact);
            regFactura.guardar("Factura");
            
            DefaultTableModel model = (DefaultTableModel)(vfact.getTablaDet().getModel());
            for(int i = 0; i < model.getRowCount(); i++) {
                DetFactura det = new DetFactura();
                det.setCodigo(model.getValueAt(i, 0).toString());
                det.setCant(Integer.parseInt(model.getValueAt(i, 2).toString()));
                det.setPrecio(Double.parseDouble(model.getValueAt(i, 3).toString()));
                det.setIva(Double.parseDouble(model.getValueAt(i, 4).toString()));
                regDetFactura.adicionar(det);
            }            
            regDetFactura.guardar("DetFactura");
            JOptionPane.showMessageDialog(null, "Registro Ha sido Guardado");
            vfact.btnAddProd.setEnabled(true);
        } catch (ParseException ex) {
            Logger.getLogger(FacturaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Factura traer(int id) {
        return (Factura) regFactura.traer(id);
    }
}

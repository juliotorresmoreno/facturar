package facturar.Controlador;

import facturar.Modelo.DetFactura;
import facturar.Modelo.Repositorio;
import facturar.Vista.ViewFactura;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DetFacturaControlador {
    Repositorio<DetFactura> regDetFactura;
    public DetFacturaControlador() {
        regDetFactura = new Repositorio<>();
        regDetFactura.cargar("DetFactura");
    }

    public void crear(ViewFactura vfact) {
        List<DetFactura> xlist = new ArrayList<>();
        int n = vfact.TablaDet.getRowCount();
        for (int i = 0; i < n; i++) {
            DetFactura dfact = new DetFactura();
            dfact.setId(i + 1);
            String xcodigo = vfact.TablaDet.getValueAt(i, 0).toString();
            dfact.setCodigo(xcodigo);

            int xcant = Integer.parseInt(vfact.TablaDet.getValueAt(i, 2).toString());
            dfact.setCant(xcant);

            double xprecio = Double.parseDouble(vfact.TablaDet.getValueAt(i, 3).toString());
            dfact.setPrecio(xprecio);

            double xiva = Double.parseDouble(vfact.TablaDet.getValueAt(i, 4).toString());
            dfact.setIva(xiva);

            int xidfact = Integer.parseInt(vfact.TablaDet.getValueAt(i, 6).toString());
            dfact.setIdFactura(xidfact);

            xlist.add(dfact);
        }
        regDetFactura.setLista(xlist);
        regDetFactura.guardar("DetFactura");
        JOptionPane.showMessageDialog(null, "Registros Han sido Guardados");
        vfact.dispose();

    }

    public DetFactura traer(int id) {
        return (DetFactura) regDetFactura.traer(id);
    }
}

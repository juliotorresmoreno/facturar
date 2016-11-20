package facturar.Controlador;

import facturar.Modelo.Cliente;
import facturar.Modelo.Repositorio;
import facturar.Modelo.Validar;
import facturar.Vista.ViewCliente;
import javax.swing.JOptionPane;

public class ClienteControlador {

    Repositorio<Cliente> regCliente;

    public ClienteControlador() {
        regCliente = new Repositorio<>();
        regCliente.cargar("Cliente");
    }

    public void crear(ViewCliente vcli) {
        int id = Integer.parseInt(vcli.txtId.getText());
        if (!(regCliente.traer(id) == null)) {
            JOptionPane.showMessageDialog(null, "Cliente Existe.Verifique");
            return;
        }
        if (!Validar.email(vcli.txtCorreo.getText())) {
            JOptionPane.showMessageDialog(null, "Email esta errado. Verifique");
            //this.txtCorreo.setText("");
            return;
        }
        Cliente cli = new Cliente();
        cli.setId(Integer.parseInt(vcli.txtId.getText()));
        cli.setNit(vcli.txtNit.getText());
        cli.setRazonSocial(vcli.txtRazonSocial.getText());
        cli.setCorreo(vcli.txtCorreo.getText());
        cli.setDireccion(vcli.txtDireccion.getText());
        cli.setTelefono(vcli.txtTelefono.getText());
        cli.setEstado(vcli.cboEstado.getSelectedItem().toString());

        regCliente.adicionar(cli);
        regCliente.guardar("Cliente");
        JOptionPane.showMessageDialog(null, "Registro Ha sido Guardado");
        vcli.dispose();
    }
    
    public void actualizar(ViewCliente vcli) {
        int id = Integer.parseInt(vcli.txtId.getText());
        if (regCliente.traer(id) == null) {
            JOptionPane.showMessageDialog(null, "Cliente no Existe.Verifique");
            return;
        }
        if (!Validar.email(vcli.txtCorreo.getText())) {
            JOptionPane.showMessageDialog(null, "Email esta errado. Verifique");
            //this.txtCorreo.setText("");
            return;
        }
        Cliente cli = new Cliente();
        cli.setId(Integer.parseInt(vcli.txtId.getText()));
        cli.setNit(vcli.txtNit.getText());
        cli.setRazonSocial(vcli.txtRazonSocial.getText());
        cli.setCorreo(vcli.txtCorreo.getText());
        cli.setDireccion(vcli.txtDireccion.getText());
        cli.setTelefono(vcli.txtTelefono.getText());
        cli.setEstado(vcli.cboEstado.getSelectedItem().toString());

        regCliente.borrar(regCliente.traer(cli.getId()));
        regCliente.adicionar(cli);
        regCliente.guardar("Cliente");
        JOptionPane.showMessageDialog(null, "Registro Ha sido Guardado");
        vcli.dispose();
    }

    public void eliminar(int id) {
        regCliente.borrar(regCliente.traer(id));
        regCliente.guardar("Cliente");
    }
    
    public boolean ExisteId(int id) {

        return false;
    }

}

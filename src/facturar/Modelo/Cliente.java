package facturar.Modelo;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

public class Cliente {

    private int id;

    private String nit;
    private String razonSocial;
    private String direccion;
    private String correo;
    private String telefono;
    private String estado;

    public Cliente() {

    }

    public Cliente(int id, String nit, String razonSocial) {

        this.id = id;
        this.nit = nit;
        this.razonSocial = razonSocial;
    }

    public Cliente(int id, String nit, String razonSocial, String direccion, String correo, String rtelefono, String estado) {
        this.id = id;
        this.nit = nit;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.estado = estado;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String rtelefono) {
        this.telefono = rtelefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}

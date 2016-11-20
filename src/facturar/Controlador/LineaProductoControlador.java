package facturar.Controlador;

import facturar.Modelo.Producto;
import facturar.Modelo.Repositorio;

public class LineaProductoControlador {

    Repositorio<Producto> regProducto;

    public LineaProductoControlador() {
        regProducto = new Repositorio<>();
        regProducto.cargar("Producto");
    }

    public Producto traer(int id) {
        return regProducto.traer(id);
    }
}

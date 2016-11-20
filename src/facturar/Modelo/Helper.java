package facturar.Modelo;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Helper {

    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static Type getTipoRepo(String clase) {
        Type tipo = null;
        switch (clase) {
            case "Cliente":
                tipo = new TypeToken<List<Cliente>>() {
                }.getType();
                break;
            case "Producto":
                tipo = new TypeToken<List<Producto>>() {
                }.getType();
                break;
            case "Factura":
                tipo = new TypeToken<List<Factura>>() {
                }.getType();
                break;
            case "DetFactura":
                tipo = new TypeToken<List<DetFactura>>() {
                }.getType();
                break;
        }
        return tipo;
    }
}

package facturar.Lib.Model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Repositorio<T> {

    private List<T> lista = new ArrayList<>();
    private Class clase;

    public Class getClase() {
        return clase;
    }
    
    public Repositorio(Class clase) {
        this.clase = clase;
    }

    public void guardar() {
        if (lista == null) {
            return;
        }
        Gson gson = new Gson();
        String json = gson.toJson(lista);

        String nombre = lista.get(0).getClass().getSimpleName();
        try (FileWriter writer = new FileWriter("datos/" + nombre + ".json")) {
            gson.toJson(lista, writer);

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void cargar(String nombre) {
        String ruta = "datos/" + nombre + ".json";

        File archivo = new File(ruta);
        if (!archivo.exists()) {
            return;
        }

        Gson gson = new Gson();
        FileReader reader;
        try {
            reader = new FileReader(ruta);

            Type tipo = new TypeToken<List<T>>() {}.getType();
            lista = gson.fromJson(reader, tipo);

        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }

    }

    public void adicionar(T t) {
        if (lista == null) {
            lista = new ArrayList<>();
        }

        lista.add(t);

    }

    public void borrar(T t) {
        lista.remove(t);
    }

    public void modificar(int id) {

    }

    public T traer(int id) {
        // metodo realizado por Julio Torres 
        Iterator<T> it = getLista().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            try {
                Class element = Class.forName(item.getClass().getName());
                if ((int) element.getMethod("getId").invoke(item) == id) {
                    return (T) item;
                }
            } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException ex) {
                Logger.getLogger(Repositorio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public List<T> getLista() {
        return lista;
    }

    public void setLista(List<T> t) {
        lista = t;
    }

    public static Class<?> getTipoGenerico(Object instance, Class<?> classOfInterest, int parameterIndex) {
        Class<?> subClass = instance.getClass();
        while (subClass != subClass.getSuperclass()) {
            // instance.getClass() is no subclass of classOfInterest or instance is a direct instance of classOfInterest
            subClass = subClass.getSuperclass();
            if (subClass == null) {
                throw new IllegalArgumentException();
            }
        }
        ParameterizedType parameterizedType = (ParameterizedType) subClass.getGenericSuperclass();
        return (Class<?>) parameterizedType.getActualTypeArguments()[parameterIndex];
    }

}

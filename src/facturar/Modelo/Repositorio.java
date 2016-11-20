package facturar.Modelo;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

public  class Repositorio <T>  {
  
   private List<T> lista=new ArrayList<>();
      
   public Repositorio() {
      
      
      
    }

    public  void  guardar(String nombre) {
      if (lista ==null ) return;
      Gson gson = new Gson();
      String json = gson.toJson(lista);
      
      try (FileWriter writer = new FileWriter("datos/"+nombre+".json")) {
            gson.toJson(lista, writer);
            
        } catch (IOException e) {
              System.out.println(e);
        }
    } 
    
     public void cargar (String nombre)  {
        String ruta="datos/"+nombre+".json";
    
        File archivo =new File(ruta);
        if (!archivo.exists()) return;
   
        Gson gson =new Gson();
         FileReader reader;
        try {
            reader = new FileReader(ruta); 
            Type tipo=Helper.getTipoRepo(nombre);// obtiene el tipo de repositorio generico 
            if (tipo != null ){ 
              lista = gson.fromJson(reader,tipo);             
            }             
          
        } catch (FileNotFoundException ex) {
           System.out.println(ex);
        }
             
    }
  
    public void adicionar(T t) {
       if (lista == null)
            lista=new ArrayList<>();      
       lista.add(t);
            
       
    }
     public int buscar(T t) throws InvocationTargetException{
          Iterator<T> it = getLista().iterator();
          while (it.hasNext()){
              if (it.equals(t)){
              try {
                   Class element = Class.forName(it.getClass().getName());
                   return (int)element.getMethod("getId").invoke(it);        
                }
              catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException ex) {
                 Logger.getLogger(Repositorio.class.getName()).log(Level.SEVERE, null, ex);
                }             
              }
          }
          return -1;
     }
    
    public void borrar(T t) {
       lista.remove(t);
    }

    
    public void modificar(int id) {
          
    }
    
 public T traer(int id) {
     if (lista == null)  return null;
     Iterator<T> it = getLista().iterator();
    while (it.hasNext()) {
        Object item = it.next();
    try {
        Class element = Class.forName(item.getClass().getName());
           int xid=(int)element.getMethod("getId").invoke(item);
        if (xid == id) {
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
         lista=t;
    }
    

    
}

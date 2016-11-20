/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturar.Lib.Model;

/**
 *
 * @author desarrollo
 */
public class Model {
    private static int increment;
    private int id;

    public int getId() {
        return id;
    }
    
    public Model() {
        this.id = ++increment;
    }
    
}

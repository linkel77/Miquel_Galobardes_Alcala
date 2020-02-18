/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miquel_galobardes_alcala;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

/**
 *Clase para la lógica del programa.
 * @author Miquel Galobardes Alcalá
 */
public class Logica {
    private final File fichero;
    
    public Logica(){
        fichero = new File(".\\productos.txt");
    }
    
    void escribirEnFichero(Producto p){
        try {
            FileOutputStream fich = new FileOutputStream(fichero,true);
            DataOutputStream ou = new DataOutputStream (fich);
            ou.writeUTF(p.getCodProducto());
            ou.writeUTF(p.getNombre());
            ou.writeUTF(p.getCantidad());
            ou.writeUTF(p.getDescripcion());
            ou.close(); 
        }
        catch(IOException e){
            System.out.println("EXCEPCION EN CLASE LOGICA, METODO ESCRIBIRENFICHERO");
        }
    }
    
    void recogerDatos(DefaultTableModel dtm){
        try{
            DataInputStream in = new DataInputStream(new FileInputStream(fichero));
            String[] producto = new String[4];
            while(in.available()>0){
               producto[0] = in.readUTF();;
               producto[1] = in.readUTF();
               producto[2] = in.readUTF();
               producto[3] = in.readUTF();
               dtm.addRow(producto);
            }
           in.close();
        }
        catch (IOException e){
            System.out.println("jor");
        }
    }
    
}

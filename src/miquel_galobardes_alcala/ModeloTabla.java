package miquel_galobardes_alcala;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * Clase para determinar el Modelo de la tabla y poder tener las funcionabilidades necesarias.
 * @author Miquel Galobardes Alcalá
 */
public class ModeloTabla extends DefaultTableModel {
    
    private final String[] headerTabla = {"codProducto", "Nombre", "Cantidad", "Descripción"};
    
    /**
     * Constructor llamando al padre y poniendo los títulos de las columnas
     */
    public ModeloTabla(){
        super();
        this.setColumnIdentifiers(headerTabla);
    }
    /**
     * Método para vaciar el modelo de datos.
     */
    void limpiarDatos(){
        this.setRowCount(0);
    }
    /**
     * Método que rellena de datos el modelo a partir de un Array que contiene las rows.
     * @param rows 
     */
    void insertarDatos(ArrayList<String[]> rows){
        rows.forEach((row) -> {
            this.addRow(row);
        });
        this.fireTableDataChanged();
    }
}

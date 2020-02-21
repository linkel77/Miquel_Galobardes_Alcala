package miquel_galobardes_alcala;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *Clase controlador, hara de puente entre la gráfica y la lógica.
 * @author Miquel Galobardes Alcalá
 */
class Controlador implements ActionListener {

    private Grafica grafica;
    private Logica logica;
    /**
     * Constructor que recibe la grafica y la lógica para interactuar entre ellas.
     * @param grafica
     * @param logica 
     */
    public Controlador(Grafica grafica, Logica logica){
        this.grafica = grafica;
        this.logica = logica;
        setListenersGrafica();     
    }
    /**
     * Método para setearlos listeners a esta clase.
     */
    private void setListenersGrafica(){
        this.grafica.setListeners(this);
    }
    /**
     * Método que salta al darse un evento, se identifica el componente y se ejecuta el codigo correspondiente de la lógica.
     * @param ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        ModeloTabla tm = grafica.getTableModel();
        switch (command){
            case "ALTA":
                this.altaProducto();
                break;
            case "LISTAR":
                tm.limpiarDatos();
                tm.insertarDatos(logica.getDatos());
                grafica.setTextoNarrador("SE ACABA DE LISTAR EL ARCHIVO.");
                break;
            case "LIMPIAR":
                tm.limpiarDatos();
                grafica.setTextoNarrador("LISTA LIMPIADA!");
                break;
            case "BUSCAR":
                tm.limpiarDatos();
                ArrayList<String[]> datos = logica.buscarProducto(grafica.getCodProductoTexto());
                String encontrado = (datos.size()>0?"PRODUCTO ENCONTRADO!":"PRODUCTO NO ENCONTRADO!");
                tm.insertarDatos(datos);
                grafica.setTextoNarrador(encontrado);
                break;
            default:
                break;
        }
    }
    
    private void altaProducto(){
        UIManager.put("OptionPane.minimumSize",new Dimension(300,300)); 
        VentanaAlta v_alta = new VentanaAlta();
        int result = JOptionPane.showConfirmDialog(null, v_alta, 
               "ALTA DE PRODUCTO", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION){
            Producto prod = new Producto(v_alta.getValores());
            logica.escribirEnFichero(prod);
            grafica.setTextoNarrador("PRODUCTO CREADO\n" + prod.toString());
        }
    }   
}

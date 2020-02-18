package miquel_galobardes_alcala;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Miquel Galobardes Alcalá.
 */
public class Grafica extends JFrame{
    
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    private JButton alta_productos_button;
    private JButton lista_productos_button;
    private JButton limpiar_lista_button;
    private JLabel buscar_productos_label;
    private JTextField buscar_productos_textfield;
    private JTable tabla_productos;
    private DefaultTableModel dtm;
    private JScrollPane tabla_scrollpane;
    private Object[][] data;
    private JTextArea narrador_textArea;
    private final String[] headerTabla = {"codProducto", "Nombre", "Cantidad", "Descripción"};
    
    public Grafica (){
        super("Programa para productos almacenados en .txt"); //Creamos la ventana y ponemos titulo.
        crearVentanaMain();
        colocarComponentes();
        this.setVisible(true); //La hacemos visible
    }
    /**
     * Método para crear el Frame(Ventana) principal, añadirle su Layout y hacerlo visible.
     */
    private void crearVentanaMain(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Para que el programa se pare cuando se cierra la ventana.
        this.setSize(1000, 800); //Tamaño de la ventana
        this.setLocationRelativeTo(null); //Para que la ventana se centre en el monitor que la contenga.
        gbl = new GridBagLayout(); //Creamos el Layout
        gbc = new GridBagConstraints();
        this.getContentPane().setLayout(gbl); //Seteamos el layout al JFrame.
    }
    /**
     * Método que llama a los métodos que setteo de los componentes que van dentro del JFrame.
     */
    private void colocarComponentes(){    
        instanciaComponentes();
        setFonts();
        disenyoGridBagLayout();
    }
    /**
     * Método que coloca donde queremos los componentes gráficos.
     */
    private void disenyoGridBagLayout(){
        gbc.fill = GridBagConstraints.BOTH;
        setGridBagConstraintsXY(0,3,3,1,1,0.5);
        this.getContentPane().add(alta_productos_button,gbc);
        setGridBagConstraintsXY(0,4,3,1,1,0.5);
        this.getContentPane().add(lista_productos_button,gbc);
        setGridBagConstraintsXY(0,5,3,1,1,0.5);
        this.getContentPane().add(limpiar_lista_button,gbc);
        gbc.fill = GridBagConstraints.NONE;
        setGridBagConstraintsXY(0,0,1,1,0.2,0.1);
        buscar_productos_label.setHorizontalAlignment(JLabel.LEFT);
        buscar_productos_label.setHorizontalTextPosition(JLabel.LEFT);
        this.getContentPane().add(buscar_productos_label,gbc);
        gbc.fill = GridBagConstraints.BOTH;
        setGridBagConstraintsXY(2,0,1,1,1,0.1);
        this.getContentPane().add(buscar_productos_textfield,gbc);
        setGridBagConstraintsXY(3,0,3,6,1,1);
        this.getContentPane().add(tabla_scrollpane,gbc);
        setGridBagConstraintsXY(0,6,6,4,1,2);
        this.getContentPane().add(narrador_textArea,gbc);
    }
    /**
     * Método que inicializa las variables de la clase.
     */
    private void instanciaComponentes(){
        //INSTANCIACION DE LOS COMPONENTES CON LOS TEXTOS QUE NECESITAN.
        alta_productos_button = new JButton("Alta producto");
        lista_productos_button = new JButton("Listar productos");
        limpiar_lista_button = new JButton("Limpiar Lista");
        buscar_productos_label = new JLabel("Buscar:");
        buscar_productos_textfield = new JTextField();
        narrador_textArea = new JTextArea("HOLA SOY EL NARRADOR DEL PROGRAMA");        
        //MODELO DE LA TABLA
        
        //INICIACION DE LA TABLA Y INSERTARLA EN EL SCROLL PANE.
        tabla_productos = new JTable();
        setearModeloTabla();
        tabla_scrollpane= new JScrollPane(tabla_productos);
        tabla_productos.setFillsViewportHeight(true);   
    }
    /**
     * Método para hacer mas facil el setteo de GridBagConstraints para poder colocar los componentes donde queremos.
     * @param x columna
     * @param y fila
     * @param x2 columnas que ocupa
     * @param y2 filas que ocupa
     * @param tx tamaño columna
     * @param ty tamaño fila
     */
    private void setGridBagConstraintsXY(int x, int y, int x2, int y2, double tx, double ty){
        gbc.gridx=x;
        gbc.gridy=y;
        gbc.gridwidth = x2;
        gbc.gridheight = y2;
        gbc.weightx = tx;
        gbc.weighty = ty;
    }
    /**
     * Setteo de Fuentes y colores de los componentes.
     */
    private void setFonts(){
        //CREACIÓN DE FUENTES
        Font fuente = new Font("Arial", Font.PLAIN, 40);
        Font fuente2 = new Font("Arial", Font.PLAIN, 20);
        //SETTEO DE FUENTES
        alta_productos_button.setFont(fuente);
        lista_productos_button.setFont(fuente);
        limpiar_lista_button.setFont(fuente);
        buscar_productos_textfield.setFont(fuente);
        buscar_productos_label.setFont(fuente2);   
        narrador_textArea.setBackground(Color.black);
        narrador_textArea.setForeground(Color.white);
    }
    /**
     * Setear listeners para que el controlador pueda detectar eventos e identificarlos.
     * @param listener 
     */
    void setListeners(ActionListener listener){
        alta_productos_button.setActionCommand("ALTA");
        alta_productos_button.addActionListener(listener);
        lista_productos_button.setActionCommand("LISTAR");
        lista_productos_button.addActionListener(listener);
        limpiar_lista_button.setActionCommand("LIMPIAR");
        limpiar_lista_button.addActionListener(listener);
        buscar_productos_textfield.setActionCommand("BUSCAR");
        buscar_productos_textfield.addActionListener(listener);
        
    }
    /**
     * Getter para el JTextArea que contiene el narrador del programa.
     * @return narrador_textArea
     */
    JTextArea getNarrador(){
        return narrador_textArea;
    }
    
    DefaultTableModel getTableModel(){
        return dtm;
    }
    void setearModeloTabla(){
        dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(headerTabla);
        tabla_productos.setModel(dtm);
        dtm.fireTableDataChanged();
    }
}

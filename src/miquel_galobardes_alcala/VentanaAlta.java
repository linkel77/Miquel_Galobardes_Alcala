package miquel_galobardes_alcala;

import java.awt.Dimension;
import java.awt.event.HierarchyEvent;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


/**
 *Clase para crear el panel para crear productos.
 * @author Miquel Galobardes Alcalá
 */
public class VentanaAlta extends JPanel {
    
    private JTextField codproducto_field;
    private JTextField nombre_field;
    private JTextField cantidad_field;
    private JTextArea descripcion_textArea;
    
    public VentanaAlta(){
        //LAYOUT
        BoxLayout bx = new BoxLayout(this, BoxLayout.PAGE_AXIS); 
        this.setLayout(bx);
        //CREACION DE LABELS, TEXTFIELD Y TEXTAREA PARA LA VENTANA CON SU CONFIGURACION GRÁFICA.
        JLabel codproducto_label = new JLabel("CODIGO DEL PRODUCTO");
        codproducto_label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        codproducto_field = new JTextField();
        codproducto_field.setHorizontalAlignment(JTextField.CENTER);
        //Lo que ha costado encontrar una manera de focusear el JFieldText... 
        //Solo funciona en JAVA 8 porque usa una expresion lambda.
        
        codproducto_field.addHierarchyListener(e -> {
        if(e.getComponent().isShowing() && (e.getChangeFlags() & HierarchyEvent.SHOWING_CHANGED) != 0)
        SwingUtilities.invokeLater(e.getComponent()::requestFocusInWindow);
        });
        
        JLabel nombre_label = new JLabel("NOMBRE DEL PRODUCTO");
        nombre_label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        nombre_field = new JTextField();
        nombre_field.setHorizontalAlignment(JTextField.CENTER);
        JLabel cantidad_label = new JLabel("CANTIDAD");
        cantidad_label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        cantidad_field = new JTextField();
        cantidad_field.setHorizontalAlignment(JTextField.CENTER);
        JLabel descripcion_label = new JLabel("DESCRIPCION");
        descripcion_label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        descripcion_textArea = new JTextArea();
        JScrollPane textarea_pane = new JScrollPane(descripcion_textArea);
        descripcion_textArea.setPreferredSize(new Dimension(200,150)); //PARA HACER LA CAJA MAS GRANDE
        descripcion_textArea.setLineWrap(true); //PARA QUE EL TEXTO NO SALGA DE LA CAJA
        //AÑADIMOS LOS COMPONENTES AL PANEL
        this.add(codproducto_label);
        this.add(codproducto_field);
        this.add(nombre_label);
        this.add(nombre_field);
        this.add(cantidad_label);
        this.add(cantidad_field);
        this.add(descripcion_label);
        this.add(textarea_pane);
    }
    String[] getValores(){
        String[] valores = {codproducto_field.getText(),nombre_field.getText(),cantidad_field.getText(),descripcion_textArea.getText()};
        return valores;
    }
    
    
    
}

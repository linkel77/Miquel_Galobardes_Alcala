package miquel_galobardes_alcala;

/**
 * Clase para gestionar las propiedades y atributos de los productos.
 * @author Miquel Galobardes Alcalá
 */
public class Producto {
    
    private String codProducto;
    private String nombre;
    private String cantidad;
    private String descripcion;
    
    public Producto(String codproducto, String nombre, String cantidad, String descripcion){
        this.codProducto = codproducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
    }
        
    public Producto (String[] productoArray){
        this.codProducto = productoArray[0];
        this.nombre = productoArray[1];
        this.cantidad = productoArray[2];
        this.descripcion = productoArray[3];
    }
    
    public String[] getProducto(){
        String[] productoArray= {this.codProducto, this.nombre, this.cantidad,this.descripcion};
        return productoArray;
    }
    
    public String getCodProducto() {
        return codProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    @Override
    public String toString(){
        return "Código: " + this.codProducto + "\nNombre: " + this.nombre + "\nCantidad: " + this.cantidad + "\nDescripción: " +
                this.descripcion;
    }
}

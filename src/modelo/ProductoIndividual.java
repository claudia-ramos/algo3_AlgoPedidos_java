package modelo;

public class ProductoIndividual implements Producto {

    private String nombre;
    private int cantidad;
    private double precio;

    public ProductoIndividual(String nombreProducto, double precioProducto, int cantidadProducto) {
        this.nombre = nombreProducto;
        this.cantidad = cantidadProducto;
        this.precio = precioProducto;
    }

    @Override
    public void establecerCantidad(int cant) {
        this.cantidad = cant;
    }

    @Override
    public void establecerNombre(String nombreProducto) {
        this.nombre = nombreProducto;
    }

    @Override
    public void establecerPrecio(double precioProducto) {
        this.precio = precioProducto;
    }

    @Override
    public int obtenerCantidad() {
        return this.cantidad;
    }

    @Override
    public Cupon obtenerCupon(Cupon cupon) {
        return cupon;
    }

    @Override
    public String obtenerNombre() {
        return this.nombre;
    }

    @Override
    public double obtenerPrecio() {
        return this.precio;
    }
}

package modelo;

public class ProductoMenu implements Producto {

    private String nombre;
    private int cantidad;
    private double precio;

    public ProductoMenu(String nombreMenu, double precioMenu, int cantidadMenu) {
        this.nombre = nombreMenu;
        this.cantidad = cantidadMenu;
        this.precio = precioMenu;
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
        return (new CuponSinDescuento());
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

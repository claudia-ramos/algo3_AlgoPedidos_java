package modelo;

public interface Producto {
    void establecerCantidad(int cant);
    void establecerNombre(String nombreProducto);
    void establecerPrecio(double precioProducto);
    int obtenerCantidad();
    Cupon obtenerCupon(Cupon cupon);
    String obtenerNombre();
    double obtenerPrecio();
}

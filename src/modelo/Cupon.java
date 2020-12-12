package modelo;

public interface Cupon {
    double aplicarDescuento(double precio_final);
    void establecerDescuento(double descuento);
    double obtenerDescuento();
}

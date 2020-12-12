package modelo;

public class CuponSinDescuento implements Cupon {

    @Override
    public double aplicarDescuento(double precio_final) {
        return precio_final;
    }

    @Override
    public void establecerDescuento(double descuento) {
    }

    @Override
    public double obtenerDescuento() {
        return 0;
    }
}

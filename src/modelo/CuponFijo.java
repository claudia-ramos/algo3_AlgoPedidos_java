package modelo;

public class CuponFijo implements Cupon {

    private double valorDescuento;

    public CuponFijo(double descuento) {
        establecerDescuento(descuento);
    }

    @Override
    public double aplicarDescuento(double precio_final) {
        return (precio_final - this.valorDescuento);
    }

    @Override
    public void establecerDescuento(double descuento) {
        if( descuento < 0 )
            throw new CuponFijoNegativoException();

        this.valorDescuento = descuento;
    }

    @Override
    public double obtenerDescuento() {
        return this.valorDescuento;
    }
}

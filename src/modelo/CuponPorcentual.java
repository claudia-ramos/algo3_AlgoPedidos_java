package modelo;

public class CuponPorcentual implements Cupon {

    private double valorDescuento;

    public CuponPorcentual(double descuento) {
        establecerDescuento(descuento);
    }

    @Override
    public double aplicarDescuento(double precio_final) {
        return  (precio_final * this.valorDescuento);
    }

    @Override
    public void establecerDescuento(double descuento) {
        if( descuento > 100 )
            throw new CuponPorcentualMayorA100Exception();

        this.valorDescuento = (1 - (descuento/100));
    }

    @Override
    public double obtenerDescuento() {
        return (this.valorDescuento);
    }
}

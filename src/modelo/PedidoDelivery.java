package modelo;

public class PedidoDelivery extends Pedido {

    private final double recargo = 20;

    public void establecerCuponPorcentaje(int valor) {

    }

    public void establecerCuponDescuento(int valor) {

    }

    @Override
    public double obtenerPrecioDelPedido() {
        double multiplicacion = ((this.recargo / 100) + 1);
        double resultado = this.obtenerSumaTotalDeLosProductos();

        return ( multiplicacion * resultado );
    }

    @Override
    public void quitarCuponDescuento() {

    }

}

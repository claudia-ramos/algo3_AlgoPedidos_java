package modelo;

public class PedidoRetiro extends Pedido {

    private Cupon cupon = new CuponSinDescuento();

    public void establecerCuponDescuento(int valorDescuento) {
        this.cupon = new CuponFijo(valorDescuento);
    }

    public void establecerCuponPorcentaje(int valorDescuento) {
        this.cupon = new CuponPorcentual(valorDescuento);
    }

    @Override
    public double obtenerPrecioDelPedido() {
        int precio_final = this.obtenerSumaTotalDeLosProductos();

        for(Producto producto : lista_pedidos) {
           this.cupon = producto.obtenerCupon(this.cupon);
        }

        return (this.cupon.aplicarDescuento(precio_final));
    }

    @Override
    public void quitarCuponDescuento() {
        cupon = new CuponSinDescuento();
    }
}

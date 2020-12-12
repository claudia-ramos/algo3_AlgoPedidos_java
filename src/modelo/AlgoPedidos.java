package modelo;

import java.util.HashMap;

public class AlgoPedidos {

    private final HashMap<String, Pedido> hash_pedidos = new HashMap<>();

    private Pedido obtenerTipoDePedido(String cliente) throws ElClienteNoExisteException {
        Pedido pedido = this.hash_pedidos.get(cliente);

        if( pedido == null )
            throw new ElClienteNoExisteException();

        return pedido;
    }

    public void actualizarProductoConNombre (String nombreProducto, int nuevaCantidad, String cliente)  {
        this.obtenerTipoDePedido(cliente).actualizarCantidadDeProducto(nombreProducto, nuevaCantidad);
    }

    public void agregarCuponFijoAPedidoDe(String cliente, int valor) {
        this.obtenerTipoDePedido(cliente).establecerCuponDescuento(valor);
    }

    public void agregarCuponPorcentualAPedidoDe(String cliente, int valor)  {
        this.obtenerTipoDePedido(cliente).establecerCuponPorcentaje(valor);
    }

    public void agregarMenu(String nombreMenu, double precioMenu, int cantidadMenu, String cliente) {
        ProductoMenu menu = new ProductoMenu(nombreMenu, precioMenu, cantidadMenu);

        this.obtenerTipoDePedido(cliente).agregarProductoAPedido(menu);
    }

    public void agregarProducto(String nombreProducto, double precioProducto, int cantidadProducto, String cliente)  {
        ProductoIndividual producto = new ProductoIndividual(nombreProducto, precioProducto, cantidadProducto);

        this.obtenerTipoDePedido(cliente).agregarProductoAPedido(producto);
    }

    public int cantidadProductosEnPedido(String cliente)  {
        return this.obtenerTipoDePedido(cliente).obtenerCantidadDeProductos();
    }

    public void crearPedidoConDelivery(String cliente) {
        if( this.hash_pedidos.containsKey(cliente) ) {
            throw new ElClienteYaElClienteYaTieneUnPedidoException();
        }

        this.hash_pedidos.put(cliente, new PedidoDelivery());
    }

    public void crearPedidoConRetiro(String cliente) {
        if( this.hash_pedidos.containsKey(cliente)  )
            throw new ElClienteYaElClienteYaTieneUnPedidoException();

        this.hash_pedidos.put(cliente, new PedidoRetiro());
    }

    public double precioPedido(String cliente) {
        return (this.obtenerTipoDePedido(cliente).obtenerPrecioDelPedido());
    }

    public void removerCuponDePedido(String cliente)  {
        this.obtenerTipoDePedido(cliente).quitarCuponDescuento();
    }

    public void removerMenu(String nombre, String cliente)  {
        this.obtenerTipoDePedido(cliente).eliminarProductoDelPedido(nombre);
    }

    public void removerProducto(String nombre, String cliente) {
        this.obtenerTipoDePedido(cliente).eliminarProductoDelPedido(nombre);
    }
}

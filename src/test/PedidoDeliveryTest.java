import modelo.PedidoDelivery;
import modelo.Producto;
import modelo.ProductoIndividual;
import modelo.ProductoMenu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoDeliveryTest {
    PedidoDelivery delivery = new PedidoDelivery();

    @Test
    public void test01IniciaConCantidadDeProductosCero() {
        assertEquals( delivery.obtenerCantidadDeProductos(), 0 );
    }

    @Test
    public void test02SeAgreganProductosYSeObtieneLaCantidadDeProductos() {
        Producto producto1 = new ProductoIndividual("Coca-Cola", 120.0, 2);
        Producto producto2 = new ProductoMenu("Menu milanesa", 270.0, 2);

        delivery.agregarProductoAPedido(producto1);
        delivery.agregarProductoAPedido(producto2);

        assertEquals( delivery.obtenerCantidadDeProductos(), 4);
    }

    @Test
    public void test03SeAgreganProductosAlPedidoSeObtieneLaSumaTotalSinRecargo() {
        Producto producto1 = new ProductoIndividual("Coca-Cola", 120.0, 2);
        Producto producto2 = new ProductoMenu("Menu milanesa", 270.0, 2);

        delivery.agregarProductoAPedido(producto1);
        delivery.agregarProductoAPedido(producto2);

        assertEquals( delivery.obtenerSumaTotalDeLosProductos(), 780);
    }

    @Test
    public void test04SeAgreganProductosAlPedidoSeObtieneElPrecioFinal() {
        Producto producto1 = new ProductoIndividual("Coca-Cola", 120.0, 2);
        Producto producto2 = new ProductoMenu("Menu asado", 320, 1);

        delivery.agregarProductoAPedido(producto1);
        delivery.agregarProductoAPedido(producto2);

        assertEquals( delivery.obtenerPrecioDelPedido(), 672 );
    }

    @Test
    public void test05SeAgreganProductosAlPedidosYSeActualiza() {
        Producto producto1 = new ProductoIndividual("Coca-Cola", 120.0, 2);

        delivery.agregarProductoAPedido(producto1);
        delivery.actualizarCantidadDeProducto("Coca-Cola", 3);

        assertEquals(delivery.obtenerPrecioDelPedido(), 360.0*1.2);
    }

    @Test
    public void test06SeAgreganProductosLuegoSeBorran() {
        Producto producto1 = new ProductoIndividual("Coca-Cola", 120.0, 2);
        Producto producto2 = new ProductoIndividual("Milanesa", 320.0, 1);
        Producto producto3 = new ProductoIndividual("Fritas", 150.0, 2);

        delivery.agregarProductoAPedido(producto1);
        delivery.agregarProductoAPedido(producto2);
        delivery.agregarProductoAPedido(producto3);

        delivery.eliminarProductoDelPedido("Coca-Cola");
        delivery.eliminarProductoDelPedido("Fritas");

        assertEquals(delivery.obtenerPrecioDelPedido(), 320*1.2);
    }

}
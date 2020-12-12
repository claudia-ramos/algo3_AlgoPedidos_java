import modelo.PedidoRetiro;
import modelo.Producto;
import modelo.ProductoIndividual;
import modelo.ProductoMenu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoRetiroTest {

    private final PedidoRetiro retiro = new PedidoRetiro();

    @Test
    public void test01IniciaConCantidadDeProductosCero(){
        assertEquals(retiro.obtenerCantidadDeProductos(), 0);
    }

    @Test
    public void test02SeAgregaCuponDeDescuentoLuegoDeAgregarUnMenu() {
        Producto menu = new ProductoMenu("Menu Principal", 320.0, 1);

        retiro.agregarProductoAPedido(menu);
        retiro.establecerCuponDescuento(20);

        assertEquals(retiro.obtenerPrecioDelPedido(), 320.0);
    }

    @Test
    public void test03SeQuitaCuponDeDescuento() {
        Producto producto = new ProductoIndividual("7Up", 125.0, 2);
        Producto menu = new ProductoMenu("Menu Principal", 320.0, 1);

        retiro.agregarProductoAPedido(producto);
        retiro.agregarProductoAPedido(menu);

        retiro.quitarCuponDescuento();

        assertEquals(retiro.obtenerPrecioDelPedido(), 570.0);
    }

    @Test
    public void test04SeAplicaCuponPorcentual() {
        retiro.establecerCuponPorcentaje(50);

        Producto producto = new ProductoIndividual("7Up", 125.0, 2);
        Producto menu = new ProductoMenu("Menu Principal", 320.0, 1);

        retiro.agregarProductoAPedido(producto);
        retiro.agregarProductoAPedido(menu);


        assertEquals(retiro.obtenerPrecioDelPedido(), 570.0);
    }
}
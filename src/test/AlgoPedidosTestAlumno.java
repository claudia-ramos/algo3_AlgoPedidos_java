import modelo.AlgoPedidos;
import modelo.CuponFijoNegativoException;
import modelo.ElClienteYaElClienteYaTieneUnPedidoException;
import modelo.ElClienteNoExisteException;
import modelo.ProductoNoExisteException;
import modelo.CuponPorcentualMayorA100Exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class AlgoPedidosTestAlumno {
    private final AlgoPedidos algoPedidos = new AlgoPedidos();

    @Test
    public void test01ElClienteNoExisteySeArrojaUnaExcepcion() {
        assertThrows(ElClienteNoExisteException.class, () -> algoPedidos.precioPedido("Lucas"));
    }

    @Test
    public void test02SeAsignaUnCuponNegativoYOtroNegativoSoloUnoDebeArrojarExcepcion() {
        algoPedidos.crearPedidoConRetiro("Lucas");

        assertThrows(CuponFijoNegativoException.class, () -> algoPedidos.agregarCuponFijoAPedidoDe("Lucas", -1));
    }

    @Test
    public void test03SeCreanDosPedidosParaUnMismoClienteSeDebeArrojarExcepcion() {
        algoPedidos.crearPedidoConDelivery("Lucas");

        assertThrows(ElClienteYaElClienteYaTieneUnPedidoException.class, () -> algoPedidos.crearPedidoConRetiro("Lucas"));
    }

    @Test
    public void test04SeAplicaUnCuponDePorcentajeMayorA100() {
        algoPedidos.crearPedidoConRetiro("Lucas");

        algoPedidos.agregarProducto("Ensalada", 200.0, 1, "Lucas");

        assertThrows(CuponPorcentualMayorA100Exception.class, () -> algoPedidos.agregarCuponPorcentualAPedidoDe("Lucas", 101));
    }

    @Test
    public void test05SeAgregaUnCuponPrimeroLuegoUnMenuNoDeberiaGenerarDescuento() {
        algoPedidos.crearPedidoConRetiro("Lucas");

        algoPedidos.agregarCuponFijoAPedidoDe("Lucas", 32);

        algoPedidos.agregarMenu("Menu domingo", 260.0, 1, "Lucas");
        algoPedidos.agregarProducto("Nuka-Cola", 120.0, 2, "Lucas");

        assertEquals(algoPedidos.precioPedido("Lucas"), 500.0);
    }

    @Test
    public void test06SeCambiaCantidadDeProductosEnUnProductoInexistente() {
        algoPedidos.crearPedidoConRetiro("Lucas");

        assertThrows(ProductoNoExisteException.class, () -> algoPedidos.actualizarProductoConNombre("Gaseosa", 5, "Lucas"));
    }

    @Test
    public void test07SeEliminaUnProductoInexistente() {

        algoPedidos.crearPedidoConRetiro("Lucas");

        assertThrows(ProductoNoExisteException.class, () -> algoPedidos.removerProducto("Hamburguesa", "Lucas"));
    }
}

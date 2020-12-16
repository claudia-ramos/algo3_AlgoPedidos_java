import modelo.AlgoPedidos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlgoPedidosTest {

    private final AlgoPedidos algoPedidos = new AlgoPedidos();

    @Test
    public void test01SeAgreganProductosAPedidoParaRetirar() {
        algoPedidos.crearPedidoConRetiro("Eugenio");
        algoPedidos.agregarProducto("Milanesa", 250.0, 2, "Eugenio");
        algoPedidos.agregarProducto("Gelatina", 100.0, 1, "Eugenio");

        assertEquals( algoPedidos.precioPedido("Eugenio"), 600.0 );
    }

    @Test
    public void test02SeAgreganProductosAPedidoConDelivery() {
        algoPedidos.crearPedidoConDelivery("Santiago");

        algoPedidos.agregarProducto("Asado", 500.0, 1, "Santiago");
        algoPedidos.agregarProducto("Vino", 250.0, 1, "Santiago");

        assertEquals( algoPedidos.precioPedido("Santiago") , 750*1.2 );
    }


    @Test
    public void test03SeAgregaMenuAPedido()  {
        algoPedidos.crearPedidoConRetiro("Pablo");
        algoPedidos.agregarMenu("Menu viernes", 200.0, 1, "Pablo");
        algoPedidos.agregarProducto("Gaseosa", 250.0, 1, "Pablo");

        assertEquals( algoPedidos.precioPedido("Pablo"), 450, 0.1 );
    }

    @Test
    public void test04AplicarCuponDeDescuentoPorcentualAPedidoConProductos() {
        algoPedidos.crearPedidoConRetiro("Tomás");

        algoPedidos.agregarProducto("Ensalada", 200.0, 1, "Tomás");
        algoPedidos.agregarCuponPorcentualAPedidoDe("Tomás", 10);

        assertEquals( algoPedidos.precioPedido("Tomás") , (200*0.9), 0.01 );
    }

    @Test
    public void test05SeCambiaCantidadDeProductosEnPedido() {
        algoPedidos.crearPedidoConRetiro("Carlos");

        algoPedidos.agregarMenu("Menu viernes", 200.0, 1, "Carlos");
        algoPedidos.agregarProducto( "Gaseosa", 250.0, 1, "Carlos");

        assertEquals( algoPedidos.cantidadProductosEnPedido("Carlos"), 2 );

        algoPedidos.actualizarProductoConNombre("Gaseosa", 3, "Carlos");

        assertEquals( algoPedidos.cantidadProductosEnPedido("Carlos"), 4 );
    }

    @Test
    public void test06AplicarCuponDeDescuentoFijoAPedidoConProductos()  {
        algoPedidos.crearPedidoConRetiro("Lucas");
        algoPedidos.agregarCuponFijoAPedidoDe("Lucas", 15);

        algoPedidos.agregarProducto("Milanesa", 350.0, 1, "Lucas" ) ;

        assertEquals( algoPedidos.precioPedido("Lucas"), 335.0, 0.01);
    }

    @Test
    public void test07AgregarCuponAPedidoConMenuNoRealizaDescuento() {
        algoPedidos.crearPedidoConRetiro("Julian");

        algoPedidos.agregarMenu("Menu Jueves", 200.0, 1, "Julian");
        algoPedidos.agregarProducto("Ensalada", 200.0, 2, "Julian");

        algoPedidos.agregarCuponFijoAPedidoDe("Julian", 15);

        assertEquals( algoPedidos.precioPedido("Julian"), 600.0 );
    }

    @Test
    public void test08RemoverCuponDeDescuentoAPedido()  {

        algoPedidos.crearPedidoConRetiro("Martin");

        algoPedidos.agregarCuponFijoAPedidoDe("Martin", 15);
        algoPedidos.agregarProducto("Pizza",  (int) 350.0, 1, "Martin");

        assertEquals(algoPedidos.precioPedido("Martin"), 335.0, 0.01);

        algoPedidos.removerCuponDePedido("Martin");

        assertEquals(algoPedidos.precioPedido("Martin"), 350.0, 0.01);
    }

    @Test
    public void test09RemoverProductosAPedido() {
        algoPedidos.crearPedidoConDelivery("Sebas");

        algoPedidos.agregarProducto("Asado", 500.0, 1, "Sebas");
        algoPedidos.agregarMenu("Menu lunes", 200.0,1, "Sebas");
        algoPedidos.agregarProducto("Vino", 250.0, 1, "Sebas");

        assertEquals( algoPedidos.precioPedido("Sebas"), 950*1.2 ); /* 20% extra */

        algoPedidos.removerProducto("Vino", "Sebas");
        algoPedidos.removerMenu("Menu lunes", "Sebas");

        assertEquals( algoPedidos.precioPedido("Sebas"), 500*1.2 );

    }
}
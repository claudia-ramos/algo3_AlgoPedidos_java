import modelo.Cupon;
import modelo.CuponFijo;
import modelo.CuponPorcentual;
import modelo.CuponSinDescuento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuponTest {

    @Test
    public void test01SeAplicaUnCuponFijoAUnprecio() {
        double precio_final = 500;

        Cupon cupon = new CuponFijo(200);

        assertEquals( cupon.aplicarDescuento(precio_final), 300 );
    }

    @Test
    public void test02SeAplicaUnCuponPorcentualAUnPrecio() {
        double precio_final = 500;

        Cupon cupon = new CuponPorcentual(85);

        assertEquals( cupon.aplicarDescuento(precio_final), 75, 0.1);
    }

    @Test
    public void test03SeAplicaUnSinCuponAUnPrecio() {
        double precio_final = 500;

        Cupon cupon = new CuponSinDescuento();
        cupon.establecerDescuento(50);

        assertEquals( cupon.aplicarDescuento(precio_final), precio_final );
    }
    @Test
    public void test04SeObtieneValorDescuentoDeUnSinCupon() {
        Cupon cupon = new CuponSinDescuento();

        assertEquals(0, cupon.obtenerDescuento() );
    }
}
import modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductoTest {
    @Test
    public void test01SeCreaUnProducto() {
        Producto producto = new ProductoIndividual("Choripan", 150.0, 2);

        assertEquals(producto.obtenerNombre(), "Choripan");
        assertEquals(producto.obtenerCantidad(), 2);
        assertEquals(producto.obtenerPrecio(), 150.0);
    }

    @Test
    public void test02SeObtieneUnCuponDeUnProductoIndividual() {
        Producto producto = new ProductoIndividual("Hamburguesa", 300.0, 2);
        Cupon cupon = new CuponFijo(30);

        cupon = producto.obtenerCupon(cupon);

        assertEquals(cupon.aplicarDescuento( producto.obtenerPrecio() * producto.obtenerCantidad() ), 570);
    }

    @Test
    public void test03SeObtieneUnCuponDeUnProductoMenu() {
        Producto producto = new ProductoMenu("Entrada + Fritas", 650.0, 1);
        Cupon cupon = new CuponFijo(500);

        cupon = producto.obtenerCupon(cupon);

        assertEquals(cupon.aplicarDescuento( producto.obtenerPrecio() * producto.obtenerCantidad() ), 650.0);
    }

}
package modelo;

import java.util.ArrayList;

abstract class Pedido {
    public ArrayList<Producto> lista_pedidos = new ArrayList<Producto>();

    public abstract void establecerCuponPorcentaje(int valor);
    public abstract void establecerCuponDescuento(int valor);

    public int obtenerSumaTotalDeLosProductos() {
        int suma_total = 0;

        for( Producto producto : lista_pedidos )
            suma_total += (producto.obtenerCantidad() * producto.obtenerPrecio());

        return suma_total;
    }

    public void actualizarCantidadDeProducto(String nombreProducto, int nuevaCantidad) {
        boolean existeProducto = this.lista_pedidos.stream().anyMatch(producto -> producto.obtenerNombre().equals(nombreProducto));

        if( !existeProducto )
            throw new ProductoNoExisteException();

        for( Producto producto : lista_pedidos )
            if(producto.obtenerNombre().equals(nombreProducto))
                producto.establecerCantidad(nuevaCantidad);
    }

    public void agregarProductoAPedido(Producto producto) {
        this.lista_pedidos.add(producto);
    }

    public int obtenerCantidadDeProductos() {
        int suma_final = 0;

        for( Producto producto : lista_pedidos )
            suma_final += producto.obtenerCantidad();

        return suma_final;
    }

    public abstract double obtenerPrecioDelPedido();

    public abstract void quitarCuponDescuento();

    public void eliminarProductoDelPedido(String nombre) {
        boolean existeProducto = this.lista_pedidos.stream().anyMatch(producto -> producto.obtenerNombre().equals(nombre));

        if( !existeProducto )
            throw new ProductoNoExisteException();

        int index = 0;
        for( Producto producto : lista_pedidos )
            if(producto.obtenerNombre().equals(nombre))
                break;
            else
                index++;

        this.lista_pedidos.remove(index);
    }
}

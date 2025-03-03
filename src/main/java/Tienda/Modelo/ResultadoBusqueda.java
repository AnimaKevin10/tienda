package Tienda.Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultadoBusqueda {
    private List<Producto> resultados;

    public ResultadoBusqueda(List<Producto> resultados) {
        this.resultados = resultados;
    }

    public List<Producto> getResultados() {
        return new ArrayList<>(resultados); // Devuelve una copia para evitar modificaciones externas
    }

    public ResultadoBusqueda filtrarPorCategoria(String categoria) {
        List<Producto> filtrados = resultados.stream()
                //.filter(producto -> producto.getCategoria().equalsIgnoreCase(categoria))
                .collect(Collectors.toList());
        return new ResultadoBusqueda(filtrados);
    }

    public ResultadoBusqueda filtrarPorPrecio(double precioMinimo, double precioMaximo) {
        List<Producto> filtrados = resultados.stream()
                .filter(producto -> producto.getPrecio() >= precioMinimo && producto.getPrecio() <= precioMaximo)
                .collect(Collectors.toList());
        return new ResultadoBusqueda(filtrados);
    }
}

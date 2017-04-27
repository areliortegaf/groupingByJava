/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioscurso6;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 *
 * @author asortega
 */
public class EjemploOrdenarDatos {
    //
    //GroupingBy
    //

    //Muestra cuantas personas por ciudad hay
    List<ventas> datos = Arrays.asList(
            new ventas("Luis", "Chihuahua", 200.56),
            new ventas("Maria", "Chihuahua", 200.56),
            new ventas("Luis", "Juarez", 200.56),
            new ventas("Juan", "Aldama", 200.56),
            new ventas("Ana", "Delicias", 200.56)
    );

    public EjemploOrdenarDatos() {
        agruparDatosPorCiudad();
        agruparDatosPorNombre();
        agruparDatosPorVentas();
    }

    public void agruparDatosPorCiudad() {
        Map<String, Long> agruparPorCiudad;

        agruparPorCiudad = datos.stream()
                .collect(groupingBy(ventas::obtenerCiudad, counting()));
        System.out.println(agruparPorCiudad);

    }

    public void agruparDatosPorNombre() {
        Map<String, Long> agruparPorNombre;

        agruparPorNombre = datos.stream()
                .collect(groupingBy(ventas::obtenerEmpleado, counting()));
        System.out.println(agruparPorNombre);

    }

    public void agruparDatosPorVentas() {
        Map<Double, Long> agruparPorVentas;

        agruparPorVentas = datos.stream()
                .collect(groupingBy(ventas::obtenerVentas, counting()));
        System.out.println(agruparPorVentas);

    }

    public static void main(String... args) {
        new EjemploOrdenarDatos();
    }

}

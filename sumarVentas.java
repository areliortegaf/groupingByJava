/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioscurso6;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author asortega
 */
public class sumarVentas {

    List<ventas> datos = Arrays.asList(
            new ventas("Luis", "Chihuahua", 200.56),
            new ventas("Maria", "Chihuahua", 200.56),
            new ventas("Luis", "Juarez", 200.56),
            new ventas("Juan", "Aldama", 200.56),
            new ventas("Ana", "Delicias", 200.56)
    );

    public void sumatoriaPorVendedor() {
        System.out.println("---------SUMATORIA POR VENDEDOR-----------");
        datos.stream()
                .collect(Collectors.groupingBy(t -> t.empleado,
                        Collectors.summingDouble(t -> t.ventas)))
                .forEach((emp, sumaTotal) -> System.out.println(emp + "\t" + sumaTotal));
    }
    
    public void sumatoriaPorCiudad(){
        System.out.println("---------SUMATORIA POR CIUDAD-----------");
        datos.stream()
                .collect(Collectors.groupingBy(t -> t.ciudad,
                        Collectors.summingDouble(t -> t.ventas)))
                .forEach((emp, sumaTotal) -> System.out.println(emp + "\t" + sumaTotal));
    }
    public void sumatoriaTotal(){
        System.out.println("---------SUMATORIA TOTAL-----------");
        
        double total =
        datos.stream()
                .collect(Collectors.summingDouble(t -> t.ventas));
        System.out.println(total);
    }
    
    
    public sumarVentas(){
        sumatoriaPorVendedor();
        sumatoriaPorCiudad();
        sumatoriaTotal();
    }
    
    public static void main(String... args){
        new sumarVentas();
    }

}

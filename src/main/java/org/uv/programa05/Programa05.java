/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package org.uv.programa05;

import java.util.List;

/**
 *
 * @author minio
 */
public class Programa05 {

    public static void main(String[] args) { 
        
        DAOEmpleado dao=new DAOEmpleado();
        Empleado empleado= new Empleado();
        
        empleado.setClave(10);
        empleado.setNombre("Carlos");
        empleado.setDireccion("Avenida 12");
        empleado.setTelefono("2722303746");
        dao.create(empleado);
        
        
        
        
        System.out.println("Hello World!");
    }
}

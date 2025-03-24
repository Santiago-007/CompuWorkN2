package com.mycompany.compuworkn2;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private int id;
    private String ciudad;
    private String direccion;
    private String nombre;
    private List<Empleado> empleados;
    
    // Constructor
    public Departamento(int id, String nombre, String ciudad, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.empleados = new ArrayList<>();
    }
    
    // Getters y Setters
    public int getId() {
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public List<Empleado> getEmpleados() {
        return empleados;
    }
    
    // Métodos de la clase Departamento
    public static Departamento crearDepartamento(int id, String nombre, String ciudad, String direccion) {
        return new Departamento(id, nombre, ciudad, direccion);
    }
    
    public void eliminarDepartamento() {
        // Desasignar a todos los empleados de este departamento
        for (Empleado empleado : new ArrayList<>(empleados)) {
            empleado.setDepartamento(null);
        }
        empleados.clear();
    }
    
    public void modificarDepartamento(String nombre, String ciudad, String direccion) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }
    
    public void asignarEmpleado(Empleado empleado) {
        if (empleado.getDepartamento() != null) {
            empleado.getDepartamento().getEmpleados().remove(empleado);
        }
        empleado.setDepartamento(this);
        if (!empleados.contains(empleado)) {
            empleados.add(empleado);
        }
    }
    
    public List<Empleado> visualizarEmpleados() {
        return new ArrayList<>(empleados);
    }
    
    @Override
    public String toString() {
        return "Departamento{" + "id=" + id + ", nombre=" + nombre + ", ciudad=" + ciudad + 
               ", direccion=" + direccion + ", número de empleados=" + empleados.size() + '}';
    }
}

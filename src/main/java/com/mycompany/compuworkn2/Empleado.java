package com.mycompany.compuworkn2;

/**
 *
 * @author USUARIO
 */

// Clase base Empleado
public class Empleado {
   private int ID;
   private String nombre;
   private String apellido;
   private String fechaNacimiento;
   private String correoElectronico;
   private String tipoEmpleado;
   private int salario;
   private String cargo;
   private Departamento departamento;
    
    // Constructor
    public Empleado(int ID, String nombre, String apellido, String fechaNacimiento, String correoElectronico, String tipoEmpleado, int salario, String cargo, String tiempoContrato) {
        this.ID = ID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
        this.tipoEmpleado = tipoEmpleado;
        this.salario = salario;
        this.cargo = cargo;
        this.departamento = null; // Inicialmente no tiene departamento asignado

    }
    
    // Getters y Setters

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    
    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    // Métodos de la clase Empleado
    public static Empleado crearEmpleado(int ID, String nombre, String apellido, String fechaNacimiento, 
                                      String correoElectronico, String tipoEmpleado, int salario, String cargo, String tiempoContrato) {
        return new Empleado(ID, nombre, apellido, fechaNacimiento, correoElectronico, tipoEmpleado, salario, cargo, tiempoContrato);
    }
    
    public void actualizarEmpleado(String nombre, String apellido, String fechaNacimiento, 
                                  String correoElectronico, String tipoEmpleado, int salario, String cargo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
        this.tipoEmpleado = tipoEmpleado;
        this.salario = salario;
        this.cargo = cargo;
    }
    
    public void asignarDepartamento(Departamento departamento) {
        if (this.departamento != null) {
            this.departamento.getEmpleados().remove(this);
        }
        this.departamento = departamento;
        if (departamento != null) {
            departamento.getEmpleados().add(this);
        }
    }
    
    public void cambiarDepartamento(Departamento departamento) {
        asignarDepartamento(departamento);
    }
    
    @Override
    public String toString() {
        return "Empleado{" + "ID=" + ID + ", nombre=" + nombre + ", apellido=" + apellido + 
               ", cargo=" + cargo + ", departamento=" + (departamento != null ? departamento.getNombre() : "Sin asignar") + '}';
    }
}

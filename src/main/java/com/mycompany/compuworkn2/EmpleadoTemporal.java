package com.mycompany.compuworkn2;

/**
 *
 * @author USUARIO
 */
public class EmpleadoTemporal extends Empleado {
    private String tiempoContrato;
    
    public EmpleadoTemporal(int ID, String nombre, String apellido, String fechaNacimiento, 
                           String correoElectronico, int salario, String cargo, String tiempoContrato) {
        super(ID, nombre, apellido, fechaNacimiento, correoElectronico, "Temporal", salario, cargo, tiempoContrato);
        this.tiempoContrato = tiempoContrato;
    }
    
    public String getTiempoContrato() {
        return tiempoContrato;
    }
    
    public void setTiempoContrato(String tiempoContrato) {
        this.tiempoContrato = tiempoContrato;
    }
    
    public String toString() {
    return "EmpleadoTemporal{" + "ID=" + getID() + ", nombre=" + getNombre() + ", apellido=" + getApellido() +
           ", cargo=" + getCargo() + ", tiempoContrato=" + getTiempoContrato() +
           ", departamento=" + (getDepartamento() != null ? getDepartamento().getNombre() : "Sin asignar") + '}';
    }
}
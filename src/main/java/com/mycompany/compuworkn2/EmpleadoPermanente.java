package com.mycompany.compuworkn2;


/**
 *
 * @author USUARIO
 */
public class EmpleadoPermanente extends Empleado {
    private String beneficios;
    
    public EmpleadoPermanente(int ID, String nombre, String apellido, String fechaNacimiento,
                         String correoElectronico, int salario, String cargo, String beneficios) {
    super(ID, nombre, apellido, fechaNacimiento, correoElectronico, "Permanente", salario, cargo, beneficios);
    this.beneficios = beneficios;
}
    public String getBeneficios() {
    return beneficios;
    }
    
    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }
    
   @Override
    public String toString() {
    return "EmpleadoPermanente{" + "ID=" + getID() + ", nombre=" + getNombre() + ", apellido=" + getApellido() +
           ", cargo=" + getCargo() + ", beneficios=" + getBeneficios() +
           ", departamento=" + (getDepartamento() != null ? getDepartamento().getNombre() : "Sin asignar") + '}';
        }
}


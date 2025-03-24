package com.mycompany.compuworkn2;

/**
 *
 * @author USUARIO
 */
import java.util.Date;

public class ReporteDesempeno {
    private String tipoReporte;
    private Date fechaGeneracion;
    private int codigoReporte;
    
    // Constructor
    public ReporteDesempeno(String tipoReporte, int codigoReporte) {
        this.tipoReporte = tipoReporte;
        this.fechaGeneracion = new Date(); // Fecha actual
        this.codigoReporte = codigoReporte;
    }
    
    // Getters y Setters
    public String getTipoReporte() {
        return tipoReporte;
    }

    public void setTipoReporte(String tipoReporte) {
        this.tipoReporte = tipoReporte;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public int getCodigoReporte() {
        return codigoReporte;
    }
    
    // Métodos de la clase ReporteDesempeño
    public ReporteDesempeno generarReporteEmpleado(Empleado empleado) {
        System.out.println("Generando reporte para el empleado: " + empleado.getNombre() + " " + empleado.getApellido());
        System.out.println("ID: " + empleado.getID());
        System.out.println("Cargo: " + empleado.getCargo());
        System.out.println("Tipo de Empleado: " + empleado.getTipoEmpleado());
        System.out.println("Departamento: " + (empleado.getDepartamento() != null ? empleado.getDepartamento(): "Sin asignar"));
        System.out.println("Fecha del reporte: " + fechaGeneracion);
        
        return this;
    }
    
    public ReporteDesempeno generarReporteDepartamento(Departamento departamento) {
        System.out.println("Generando reporte para el departamento: " + departamento.getNombre());
        System.out.println("ID: " + departamento.getId());
        System.out.println("Ciudad: " + departamento.getCiudad());
        System.out.println("Dirección: " + departamento.getDireccion());
        System.out.println("Número de empleados: " + departamento.getEmpleados().size());
        System.out.println("Fecha del reporte: " + fechaGeneracion);
        
        System.out.println("\nListado de empleados:");
        for (Empleado emp : departamento.getEmpleados()) {
            System.out.println("- " + emp.getNombre() + " " + emp.getApellido() + " (" + emp.getCargo() + ")");
        }
        
        return this;
    }
    
    @Override
    public String toString() {
        return "ReporteDesempeño{" + "tipoReporte=" + tipoReporte + ", fechaGeneracion=" + fechaGeneracion + 
               ", codigoReporte=" + codigoReporte + '}';
    }
}

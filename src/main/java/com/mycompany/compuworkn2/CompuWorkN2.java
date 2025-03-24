package com.mycompany.compuworkn2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class CompuWorkN2 {
    private static List<Empleado> listaEmpleados = new ArrayList<>();
    private static List<Departamento> listaDepartamentos = new ArrayList<>();
    private static int nextEmpleadoId = 1;
    private static int nextDepartamentoId = 1;
    private static int nextReporteId = 1;
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        boolean salir = false;
        
        // Crear algunos datos de ejemplo
        
        while (!salir) {
            System.out.println("\n===== SISTEMA DE GESTION DE RECURSOS HUMANOS COMPUWORK =====");
            System.out.println("1. Gestion de Empleados");
            System.out.println("2. Gestion de Departamentos");
            System.out.println("3. Generaciin de Reportes");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            
            switch (opcion) {
                case 1:
                    menuEmpleados();
                    break;
                case 2:
                    menuDepartamentos();
                    break;
                case 3:
                    menuReportes();
                    break;
                case 4:
                    salir = true;
                    System.out.println("¡Gracias por usar el sistema!");
                    break;
                default:
                    System.out.println("Opcion no válida. Intente de nuevo.");
            }
        }
        
        scanner.close();
    }
    
    private static void menuEmpleados() {
        boolean volver = false;
        
        while (!volver) {
            System.out.println("\n----- GESTION DE EMPLEADOS -----");
            System.out.println("1. Crear nuevo empleado");
            System.out.println("2. Actualizar empleado");
            System.out.println("3. Eliminar empleado");
            System.out.println("4. Mostrar todos los empleados");
            System.out.println("5. Asignar empleado a departamento");
            System.out.println("6. Cambiar departamento de un empleado");
            System.out.println("7. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            
            switch (opcion) {
                case 1:
                    crearEmpleado();
                    break;
                case 2:
                    actualizarEmpleado();
                    break;
                case 3:
                    eliminarEmpleado();
                    break;
                case 4:
                    mostrarEmpleados();
                    break;
                case 5:
                case 6:
                    asignarEmpleadoADepartamento();
                    break;
                case 7:
                    volver = true;
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        }
    }
    
    private static void crearEmpleado() {
        System.out.println("\n--- CREAR NUEVO EMPLEADO ---");
        System.out.println("Tipo de empleado: ");
        System.out.println("1. Permanente");
        System.out.println("2. Temporal");
        System.out.print("Seleccione una opcion: ");
        int tipoOpcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        
        System.out.print("Fecha de nacimiento (DD/MM/AAAA): ");
        String fechaNacimiento = scanner.nextLine();
        
        System.out.print("Correo electronico: ");
        String correoElectronico = scanner.nextLine();
        
        System.out.print("Salario: ");
        int salario = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();
        
        Empleado nuevoEmpleado;
        
        if (tipoOpcion == 1) {
            System.out.print("Beneficios: ");
            String beneficios = scanner.nextLine();
            nuevoEmpleado = new EmpleadoPermanente(nextEmpleadoId++, nombre, apellido, fechaNacimiento, 
                                               correoElectronico, salario, cargo, beneficios);
        } else {
            System.out.print("Tiempo de contrato: ");
            String tiempoContrato = scanner.nextLine();
            nuevoEmpleado = new EmpleadoTemporal(nextEmpleadoId++, nombre, apellido, fechaNacimiento, 
                                            correoElectronico, salario, cargo, tiempoContrato);
        }
        
        listaEmpleados.add(nuevoEmpleado);
        System.out.println("Empleado creado con exito. ID asignado: " + nuevoEmpleado.getID());
    }
    
    private static void actualizarEmpleado() {
        System.out.println("\n--- ACTUALIZAR EMPLEADO ---");
        mostrarEmpleados();
        System.out.print("Ingrese el ID del empleado a actualizar: ");
        int idEmpleado = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        
        Empleado empleado = buscarEmpleadoPorId(idEmpleado);
        
        if (empleado != null) {
            System.out.print("Nuevo nombre (actual: " + empleado.getNombre() + "): ");
            String nombre = scanner.nextLine();
            if (!nombre.isEmpty()) {
                empleado.setNombre(nombre);
            }
            
            System.out.print("Nuevo apellido (actual: " + empleado.getApellido() + "): ");
            String apellido = scanner.nextLine();
            if (!apellido.isEmpty()) {
                empleado.setApellido(apellido);
            }
            
            System.out.print("Nueva fecha de nacimiento (actual: " + empleado.getFechaNacimiento() + "): ");
            String fechaNacimiento = scanner.nextLine();
            if (!fechaNacimiento.isEmpty()) {
                empleado.setFechaNacimiento(fechaNacimiento);
            }
            
            System.out.print("Nuevo correo electronico (actual: " + empleado.getCorreoElectronico() + "): ");
            String correoElectronico = scanner.nextLine();
            if (!correoElectronico.isEmpty()) {
                empleado.setCorreoElectronico(correoElectronico);
            }
            
            System.out.print("Nuevo salario (actual: " + empleado.getSalario() + "): ");
            String salarioStr = scanner.nextLine();
            if (!salarioStr.isEmpty()) {
                empleado.setSalario(Integer.parseInt(salarioStr));
            }
            
            System.out.print("Nuevo cargo (actual: " + empleado.getCargo() + "): ");
            String cargo = scanner.nextLine();
            if (!cargo.isEmpty()) {
                empleado.setCargo(cargo);
            }
            
            if (empleado instanceof EmpleadoPermanente) {
                EmpleadoPermanente emp = (EmpleadoPermanente) empleado;
                System.out.print("Nuevos beneficios (actual: " + emp.getBeneficios() + "): ");
                String beneficios = scanner.nextLine();
                if (!beneficios.isEmpty()) {
                    emp.setBeneficios(beneficios);
                }
            } else if (empleado instanceof EmpleadoTemporal) {
                EmpleadoTemporal emp = (EmpleadoTemporal) empleado;
                System.out.print("Nuevo tiempo de contrato (actual: " + emp.getTiempoContrato() + "): ");
                String tiempoContrato = scanner.nextLine();
                if (!tiempoContrato.isEmpty()) {
                    emp.setTiempoContrato(tiempoContrato);
                }
            }
            
            System.out.println("Empleado actualizado con exito.");
        } else {
            System.out.println("No se encontro ningún empleado con ese ID.");
        }
    }
    
    private static void eliminarEmpleado() {
        System.out.println("\n--- ELIMINAR EMPLEADO ---");
        mostrarEmpleados();
        System.out.print("Ingrese el ID del empleado a eliminar: ");
        int idEmpleado = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        
        Empleado empleado = buscarEmpleadoPorId(idEmpleado);
        
        if (empleado != null) {
            // Desasignar del departamento si tiene uno
            if (empleado.getDepartamento() != null) {
                empleado.getDepartamento().getEmpleados().remove(empleado);
            }
            
            listaEmpleados.remove(empleado);
            System.out.println("Empleado eliminado con exito.");
        } else {
            System.out.println("No se encontro ningún empleado con ese ID.");
        }
    }
    
    private static void mostrarEmpleados() {
        System.out.println("\n--- LISTA DE EMPLEADOS ---");
        if (listaEmpleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (Empleado emp : listaEmpleados) {
                System.out.println(emp);
            }
        }
    }
    
    private static void asignarEmpleadoADepartamento() {
        System.out.println("\n--- ASIGNAR EMPLEADO A DEPARTAMENTO ---");
        mostrarEmpleados();
        System.out.print("Ingrese el ID del empleado: ");
        int idEmpleado = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        
        Empleado empleado = buscarEmpleadoPorId(idEmpleado);
        
        if (empleado != null) {
            mostrarDepartamentos();
            System.out.print("Ingrese el ID del departamento: ");
            int idDepartamento = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            
            Departamento departamento = buscarDepartamentoPorId(idDepartamento);
            
            if (departamento != null) {
                departamento.asignarEmpleado(empleado);
                System.out.println("Empleado asignado al departamento con exito.");
            } else {
                System.out.println("No se encontró ningún departamento con ese ID.");
            }
        } else {
            System.out.println("No se encontro ningún empleado con ese ID.");
        }
    }
    
    private static void menuDepartamentos() {
        boolean volver = false;
        
        while (!volver) {
            System.out.println("\n----- GESTIoN DE DEPARTAMENTOS -----");
            System.out.println("1. Crear nuevo departamento");
            System.out.println("2. Modificar departamento");
            System.out.println("3. Eliminar departamento");
            System.out.println("4. Mostrar todos los departamentos");
            System.out.println("5. Visualizar empleados de un departamento");
            System.out.println("6. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            
            switch (opcion) {
                case 1:
                    crearDepartamento();
                    break;
                case 2:
                    modificarDepartamento();
                    break;
                case 3:
                    eliminarDepartamento();
                    break;
                case 4:
                    mostrarDepartamentos();
                    break;
                case 5:
                    visualizarEmpleadosDepartamento();
                    break;
                case 6:
                    volver = true;
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        }
    }
    
    private static void crearDepartamento() {
        System.out.println("\n--- CREAR NUEVO DEPARTAMENTO ---");
        System.out.print("Nombre del departamento: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Ciudad: ");
        String ciudad = scanner.nextLine();
        
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();
        
        Departamento nuevoDepartamento = Departamento.crearDepartamento(nextDepartamentoId++, nombre, ciudad, direccion);
        listaDepartamentos.add(nuevoDepartamento);
        
        System.out.println("Departamento creado con exito. ID asignado: " + nuevoDepartamento.getId());
    }
    
    private static void modificarDepartamento() {
        System.out.println("\n--- MODIFICAR DEPARTAMENTO ---");
        mostrarDepartamentos();
        System.out.print("Ingrese el ID del departamento a modificar: ");
        int idDepartamento = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        
        Departamento departamento = buscarDepartamentoPorId(idDepartamento);
        
        if (departamento != null) {
            System.out.print("Nuevo nombre (actual: " + departamento.getNombre() + "): ");
            String nombre = scanner.nextLine();
            if (!nombre.isEmpty()) {
                departamento.setNombre(nombre);
            }
            
            System.out.print("Nueva ciudad (actual: " + departamento.getCiudad() + "): ");
            String ciudad = scanner.nextLine();
            if (!ciudad.isEmpty()) {
                departamento.setCiudad(ciudad);
            }
            
            System.out.print("Nueva direccion (actual: " + departamento.getDireccion() + "): ");
            String direccion = scanner.nextLine();
            if (!direccion.isEmpty()) {
                departamento.setDireccion(direccion);
            }
            
            System.out.println("Departamento modificado con exito.");
        } else {
            System.out.println("No se encontro ningún departamento con ese ID.");
        }
    }
    
    private static void eliminarDepartamento() {
        System.out.println("\n--- ELIMINAR DEPARTAMENTO ---");
        mostrarDepartamentos();
        System.out.print("Ingrese el ID del departamento a eliminar: ");
        int idDepartamento = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        
        Departamento departamento = buscarDepartamentoPorId(idDepartamento);
        
        if (departamento != null) {
            departamento.eliminarDepartamento();
            listaDepartamentos.remove(departamento);
            System.out.println("Departamento eliminado con exito.");
        } else {
            System.out.println("No se encontro ningún departamento con ese ID.");
        }
    }
    
    private static void mostrarDepartamentos() {
        System.out.println("\n--- LISTA DE DEPARTAMENTOS ---");
        if (listaDepartamentos.isEmpty()) {
            System.out.println("No hay departamentos registrados.");
        } else {
            for (Departamento dept : listaDepartamentos) {
                System.out.println(dept);
            }
        }
    }
    
 private static void visualizarEmpleadosDepartamento() {
        System.out.println("\n--- VISUALIZAR EMPLEADOS DE UN DEPARTAMENTO ---");
        mostrarDepartamentos();
        System.out.print("Ingrese el ID del departamento: ");
        int idDepartamento = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        
        Departamento departamento = buscarDepartamentoPorId(idDepartamento);
        
        if (departamento != null) {
            List<Empleado> empleadosDept = departamento.visualizarEmpleados();
            
            System.out.println("\nEmpleados del departamento " + departamento.getNombre() + ":");
            if (empleadosDept.isEmpty()) {
                System.out.println("No hay empleados asignados a este departamento.");
            } else {
                for (Empleado emp : empleadosDept) {
                    System.out.println(emp);
                }
            }
        } else {
            System.out.println("No se encontro ningun departamento con ese ID.");
        }
    }
    
    private static void menuReportes() {
        boolean volver = false;
        
        while (!volver) {
            System.out.println("\n----- GENERACION DE REPORTES -----");
            System.out.println("1. Generar reporte de empleado");
            System.out.println("2. Generar reporte de departamento");
            System.out.println("3. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            
            switch (opcion) {
                case 1:
                    generarReporteEmpleado();
                    break;
                case 2:
                    generarReporteDepartamento();
                    break;
                case 3:
                    volver = true;
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        }
    }
    
    private static void generarReporteEmpleado() {
        System.out.println("\n--- GENERAR REPORTE DE EMPLEADO ---");
        mostrarEmpleados();
        System.out.print("Ingrese el ID del empleado: ");
        int idEmpleado = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        
        Empleado empleado = buscarEmpleadoPorId(idEmpleado);
        
        if (empleado != null) {
            System.out.print("Tipo de reporte: ");
            String tipoReporte = scanner.nextLine();
            
            ReporteDesempeno reporte = new ReporteDesempeno(tipoReporte, nextReporteId++);
            reporte.generarReporteEmpleado(empleado);
            
            System.out.println("\nReporte generado con exito. Codigo: " + reporte.getCodigoReporte());
        } else {
            System.out.println("No se encontro ningún empleado con ese ID.");
        }
    }
    
    private static void generarReporteDepartamento() {
        System.out.println("\n--- GENERAR REPORTE DE DEPARTAMENTO ---");
        mostrarDepartamentos();
        System.out.print("Ingrese el ID del departamento: ");
        int idDepartamento = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        
        Departamento departamento = buscarDepartamentoPorId(idDepartamento);
        
        if (departamento != null) {
            System.out.print("Tipo de reporte: ");
            String tipoReporte = scanner.nextLine();
            
            ReporteDesempeno reporte = new ReporteDesempeno(tipoReporte, nextReporteId++);
            reporte.generarReporteDepartamento(departamento);
            
            System.out.println("\nReporte generado con exito. Código: " + reporte.getCodigoReporte());
        } else {
            System.out.println("No se encontro ningun departamento con ese ID.");
        }
    }
    
    private static Empleado buscarEmpleadoPorId(int id) {
        for (Empleado emp : listaEmpleados) {
            if (emp.getID() == id) {
                return emp;
            }
        }
        return null;
    }
    
    private static Departamento buscarDepartamentoPorId(int id) {
        for (Departamento dept : listaDepartamentos) {
            if (dept.getId() == id) {
                return dept;
            }
        }
        return null;
    }
}


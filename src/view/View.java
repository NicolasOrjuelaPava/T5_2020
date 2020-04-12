package view;

import java.util.Scanner;

import controller.Controller;
import model.logic.Modelo;;


public class View {

	//------------------------ATRIBUTOS-----------------------------------------------
	Controller controller;

	int seleccion;
	Scanner sc;
	
	
	//------------------------CONSTRUCTOR-----------------------------------------------
	public View(){
		
		controller = new Controller();
		
		System.out.println("Bienvenido al Taller 5 - Estructuras de Datos - Universidad de Los Andes");
		System.out.println("A continuación se mostrará información del archivo de datos Comparendos en Bogotá 2018:");
		//Carga el archivo y muestra información
		controller.cargar();
		System.out.println("");
		mostrarMenu();
		
	}
	
	
	//------------------------MÉTODOS-----------------------------------------------
	public void mostrarMenu(){
		System.out.println("Seleccione el requerimiento que desea ejecutar (escriba un número y presione la tecla Enter): ");
		System.out.println("1. Buscar tiempos de viaje por fecha, clase de vehículo e infracción (Tabla de Hash Linear Probing)");
		System.out.println("2. Buscar tiempos de viaje fecha, clase de vehículo e infracción (Tabla de HashSeparate Chaining)");
		System.out.println("3. Pruebas de desempeño.");

		
		
		sc = new Scanner(System.in);
		seleccion = Integer.parseInt(sc.nextLine());
		ejecutarSeleccion(seleccion);
	}
	
	
	
	public void ejecutarSeleccion(int e){
		
		switch (e){
			case 1:
				controller.req1();
				mostrarMenu();
			case 2:
				controller.req2();
				mostrarMenu();
			case 3:
				controller.req3();
				mostrarMenu();

				
		}
			
	}

	
	
}

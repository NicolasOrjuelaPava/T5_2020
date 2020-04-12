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
		System.out.println("A continuaci�n se mostrar� informaci�n del archivo de datos Comparendos en Bogot� 2018:");
		//Carga el archivo y muestra informaci�n
		controller.cargar();
		System.out.println("");
		mostrarMenu();
		
	}
	
	
	//------------------------M�TODOS-----------------------------------------------
	public void mostrarMenu(){
		System.out.println("Seleccione el requerimiento que desea ejecutar (escriba un n�mero y presione la tecla Enter): ");
		System.out.println("1. Buscar tiempos de viaje por fecha, clase de veh�culo e infracci�n (Tabla de Hash Linear Probing)");
		System.out.println("2. Buscar tiempos de viaje fecha, clase de veh�culo e infracci�n (Tabla de HashSeparate Chaining)");
		System.out.println("3. Pruebas de desempe�o.");

		
		
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

package controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.LineNumberInputStream;

import com.google.gson.Gson;

import model.data_structures.Comparendo;
import model.logic.Modelo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Scanner;

import com.google.gson.Gson;


public class Controller {
	
	//------------------------ATRIBUTOS-----------------------------------------------
	Scanner sc;
	Modelo modelo;
	
	
	//------------------------CONSTRUCTOR-----------------------------------------------
	public Controller(){
		sc = new Scanner(System.in);
		modelo = new Modelo();
		
	}
	
	
	
	//------------------------MÉTODOS-----------------------------------------------
	public void cargar(){
		modelo.cargar();
	}
	
	

	public  void req1(){
		System.out.println("Ingrese la fecha:");
		String fecha = sc.next();
		
		System.out.println("Ingrese la clase de vehiculo:");
		String clase = sc.next();
		
		System.out.println("Ingrese la infraccion:");
		String infraccion = sc.next();
		
		modelo.req1(fecha, clase, infraccion);
		
	}
	
	
	public  void req2(){
		System.out.println("Ingrese la fecha:");
		String fecha = sc.next();
		
		System.out.println("Ingrese la clase de vehiculo:");
		String clase = sc.next();
		
		System.out.println("Ingrese la infraccion:");
		String infraccion = sc.next();
		
		modelo.req2(fecha, clase, infraccion);
		
	}
	
	public void req3(){
		modelo.req3();
	}
	
	

	
}

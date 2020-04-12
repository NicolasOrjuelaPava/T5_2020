package model.logic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.google.gson.Gson;

import controller.Controller;
import model.data_structures.Comparendo;
import model.data_structures.HashLinearProbing;
import model.data_structures.HashSeparateChaining;
import model.data_structures.LinkedList;
import model.data_structures.keyComparendo;
import model.data_structures.Comparendo;



public class Modelo {


	//------------------------CONSTRUCTOR-----------------------------------------------
	public Modelo(){
		tiempoCarga=0;
		tiempoInicio=0;
		tiempoFin=0;
		n=0;
		
	}
	
	

	//------------------------ATRIBUTOS-----------------------------------------------	
		private static Modelo modelo;
		Controller controller;
		
		private static final String ARCHIVO_PEQUENO = "./data/Comparendos_DEI_2018_Bogotá_D.C_small.geojson";
		private static final String ARCHIVO_MEDIANO = "./data/Comparendos_DEI_2018_Bogotá_D.C_50000_.geojson";
		private static final String ARCHIVO_GRANDE = "./data/Comparendos_DEI_2018_Bogotá_D.C.geojson";
		public static double tiempoCarga;
		public static double tiempoInicio;
		public static double tiempoFin;
		Scanner sc;
		//CREAR ATRIBUTO DE LA ESTRUCTURA
		public static HashSeparateChaining hashSC;
		public static HashLinearProbing hashLP;
		static int n;


		//------------------------CLASES INTERNAS-----------------------------------------------
		//modelamiento del JSon
		static class Json{
			String type;
			Features[] features;
		}
		
		static class Features{
			String type;
			Properties properties;
			Geometry geometry;
		}

		static class Properties{
			int OBJECTID;
			String FECHA_HORA;
			String MEDIO_DETECCION;
			String CLASE_VEHICULO;
			String TIPO_SERVICIO;
			String INFRACCION;
			String DES_INFRACCION;
			String LOCALIDAD;
			String MUNICIPIO;
		}
		
		static class Geometry{
			String type;
			double[] coordinates;
		}
		
		
		
		//------------------------MÉTODOS-----------------------------------------------
		
		//Metodo que carga los datos en la estructura
		@SuppressWarnings("unchecked")
		public static void cargar(){
			
	
			String fecha = "";
			String infraccion ="";
			String clase_vehiculo = "";
			String tipo_servicio ="";
			String localidad ="";
			
			//INICIALIZAR LA ESTRUCTURA
			hashSC = new HashSeparateChaining(10);
			hashLP = new HashLinearProbing(10);

			try {
				FileInputStream inputStream;
				inputStream = new FileInputStream(ARCHIVO_GRANDE);
				InputStreamReader inputStreamreader = new InputStreamReader(inputStream);
				BufferedReader bufferedReader = new BufferedReader(inputStreamreader);

				Json coleccionComparendos =  new Gson().fromJson(bufferedReader, Json.class);

				tiempoInicio = System.currentTimeMillis();
				
				
				for (int i=0; i<coleccionComparendos.features.length;i++){
					
					n=i;
					//CARGAR EN LA ESTRUCTURA Separate chaining
					Comparendo comp = new Comparendo(
							coleccionComparendos.features[i].properties.OBJECTID, 
		        			coleccionComparendos.features[i].properties.FECHA_HORA, 
		        			coleccionComparendos.features[i].properties.MEDIO_DETECCION,
		        			coleccionComparendos.features[i].properties.CLASE_VEHICULO,
		        			coleccionComparendos.features[i].properties.TIPO_SERVICIO, 
		        			coleccionComparendos.features[i].properties.INFRACCION, 
		        			coleccionComparendos.features[i].properties.DES_INFRACCION, 
		        			coleccionComparendos.features[i].properties.LOCALIDAD, 
		        			coleccionComparendos.features[i].properties.MUNICIPIO, 
		        			coleccionComparendos.features[i].geometry.coordinates[0], 
		        			coleccionComparendos.features[i].geometry.coordinates[1]) ;
					hashSC.put(comp.getKey(), comp);
					
					
					//carga en linear probing
					Comparendo compa = new Comparendo(
							coleccionComparendos.features[i].properties.OBJECTID, 
		        			coleccionComparendos.features[i].properties.FECHA_HORA, 
		        			coleccionComparendos.features[i].properties.MEDIO_DETECCION,
		        			coleccionComparendos.features[i].properties.CLASE_VEHICULO,
		        			coleccionComparendos.features[i].properties.TIPO_SERVICIO, 
		        			coleccionComparendos.features[i].properties.INFRACCION, 
		        			coleccionComparendos.features[i].properties.DES_INFRACCION, 
		        			coleccionComparendos.features[i].properties.LOCALIDAD, 
		        			coleccionComparendos.features[i].properties.MUNICIPIO, 
		        			coleccionComparendos.features[i].geometry.coordinates[0], 
		        			coleccionComparendos.features[i].geometry.coordinates[1]) ;
					hashLP.put(compa.getKey(), comp);
					
					
				}
				

				//ACA VA EL REQUERIMIENTO DE LA CARGA
				//PRIMER COMPARENDO
				System.out.println("Primer Comparendo:");
				System.out.println(coleccionComparendos.features[0].properties.OBJECTID + " "+ 
						coleccionComparendos.features[0].properties.FECHA_HORA + " " +
						coleccionComparendos.features[0].properties.INFRACCION + " " +
	        			coleccionComparendos.features[0].properties.LOCALIDAD);
						
			
				//ULTIMO COMPARENDO
				System.out.println("Ultimo Comparendo:");
				System.out.println(coleccionComparendos.features[n].properties.OBJECTID + " "+ 
						coleccionComparendos.features[n].properties.FECHA_HORA + " " +
						coleccionComparendos.features[n].properties.INFRACCION + " " +
	        			coleccionComparendos.features[n].properties.LOCALIDAD);
				
				tiempoFin = System.currentTimeMillis();
				tiempoCarga = (tiempoFin-tiempoInicio)/1000;
				
			
			}catch (Exception e){
				//System.out.println("No se encontró el archivo de datos");
				e.getStackTrace();
			}
			
			
			//info adicional
			System.out.println("El numero de parejas es: " + hashSC.darNumeroParejas());
			System.out.println( "El tamano es: " + hashSC.darTamanio());
			System.out.println("La cantidad de rehashes es:" + hashSC.darCantidadReHash());
			
			System.out.println("");
			
		

		}
	
	
	
	//------------------------REQUERIMIENTOS-----------------------------------------------
	
	
	
	
	public  void req1(String fecha, String clase, String infraccion){
		
		Iterator<keyComparendo> it = hashSC.getSet(new keyComparendo(fecha, clase, infraccion));
		
		try{
		while(it.hasNext()){
			
			System.out.println(hashSC.get(it.next().toString()));
		}
		}catch (Exception e){
			System.out.println("No hay comparendos con esos valores");
		}
		
	}
	
	
	public  void req2(String fecha, String clase, String infraccion){
		
		Iterator<keyComparendo> it = hashLP.getSet(new keyComparendo(fecha, clase, infraccion));
		
		try{
		while(it.hasNext()){
			
			System.out.println(hashLP.get(it.next().toString()));
		}
		}catch (Exception e){
			System.out.println("No hay comparendos con esos valores");
		}
		

	}
	
	public void req3(){

		
		Iterator<keyComparendo> it =  hashSC.keys();
		int n = 0;
		while(it.hasNext() && n <= 10000)
		{
	
			int rand_one = (int) (Math.random()* 8000);
			int rand_two = (int) (Math.random()* 2000);
			
			for(int i = 0; i <= rand_one; i++){
				hashSC.get(new keyComparendo("","",""));
			}
			
			for(int i = 0; i <= rand_two; i++){
				hashSC.get(new keyComparendo("","",""));
			}
			
			n++;
		}
		
	}
	
	
	
}
	

	
	
	
	
	
	
	
	

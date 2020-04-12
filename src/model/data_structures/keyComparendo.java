package model.data_structures;


public class keyComparendo implements Comparable<keyComparendo>{

		//Atributo
		private String fecha;
		private String clase;
		private String infraccion;
		
		//Constructor
		public keyComparendo(String pfecha, String pclase, String pinfraccion){
			fecha = pfecha;
			clase = pclase;
			infraccion = pinfraccion;
		}

		
		public String getFecha(){
			return fecha;
		}
		
		public int compareTo(keyComparendo arg0) {
	
	
			int resp = 0;
			
			if (fecha.compareTo(arg0.getFecha())>1){
				resp = 1;
			}else if (fecha.compareTo(arg0.getFecha())<1){
				resp=-1;
			}
			return resp;
		}
	
		
	}

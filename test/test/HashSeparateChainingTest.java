package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.data_structures.HashLinearProbing;
import model.data_structures.HashSeparateChaining;

public class HashSeparateChainingTest {

	HashSeparateChaining<String,String> prueba;


	public void setUp1()
	{
		prueba = new HashSeparateChaining<String,String>(10);
	}

	
	

	@Test
	public void testPut()
	{
		setUp1();
		prueba.put("dato1", "dato1");
		prueba.put("dato2", "dato2");
		prueba.put("dato3", "dato3");
		
		assertEquals(prueba.darTamanio(), 3);

	}
	
	@Test
	public void testGet()
	{
		setUp1();
		prueba.put("dato1", "dato1");
		prueba.put("dato2", "dato2");
		prueba.put("dato3", "dato3");
		
		assertEquals(prueba.get("dato1"), "dato1");
		assertEquals(prueba.get("dato2"), "dato2");
		assertEquals(prueba.get("dato3"), "dato3");

	}
	
	@Test
	public void testDelete()
	{
		setUp1();
		prueba.put("dato1", "dato1");
		prueba.delete("dato1");
		
		assertEquals(prueba.darTamanio(), 0);
	}
	

	
}

package test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.HashLinearProbing;


public class HashLinearProbingTest {

	HashLinearProbing<String,String> prueba;


	public void setUp1()
	{
		prueba = new HashLinearProbing<String,String>(10);
	}

	
	

	@Test
	public void testPut()
	{
		setUp1();
		prueba.put("dato1", "dato1");
		prueba.put("dato2", "dato2");
		prueba.put("dato3", "dato3");
		
		assertEquals(prueba.darSize(), 3);

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
	

	

	
}

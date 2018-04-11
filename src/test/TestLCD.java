package test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import lcdController.LCD;

public class TestLCD {
	 
	private LCD lcd;
	
	@Test
	public void test_for_1_0() throws Exception {
		
		lcd=new LCD();
		assertEquals(" _  \n"+
					 "| | \n"+
					 "| | \n"+
					 "| | \n"+
					 "|_| \n", lcd.buildLCD(1,0));
	}
	@Test
	public void test_for_1_1() throws Exception {
		
		lcd=new LCD();
		assertEquals("    \n"+
					 "  | \n"+
					 "  | \n"+
					 "  | \n"+
					 "  | \n", lcd.buildLCD(1, 1));
	}
	
	
	@Test
	public void test_for_1_2() throws Exception {
		
		lcd=new LCD();
		assertEquals("__  \n"+
					 "  | \n"+
					 "__| \n"+
					 "|   \n"+
					 "|__ \n", lcd.buildLCD(1,2));
	}
	
	@Test
	public void test_for_1_3() throws Exception {
		
		lcd=new LCD();
		assertEquals("__  \n"+
					 "  | \n"+
					 "__| \n"+
					 "  | \n"+
					 "__| \n", lcd.buildLCD(1,3));
	}
	
	@Test
	public void test_for_1_4() throws Exception {
		
		lcd=new LCD();
		assertEquals("    \n"+
					 "| | \n"+
					 "|_| \n"+
					 "  | \n"+
					 "  | \n", lcd.buildLCD(1,4));
	}
	@Test
	public void test_for_1_5() throws Exception {
		
		lcd=new LCD();
		assertEquals(" __ \n"+
					 "|   \n"+
					 "|_  \n"+
					 "  | \n"+
					 "__| \n", lcd.buildLCD(1,5));
	}

	@Test
	public void test_for_1_6() throws Exception {
		
		lcd=new LCD();
		assertEquals(" __ \n"+
					 "|   \n"+
					 "|_  \n"+
					 "| | \n"+
					 "|_| \n", lcd.buildLCD(1,6));
	}
	
	@Test
	public void test_for_1_7() throws Exception {
		
		lcd=new LCD();
		assertEquals("__  \n"+
					 "  | \n"+
					 "__| \n"+
					 "  | \n"+
					 "  | \n", lcd.buildLCD(1,7));
	}
	@Test
	public void test_for_1_8() throws Exception {
		
		lcd=new LCD();
		assertEquals(" _  \n"+
					 "| | \n"+
					 "|_| \n"+
					 "| | \n"+
					 "|_| \n", lcd.buildLCD(1,8));
	}
	@Test
	public void test_for_1_9() throws Exception {
		
		lcd=new LCD();
		assertEquals(" _  \n"+
					 "| | \n"+
					 "|_| \n"+
					 "  | \n"+
					 "__| \n", lcd.buildLCD(1,9));
	}
	
	@Test
	public void test_for_1_1234() throws Exception {
		
		lcd=new LCD();
		assertEquals("    "+"__  "+"__  "+"    \n"+
					 "  | "+"  | "+"  | "+"| | \n"+
					 "  | "+"__| "+"__| "+"|_| \n"+
					 "  | "+"|   "+"  | "+"  | \n"+
					 "  | "+"|__ "+"__| "+"  | \n", lcd.buildLCD(1,1234));
	
	}
	
	@Test
	public void test_for_1_807() throws Exception {
		
		lcd=new LCD();
		assertEquals(" _  "+" _  "+"__  \n"+
					 "| | "+"| | "+"  | \n"+
					 "|_| "+"| | "+"__| \n"+
					 "| | "+"| | "+"  | \n"+
					 "|_| "+"|_| "+"  | \n", lcd.buildLCD(1,807));
		

	}
	
	@Test
	public void test_for_3_6() throws Exception {
		
		lcd=new LCD();
		assertEquals(" ____ \n"+
					 "|     \n"+
					 "|     \n"+
					 "|     \n"+
					 "|___  \n"+
					 "|   | \n"+
					 "|   | \n"+
					 "|   | \n"+
					 "|___| \n", lcd.buildLCD(3,6));
	}


	@Test
	public void test_for_3_7() throws Exception {
		
		lcd=new LCD();
		assertEquals("____  \n"+
					 "    | \n"+
					 "    | \n"+
					 "    | \n"+
					 "____| \n"+
					 "    | \n"+
					 "    | \n"+
					 "    | \n"+
					 "    | \n", lcd.buildLCD(3,7));
	}
	@Test
	public void test_for_3_4() throws Exception {
		
		lcd=new LCD();
		assertEquals("      \n"+
					 "|   | \n"+
					 "|   | \n"+
					 "|   | \n"+
					 "|___| \n"+
					 "    | \n"+
					 "    | \n"+
					 "    | \n"+
					 "    | \n", lcd.buildLCD(3,4));
	}
	@Test
	public void test_for_3_723() throws Exception {
		
		lcd=new LCD();
		assertEquals("____  "+"____  "+"____  \n"+
					 "    | "+"    | "+"    | \n"+
					 "    | "+"    | "+"    | \n"+
					 "    | "+"    | "+"    | \n"+
					 "____| "+"____| "+"____| \n"+
					 "    | "+"|     "+"    | \n"+
					 "    | "+"|     "+"    | \n"+
					 "    | "+"|     "+"    | \n"+
					 "    | "+"|____ "+"____| \n", lcd.buildLCD(3,723));
	}
	
	
	@Test
	public void test_for_9_5() throws Exception {
		
		lcd=new LCD();
		assertEquals(" __________ \n"+
					 "|           \n"+
					 "|           \n"+
					 "|           \n"+
					 "|           \n"+
					 "|           \n"+
					 "|           \n"+
					 "|           \n"+
					 "|           \n"+
					 "|           \n"+
					 "|_________  \n"+
					 "          | \n"+
					 "          | \n"+
					 "          | \n"+
					 "          | \n"+
					 "          | \n"+
					 "          | \n"+
					 "          | \n"+
					 "          | \n"+
					 "          | \n"+
					 "__________| \n", lcd.buildLCD(9,5));
	}
	
	@Test
	public void test_for_9_69() throws Exception {
		
		lcd=new LCD();
		assertEquals(" __________ "+" _________  \n"+
					 "|           "+"|         | \n"+
					 "|           "+"|         | \n"+
					 "|           "+"|         | \n"+
					 "|           "+"|         | \n"+
					 "|           "+"|         | \n"+
					 "|           "+"|         | \n"+
					 "|           "+"|         | \n"+
					 "|           "+"|         | \n"+
					 "|           "+"|         | \n"+
					 "|_________  "+"|_________| \n"+
					 "|         | "+"          | \n"+
					 "|         | "+"          | \n"+
					 "|         | "+"          | \n"+
					 "|         | "+"          | \n"+
					 "|         | "+"          | \n"+
					 "|         | "+"          | \n"+
					 "|         | "+"          | \n"+
					 "|         | "+"          | \n"+
					 "|         | "+"          | \n"+
					 "|_________| "+"__________| \n", lcd.buildLCD(9,69));
	}
	
	

}

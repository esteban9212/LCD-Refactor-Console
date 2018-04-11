package lcdController;
import java.util.ArrayList;
import java.util.HashMap;

public class LCD {

	private static final String NOT = " ";
	private static final String VER = "|";
	private static final String HOR = "_";

	private static final HashMap<Integer, String[]> TEMPLATE_SIZE1 = new HashMap<Integer, String[]>() {
		{
			put(new Integer(1), new String[] { NOT,NOT,NOT,
												NOT,NOT,VER,
												NOT,NOT,VER,
												NOT,NOT,VER,
												NOT,NOT,VER });

			put(new Integer(2), new String[] { HOR,HOR,NOT,
												NOT,NOT,VER,
												HOR,HOR,VER,
												VER,NOT,NOT,
												VER,HOR,HOR });

			put(new Integer(3), new String[] { HOR, HOR, NOT,
												NOT, NOT, VER,
												HOR, HOR, VER,
												NOT, NOT, VER,
												HOR, HOR, VER });

			put(new Integer(4), new String[] { NOT, NOT, NOT,
												VER, NOT, VER,
												VER, HOR, VER,
												NOT, NOT, VER,
												NOT, NOT, VER });

			put(new Integer(5), new String[] { NOT, HOR, HOR,
												VER, NOT, NOT,
												VER, HOR, NOT,
												NOT, NOT, VER,
												HOR, HOR, VER });

			put(new Integer(6), new String[] { NOT, HOR, HOR,
												VER, NOT, NOT,
												VER, HOR, NOT,
												VER, NOT, VER,
												VER, HOR, VER });

			put(new Integer(7), new String[] { HOR, HOR, NOT,
												NOT, NOT, VER,
												HOR, HOR, VER,
												NOT, NOT, VER,
												NOT, NOT, VER });

			put(new Integer(8), new String[] { NOT, HOR, NOT,
												VER, NOT, VER,
												VER, HOR, VER,
												VER, NOT, VER,
												VER, HOR, VER });

			put(new Integer(9), new String[] { NOT, HOR, NOT,
											VER, NOT, VER,
											VER, HOR, VER,
											NOT, NOT, VER,
											HOR, HOR, VER });
			put(new Integer(0), new String[] { NOT, HOR, NOT,
												VER, NOT, VER,
												VER, NOT, VER,
												VER, NOT, VER,
												VER, HOR, VER });
		}
	};

	
	/**
     * Main function that returns the string with the number in LCD format.
     *
     * @param size      Int that indicates the size of the print (between 1 and 10)
     * @param number    Int that indicates the number that will be converted 
     * @return String   string with the conversion
     */
	public String buildLCD(int size,int number) {
		
		ArrayList<String>[] arreglo=buildArrayNumbers(size,number);
		String nums=drawNumbers(arreglo,size);
		System.out.println(nums);
		return nums;
	}
	/**
     * Responsible for building an array with information of each of the digits in the parameter numbers.
     *
     * @param size      Int that indicates the size of the print (between 1 and 10)
     * @param number    Int that indicates the number that will be converted 
     * @return ArrayList<String>[] array of arraylist, with ordered information of the number converted to lcd.
     * 			the number will be decomposed into an arraylist and stored inside each array.
     */
	private static ArrayList<String>[] buildArrayNumbers(int size,int numbers) {

		String digits = Integer.toString(numbers);
		ArrayList<String>[] digitsArreglo= new ArrayList[digits.length()];

		for (int i = 0; i < digitsArreglo.length; i++) {
			String[] plantilla1=getTemplate(Integer.parseInt(digits.charAt(i)+""));
			ArrayList<String> resultado;
			if(size==1){
				resultado=transmit(plantilla1);
				digitsArreglo[i]=resultado;
			}else {
				resultado=expandColumns(size,plantilla1);
				resultado=expandRows(size, resultado);
				digitsArreglo[i]=resultado;
			}
		}
		return digitsArreglo;
	}
	
	/**
     * Responsible for returning the lcd number in a legible string format.
     *
     * @param  lcdNumbers ArrayList<String>[]  array of arraylist, with ordered information of the number converted to lcd
     * @param size    Int that indicates the size of the print (between 1 and 10) 
     * @return String string with information about the numberLCD correctly formatted to be used
     */
	private static String drawNumbers(ArrayList<String>[] lcdNumbers,int size){
		int columnas=size+2; 
		int filas=2*size+3;
		String ret="";
		int tamanio=lcdNumbers.length;
		int k = 0; 
		while ( k < filas ) {

			int i = 0; 
			int j=k*(size+2);
			while ( i < tamanio ) {
				while (j < columnas ) {
					ret+=lcdNumbers[i].get(j)+"";
					j++;
				}
				ret+=" ";
				i++;
				j=k*(size+2);
			}
			k++;
			j=k*(size+2);
			columnas+=(size+2);
			ret+="\n";
		}
		return ret;
	}

	/**
     * Responsible for giving the stored templates.
     *
     * @param  number Int  number from which you want to get your template.
     * @return string array with template.
     */
	private static String[] getTemplate(int number) {
		String result[] = TEMPLATE_SIZE1.get(new Integer(number));
		if (null == result)
			throw new RuntimeException(String.format("Dígito %d no encontrado",
					number));
		return result;
	}

	/**
     * Responsible for expanding a template horizontally depending on the size required.
     *
     * @param  template String[]  array with template information.
     * @param size    Int that indicates the size  (between 1 and 10) .
     * @return ArrayList<String> arraylist with the number expanded horizontally.
     */
	private static ArrayList<String> expandColumns(int size,String[] template){

		ArrayList<String> ret= transmit(template);

		int i = template.length-1;
		while ( i > 0 ) {
			if(template[i].equals(HOR)||template[i].equals(NOT)){
				for (int j = 0; j < size-1; j++) {
					ret.add(i, template[i]);					
				}
				i=i-3;
			}else{
				i--;
			}															
		}
		return ret;
	}
	/**
     * Responsible for expanding a template vertically depending on the size required.
     *
     * @param size    Int that indicates the size  (between 1 and 10).
     * @param  toExpand ArrayList<String>  previously horizontally expanded arraylist.
     * @return ArrayList<String> arraylist with the number expanded vertically.
     */
	private static ArrayList<String> expandRows(int size,ArrayList<String> toExpand){

		ArrayList<String> ret= transmit(toExpand);
		int columnas=toExpand.size()/5;
		int i=0;
		int tocopy=0;

		for (int k = 0; k < size-1; k++) {
			i =toExpand.size()-1-columnas;
			tocopy=i-(columnas-1);
			for (int j = 0; j < columnas; j++) {
				ret.add(i+1, toExpand.get(tocopy));
				i=i+1; 
				tocopy++;
			}
		}

		for (int k = 0; k < size-1; k++) {
			i =(columnas-1)*2;
			tocopy=i-(columnas-2);

			for (int j = 0; j < columnas; j++) {
				ret.add(i+2, toExpand.get(tocopy));
				i=i+1; 
				tocopy++;
			}
		}
		return ret;	
	}
	/**
     * Responsible to transmit data from a string array to a string arraylist.
     *
     * @param  array String[]  string array.
     * @return ArrayList<String> string arraylist.
     */
	private static ArrayList<String> transmit(String[] array){

		ArrayList<String> ret= new ArrayList<String>();
		for (int i = 0; i < array.length; i++) {
			ret.add(array[i]);
		}
		return ret;	
	}
	/**
     * Responsible to transmit data from a string arraylist to a string arraylist..
     *
     * @param  array ArrayList<String>  string array arraylist.
     * @return ArrayList<String> string arraylist.
     */
	private static ArrayList<String> transmit(ArrayList<String> array){

		ArrayList<String> ret= new ArrayList<String>();
		for (int i = 0; i < array.size(); i++) {
			ret.add(array.get(i));
		}
		return ret;	
	}

}

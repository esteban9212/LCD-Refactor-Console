package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

import lcdController.LCD;

public class Main {
	private static LCD lcd;
	private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

		lcd=new LCD(); 
		// TODO Auto-generated method stub
		bufferedWriter.write("****************************************************\n");
		bufferedWriter.write("*Welcome*\n");
		bufferedWriter.write("\n");
		bufferedWriter.write("this program prints numbers in LCD display style.\n");
		bufferedWriter.write("to print number in this format what you have to do is write the number \n"
				+ "and the size in which you want the number in the console, in the following format <num1,num2>\n"
				+ "without the symbols '< >', the num1 will behave as the size of the number must be between 1 and 10,\n"
				+ "and the num2 will be the number to print.");
		bufferedWriter.write("you can build many inputs previously and paste them into the console,\n"
				+ "just make sure to put the command '0.0' as the final line to indicate that you are finished.\n");
		bufferedWriter.write("Only work if the input is written in the indicated format	.\n");
		bufferedWriter.write("Ready, enjoy this program that i developed as a challenge on the part of PSL.\n");
		bufferedWriter.write("Written by Esteban Aguirre Patiño, Systems Engineer from Icesi University.");

		bufferedWriter.flush();

		String input;

		while (true) {

			input = bufferedReader.readLine().toString();

			if (input.equals("0,0")) {
				break;
			} else if (validate(input)) {
				String[] splitInput = input.split(",");
				String left = splitInput[0];
				String right = splitInput[1];

				int size = Integer.parseInt(left);
				int number=Integer.parseInt(right);
				String numberLCD=lcd.buildLCD(size, number);
				bufferedWriter.write(numberLCD);
			} else {
				continue;
			}
			bufferedWriter.write("\n");
		}
		bufferedWriter.close();
		bufferedReader.close();

	}

	private static boolean validate(String input) throws IOException {


		if (input == null) {
			bufferedWriter.write("Input line must not be null.\n");
			return false;
		}

		if (input.trim().isEmpty()) {
			bufferedWriter.write("Input line must not be empty.\n");
			return false;
		}

		if (!input.contains(",")) {
			bufferedWriter.write("Input line must be a comma separated pair of numbers.\n");
			return false;
		}

		String[] splitInput = input.split(",");

		if (splitInput.length != 2) {
			bufferedWriter.write("Input line must have only one comma.\n");
			return false;
		}

		String left = splitInput[0];
		String right = splitInput[1];

		try {
			Integer.parseInt(left);
		} catch (NumberFormatException nfe) {
			bufferedWriter.write("Left parameter must be a number.\n");
			return false;
		}

		try {
			new BigInteger(right, 10);
		} catch (NumberFormatException nfe) {
			bufferedWriter.write("Right number must be a number.\n");
			return false;
		}

		int size = Integer.parseInt(left);
		if (size > 10 || size < 1) {
			bufferedWriter.write("Size must be a number between [1,10].\n");
			return false;
		}

		BigInteger number = new BigInteger(right);
		if (number.compareTo(BigInteger.ZERO) < 0) {
			bufferedWriter.write("Number must be a positive number.\n");
			return false;
		}

		return true;

	}





}

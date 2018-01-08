package main;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import validatorImp.ValidatorImp;
/*
 * Assertion : input Integer
 * 
 * Additional method for undoing Square root -> power of 2 is add
 * 
 * 
 * */
public class Main {

	//    private static ArrayList<String> variableNames = new ArrayList<String>();
	//    private static ArrayList<Double> variableValues = new ArrayList<Double>();
	//    private static Stack<Double> operationStack = new Stack<Double>();

	public static void main(String[] args) throws Exception {

		System.out.println("Hello World");
		Scanner scanner = new Scanner(System.in);


		ValidatorImp validator = new ValidatorImp();
		Calculator calculator = new Calculator();

		try {
			while(scanner.hasNextLine()) {
				String inputStr = scanner.nextLine();
				List<String> strList = Arrays.asList(inputStr.split("\\s+"));
				// validator
				try {
					for(String str : strList) {
						validator.validateInputString(str);

					}
					calculator.calucate(inputStr, false);
				}catch (Exception e){
					e.printStackTrace();
				}

				System.out.println();
				DecimalFormat fmt = new DecimalFormat("0.##########");
				Stack<Double> stack = calculator.getValuesStack();
				System.out.println("Stack: ");
				for (Double value : stack) {
					System.out.print(fmt.format(value) + " ");
				}
				System.out.printf("%n");
			}

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			scanner.close();
		}

		//		System.out.println("Input String : " + inputStr);

		scanner.close();

	}



}

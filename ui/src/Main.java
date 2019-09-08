import java.util.*;
public class Main{
	public static double[] Memory = new double[10];
		
	
	
	public static void main(String args[]){
		Scanner str = new Scanner(System.in);
		Scanner n = new Scanner(System.in);
		boolean flows;
		System.out.println("Welcome to the calculator \nSelect mode: \n1- One operation at time. \n2- Operations flow. \n3- Exit."); 
		int mode = n.nextInt();
		switch (mode) {
			case 1:
					flows = false;
					structure(str, flows, n);
				break;
			case 2:
					flows = true;
					structure(str, flows, n);
				break;
			case 3:
				break;
			default:
					System.out.println("Invalid option!!!");
				break;
		}
	}
		
		//structure method
	public static void structure(Scanner str, boolean flows, Scanner n){
		double num1 = 0;
		double result = 0;
		double num2= 0;
		char operation;
		char response = 'y';
		String parser;
		
		parser = str.nextLine();
		num1 = funcs(parser, str, n);
		System.out.println("= " + num1);
		while (response !='n'){
			operation = str.nextLine().charAt(0);
			switch(operation){
				case '+':
						parser = str.nextLine();
						num2 = funcs(parser, str, n);
						result = sum(num1, num2);
						System.out.println("= " + result);
					break;
				case '-':
						parser = str.nextLine();
						num2 = funcs(parser,  str, n);
						result = subtraction(num1, num2);
						System.out.println("= " + result);
					break;
				case '*':
						parser = str.nextLine();
						num2 = funcs(parser, str, n);
						result = mult(num1, num2);
						System.out.println("= " + result);
					break;
				case '/':
						parser = str.nextLine();
						num2 = funcs(parser, str, n);
						result = div(num1, num2);
						System.out.println("= " + result);
					break;
				case '%':
						parser = str.nextLine();
						num2 = funcs(parser, str, n);
						result = mod(num1, num2);
						System.out.println("= " + result);
					break;
				case '#':
						flows = !flows;
					break;
				default:
						System.out.println("Invalid operator!!");
					break;
			
			}
			if(flows){
				num1 = result;
			}
			else {
				System.out.println("\nDo you want to do another operation? \ny- yes \nn- no");
				response = str.nextLine().charAt(0);
				if (response == 'n'){
					break;
				}
				else if(response == '#'){
					System.out.println("Changing to operation flows mode.");
					flows = true;
				}
				parser = str.nextLine();
				num1 = funcs(parser, str, n);
			}
			Memory = MemoryOrganizator(result, Memory);
		}
	
	}
	
		//functions method
	public static double funcs(String parser, Scanner str, Scanner n){
		double num = 0;
		boolean isANum = false;
		try{
			num = Double.parseDouble(parser);
			isANum = true;
		}
		catch(Exception e){
			isANum = false;
		}
		if (!isANum){
			switch(parser){
				case "sin":
						num = sin(n);
					break;
				case "cos":
						num = cos(n);
					break;
				case "tan":
						num = tan(n);
					break;
				case "mem":
						num = mem(n);
					break;
			}
		}
		return num;
	}
	
		//method for mem
	public static double mem(Scanner str){
		for (int i=0; i<Memory.length; i++){
						System.out.println("Memory  "+ i + "  " + Memory[i]);
						}
						int mem = str.nextInt();
						double num1 = Memory[mem];
						return num1;
	}
		
		
		//method to organize the mem
	public static double[] MemoryOrganizator(double result, double[] Memory){
		Scanner n = new Scanner(System.in);
		for (int i = 0; i<Memory.length-1; i++){
			Memory[i] = Memory[i+1];
		}
		Memory[Memory.length-1] = result;
		return Memory;
	}
	//method for the sum
	public static double sum(double a, double b) {
		
		double c = a + b;
		
		return c;
	}
	//method for the subtraction
	public static double subtraction(double a, double b){
		double c = a - b;
		
		return c;
	}
	//method for the multiplication
	public static double mult(double a, double b) {
		double c = a * b;
		
		return c;
	}
	//method for the division
	public static double div(double a, double b) {
		double c = a / b;
		
		return c;
	}
	//method for the module
	public static double mod(double a, double b) {
		double c = a % b;
		
		return c;
	}
	//method for sin
	public static double sin(Scanner n){
		double a = n.nextDouble();
		double b = Math.toRadians(a);
		double c = Math.sin(b);
		
		return c;
	}
	//method for cos
	public static double cos(Scanner n){
	double a = n.nextDouble();
		double b = Math.toRadians(a);
		double c = Math.cos(b);
		
		return c;
	}
	//method for tan
	public static double tan(Scanner n){
		double a = n.nextDouble();
		double b = Math.toRadians(a);
		double c = Math.tan(b);
		
		return c;
	}
}
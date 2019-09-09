import java.util.*;
public class Main{
	public static final double PI = Math.PI;
	public static double[] Memory = new double[10];
		
	/**
	*<p>Description:<p> This is the main method, is to select what mode you want and uses a boolean as centinel. <br>
	*<p>Pos:<p> It makes the calculator work by calling the structure method. <br>
	*/
	
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
		/**
		*<p>Description:<p> This is the method to choose what mode of the calculator you want to use and has the structure of the basic operations.<br>
		*<p>Pos:<p> This method do all the basic operations, works to do the operation by operation mode and the operations flow mode, also saves the results in the memory. <br>
		*@param str Receives a Scanner of strings
		*@param flows Is the boolean that indicates in which mode is the calculator
		*@param n Receives a Scanner of numbers 
		*/
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
				System.out.println("Changing to operation by operation mode.");
				System.out.println("\nDo you want to do another operation? \ny- yes \nn- no \n#- come back to operations flow.");
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
	
	/**
	*<p>Description:<p> This method receive the parser and checks if is a number or not, has the switch with all the functions' cases. <br>
	*<p>Pos:<p> This method checks if the string in the parser is a number and gives you back the number, if is not a number, then it checks if its a function and what function is
	*and gives you back the result of the function. <br>
	*@param parser Is the scanner that receives the number or function and then parse it into a number or checks what function is.
	*@param str Is a scanner for strings.
	*@param n Is a scanner for numbers and its used in each method of the functions.
	*@return num Gives back the parsed number or tha result of the functions.
	*/
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
			parser = parser.toLowerCase();
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
				case "sqrt":
						num = sqrt(n);
					break;
				case "mem":
						num = mem(n);
					break;
				case "pi":
						num = PI;
					break;
				case "pow":
						num = pow(n);
					break;
				case "fact":
						num = fact(n);
					break;
				case "log":
						num = log(n);
					break;
				case "logn":
						num = logn(n);
					break;
				case "sqn":
						num = sqn(n);
					break;
				case "radtodeg":
						num = radtodeg(n);
					break;
				case "degtorad":
						num = degtorad(n);
					break;
				default:
						System.out.println("Invalid function!!");
					break;
			}
		}
		return num;
	}
	/**
	*<p>Description:<p> This method shows the memory's list and asks you to choose one.<br>
	*<p>Pos:<p> With this method you select the number in memory's list and it gives you back the number.<br>
	*@param str Is a scanner that receives the number of the position in the memory's array. str != null. str !="".
	*@return num1 Gives back the number in the position of the array that the user had selected.
	*/
		//method for mem
	public static double mem(Scanner str){
		for (int i=0; i<Memory.length; i++){
						System.out.println("Memory  "+ i + "  " + Memory[i]);
						}
						int mem = str.nextInt();
						double num1 = Memory[mem];
						return num1;
	}
	/**
	*<p>Description:<p> This method reorganize memory's list by puting the newest result in the last position and deletes the oldest one. <br>
	*<p>Pos:<p> This method gives back the memory's array reorganized. <br>
	*@param result Receives the result of the operations.
	*@param Memory Receives the memory's array.
	*@return Memory Gives back the Memory's array reorganized.
	*/
		
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
	//method for square root
	public static double sqrt(Scanner n){
		double a = n.nextDouble();
		double b;
		double c = a/2;
		do{
			b = c;
			c = (b + (a / b)) / 2;
		} while ((b - c) !=0);
		return c;
	}
	//method for power
	public static double pow(Scanner n){
		System.out.print("Number: ");
		double a = n.nextDouble();
		System.out.print("Exponent: ");
		double b = n.nextDouble();
		double c = 1;
		for(int i= 1; i<=b; i++){
			c = c * a;
		}
		return c;
	}
	//method for factorial
	public static double fact(Scanner n){
		double a = n.nextDouble();
		double c = 1;
		for (int i= 1; i<=a; i++){
			c *=i;
		}
		return c;
	}
	//method for log10
	public static double log(Scanner n){
		double a = n.nextDouble();
		double c = Math.log10(a);
		return c;
	}
	//method for log n-base
	public static double logn(Scanner n){
		System.out.print("Number: ");
		double a = n.nextDouble();
		System.out.print("Base: ");
		double b = n.nextDouble();
		double c = Math.log10(a)/Math.log10(b);
		return c;
	}
	//method for n square
	public static double sqn(Scanner n){
		System.out.print("base: ");
		double a = n.nextDouble();
		System.out.print("Exponent: ");
		double b = n.nextDouble();
		double c = (double) Math.pow(a, 1/b);
		return c;
	}
	//method to convert radians to degrees
	public static double radtodeg(Scanner n){
		double a = n.nextDouble();
		double c = a * (180/PI);
		return c;
	}
	//method to convert degrees to radians
	public static double degtorad(Scanner n){
		double a = n.nextDouble();
		double c = a * (PI/180);
		return c;
	}
}
package lab1;
import java.util.Scanner;

//Lakshmi Palaparthi; Kim Wolff; Hava Marneweck;Ian Alejandro
public class Retirement {
	public static void main(String[] args) {
		// A calculator for how much money you need to earn each month for retirement 
		
		Scanner in = new Scanner(System.in);	//Create scanner object to read input from user
		
		//Ask user for input	
		System.out.println("Enter the number of years you will be retired: ");
		double retiredYears = in.nextDouble();
		
		System.out.println("Enter the annual income you need to live: ");
		double requiredIncome = in.nextDouble();
		
		System.out.println("Enter your monthy SSI: ");
		double monthlySSI = in.nextDouble();
		while (monthlySSI>2642){	//Test user input since there is a maximum possible SSI
			System.out.println("Your monthly SSI will never be greater than $2642. Try another number:");
			monthlySSI = in.nextDouble();
		}
		
		System.out.println("Enter your annual return during retirement: ");

		double retiredReturn = in.nextDouble();
		while ((retiredReturn > 3) || (retiredReturn < 0)){	//Test that input is between 0-3
			System.out.println("Your annual return during retirement must be in the range of 0 to 3 percent. Try another number:");
			retiredReturn = in.nextDouble();
		} 
		
		//Calculate the total savings needed to live off of during retirement
		double totalSavings = (requiredIncome-monthlySSI)*(1-(1/Math.pow((1+(retiredReturn/100)/12),(12*retiredYears))))/((retiredReturn/100)/12);
		
		System.out.println("Enter the number of years you will be working: ");
		double workYears = in.nextDouble();
		
		System.out.println("Enter your annual return during employment: ");
		double annualReturn = in.nextDouble();
		while (annualReturn > 20 || annualReturn < 0){	//Test that input is between 0-20
			System.out.println("Your annual return during employment must be in the range of 0 to 20 percent. Try another number:");
			annualReturn = in.nextDouble();
		} 
		
		//Calculate the savings needed each month during the work-years to meet the needs of retirement
		double monthlySavings = totalSavings * ((annualReturn/100)/12)/(Math.pow((1+(annualReturn/100)/12),(workYears*12))-1);
		
		//Show the user the necessary monthly savings
		System.out.print("Savings Needed Each Month Until Retirement: $");
		System.out.printf("%.2f", monthlySavings);
		
		in.close();	//Close the scanner object

}
}
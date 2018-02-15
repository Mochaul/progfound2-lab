import java.util.Scanner;

/**
 * @author Template Author: Ichlasul Affan and Arga Ghulam Ahmad
 *
 * This template is used for Programming Foundations 2 Tutorial 2 Term 2 2017/2018.
 * It is recommended to use this template as the base for completing Tutorial 2.
 * You are allowed to make modifications to the template as long it still matches
 * with the tutorial specification.
 *
 * How to use this template:
 * 1. Complete the code that labelled with TODO word
 * 2. Replace the area with dots with correct statement or expression so that
 * the program can be compiled and produced output according to the specification.
 *
 * Code Author (Student):
 * @author ....., Student ID ....., Class ....., GitLab Account: .....
 */

public class SistemSensus {

	public static void main(String[] args) {
		// Create a new Scanner object to read input from standard input
		Scanner input = new Scanner(System.in);

        // TODO This section corresponds to tutorial problem about "Slum Census"
		// The interface to get input from user
		System.out.print("CENSUS DATA PRINTING PROGRAM\n" +
				"--------------------\n" +
				"Name of Family Head   : ");
		String name = .....;
		System.out.print("Home Address           : ");
		String address = .....;
		System.out.print("Body Length (cm)     : ");
		... length = .....;
		System.out.print("Body Width (cm)       : ");
		... width = .....;
		System.out.print("Body Height (cm)      : ");
		... height = .....;
		System.out.print("Body Weight (kg)       : ");
		... weight = .....;
		System.out.print("Number of Family Members: ");
		... members = .....;
		System.out.print("Date of Birth          : ");
		String birthDate = .....;
		System.out.print("Additional Notes       : ");
		String notes = .....;
		System.out.print("Number of Data Prints    : ");
		... numberPrints = .....;


        // TODO This section corresponds to tutorial problem about "Slum Census"
        // TODO Calculate body weight ratio per volume (see the formula in the 
        // tutorial description
		... ratio = (...) (...);

		for (.....) {
            // TODO Provide input related to person that will receive the
            // print result
			System.out.print("Pencetakan " + ... + " dari " + numberPrints + " untuk: ");
			String receiver = .....; // Read input and transform input to upper
                                     // case characters

			// TODO Check whether it has notes or not
			if (.....) notes = .....;
			else notes = .....;

            // TODO Print result
            // TODO Replace the empty string to match the expected output
			String result = "";
			.....;
		}


        // TODO This section corresponds to the bonus tutorial about "Apartment 
        // Recommendation"
        // TODO Calculate the family number from the available parameters
        // See the formula in the tutorial description



        // TODO Combine the calculation results into a family number according
        // to the expected format
		String familyNumber = "";

        // TODO Calculate the food budget per year
        // See the formula in the tutorial description
		... budget = (...) (...);

        // TODO Calculate age from birthDate
        // See the formula in the tutorial description
		... birthYear = .....; // See hint if it is not clear enough
		... age = (...) (...);

        // TODO Do the process of determining the apartment
        // See the criteria in the tutorial description





        // TODO Print recommendation
        // TODO Replace the empty string to match the expected output
		String recommendation = "";
		.....;

		input.close();
	}
}

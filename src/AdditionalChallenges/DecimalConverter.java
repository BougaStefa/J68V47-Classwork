package AdditionalChallenges;

import java.util.Scanner;

public class DecimalConverter {
		public static String binaryConvert(int dec) {
				return Integer.toBinaryString(dec);
		}

		public static String octalConvert(int dec) {
				return Integer.toOctalString(dec);
		}

		public static String hexConvert(int dec) {
				return Integer.toHexString(dec).toUpperCase();
		}

		public static void main(String[] args) {
				Scanner input = new Scanner(System.in);
				System.out.println("Enter the number you wish to convert ");
				int userNum = input.nextInt();
				//clearing scanner
				input.nextLine();
				System.out.println("Enter the from you would like to convert it to (binary, octal, hexadecimal etc.)");
				String userType = input.nextLine().toUpperCase();
				if (userType.equals("BINARY")) {
						System.out.printf("Your number in binary would be %s%n", binaryConvert(userNum));
				} else if (userType.equals("OCTAL")) {
						System.out.printf("Your number in octal would be %s%n", octalConvert(userNum));
				} else if (userType.equals("HEXADECIMAL")) {
						System.out.printf("Your number in hexadecimal would be %s%n", hexConvert(userNum));
				} else {
						System.out.println("Invalid or Unsupported number type. Terminating converter.");
				}
		}
}

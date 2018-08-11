import java.util.Scanner;

	
class CustomException extends Exception {
	   public CustomException(String msg){
	      super(msg);
	   }
}
	
public class Workshop8 {

	private static double getAverage(int count) 
			throws CustomException {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Please enter %d integers:\n", count);
		int sum = 0;
		for (int i = 0; i < count; ++i) {
			if (!scanner.hasNextInt()) {
				System.out.println("Please enter an integer value.");
				// Discard the error data
				scanner.nextLine();
				// Repeat the prompt
				--i;
			} else {
				sum += scanner.nextInt();
				if (i == 0 && sum == 0) {
					throw new CustomException("First value cannot be 0!");
				}
			}
		}
		scanner.close();
	
		return ((double)sum) / count;
	}
	
	public static void main(String[] args) {
		System.out.println("Please enter the number of integers in the average:");
		Scanner scanner = new Scanner(System.in);
		try {
			if (scanner.hasNextInt()) {
				int count = scanner.nextInt(); System.out.printf("The average is %.2f\n", getAverage(count));
			}
		} catch (CustomException e) {
			e.printStackTrace();
		}
		scanner.close();
	}
}

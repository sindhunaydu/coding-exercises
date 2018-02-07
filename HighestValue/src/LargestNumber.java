import java.math.BigInteger;
import java.util.HashMap;

//Using HasMap to return the highest possible value from a given block of numbers at O(n)
public class LargestNumber {
	public static void main(String[] args) {
		BigInteger number = new BigInteger(
				"5890435943858453532948324984358932849483259084392843249023859084325743590328548359048590843232493283249324932840984332483258904375368754368954768975467546897565468975454353475437537457493278473289749783248372487389757435437535943578435984358435890438");
		System.out.println("Number: " + number);
		System.out.println("Highest Number: " + getHighestPossibleNumber(number));
	}

	// Method to calculate highest possible number
	public static BigInteger getHighestPossibleNumber(BigInteger number) {
		if (number == null) {
			return null;
		} else {
			// HashMap is used identify the number of occurrences of numbers 0 to 9
			HashMap<Integer, Integer> digitOccurences = new HashMap<Integer, Integer>();
			// Initializing the number of occurrences of numbers 0 to 9 to 0
			for (int i = 0; i <= 9; i++) {
				digitOccurences.put(i, 0);
			}
			String str = number.toString();
			for (int i = 0; i < str.length(); i++) {
				// Selecting each digit from the input number
				int value = str.charAt(i) - '0';
				// Incrementing occurrence if the key value matches the digit
				digitOccurences.put(value, digitOccurences.get(value) + 1);
			}
			StringBuilder highestNumber = new StringBuilder();
			// Key represents digits 0 to 9
			// Value represents the occurrence of the digits in the given number
			for (int i = 9; i >= 0; i--) {
				int count = digitOccurences.get(i);
				// Key is appended based on its occurrence to the highestNumber
				while (count > 0) {
					highestNumber.append(i);
					count--;
				}
			}
			// HighestValue is returned as a BigInteger
			return (new BigInteger(highestNumber.toString()));
		}
	}
}

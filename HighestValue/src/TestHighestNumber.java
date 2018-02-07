import static org.junit.Assert.assertEquals;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

//Testing getHighestPossibleNumber() method
public class TestHighestNumber {

	@Test
	public void basicTest() {
		BigInteger input = new BigInteger("654982");
		BigInteger expected = new BigInteger("986542");
		assertEquals(expected, (LargestNumber.getHighestPossibleNumber(input)));
	}

	@Test
	public void ascendingTest() {
		BigInteger input = new BigInteger("123456");
		BigInteger expected = new BigInteger("654321");
		assertEquals(expected, (LargestNumber.getHighestPossibleNumber(input)));
	}

	@Test
	public void sortedTest() {
		BigInteger input = new BigInteger("654321");
		BigInteger expected = new BigInteger("654321");
		assertEquals(expected, (LargestNumber.getHighestPossibleNumber(input)));
	}

	@Test
	public void duplicateTest() {
		BigInteger input = new BigInteger("111111");
		BigInteger expected = new BigInteger("111111");
		assertEquals(expected, (LargestNumber.getHighestPossibleNumber(input)));
	}

	@Test
	public void nullTest() {
		BigInteger input = null;
		BigInteger expected = null;
		assertEquals(expected, (LargestNumber.getHighestPossibleNumber(input)));
	}
}

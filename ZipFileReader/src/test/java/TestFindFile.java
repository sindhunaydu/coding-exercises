import static org.junit.Assert.assertFalse;

import org.junit.Test;

//Unit tests for findFile() method in SearchFile class
public class TestFindFile {

	@Test
	public void incorrectFilePathTest() {
		String location = "c:/abc.zip";
		assertFalse(SearchFile.findFile(location));
	}

	@Test
	public void incorrectFileNameTest() {
		String location = "c:/user/Downloads/t.zip";
		assertFalse(SearchFile.findFile(location));
	}
}

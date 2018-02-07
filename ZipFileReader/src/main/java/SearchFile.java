import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SearchFile {
	public static ArrayList<FileSummary> summary = new ArrayList<FileSummary>();
	// Keywords to be searched
	public static String[] keywords = { "a", "ode", "x", "123" };

	public static boolean findFile(String zipLocation) {
		ZipFile zipFile = null;
		boolean found = false;
		//Verifying if the path is correct
		if (new File(zipLocation).exists()) {
			try {
				// open a zip file from user entered location
				zipFile = new ZipFile(zipLocation);
				// Enumerate entries in the zip file
				Enumeration<? extends ZipEntry> e = zipFile.entries();
				while (e.hasMoreElements()) {
					ZipEntry entry = e.nextElement();
					// Removing extensions from the filename
					String entryName = entry.getName().replaceFirst("[.][^.]+$", "");
					// Keywords are searched against the filenames
					for (int i = 0; i < keywords.length; i++) {
						if (entryName.contains(keywords[i].toLowerCase())) {
							// If keyword is found, it is added as a new FileSummary object to summary
							// ArrayList
							FileSummary object = new FileSummary(keywords[i], entry.getName(),
									entry.getLastModifiedTime());
							summary.add(object);
							found = true;
						}
					}
				}
			} catch (IOException ioe) {
				System.out.println("Error opening zip file" + ioe);
			} finally {
				try {
					if (zipFile != null) {
						zipFile.close();
					}
				} catch (IOException ioe) {
					System.out.println("Error while closing zip file" + ioe);
				}
			}
		} else {
			System.out.println("Incorrect file path.");
		}
		return found;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String path;
		// Allows user to enter zip file path like, "c:/Users/user/Downloads/test.zip"
		System.out.println("Enter zip file location: ");
		path = scanner.nextLine();
		// findFile() method is called to verify if the files contain keyword(s)
		if (findFile(path)) {
			// Loads XML configuration from bean.xml
			ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
			SendEmail m = (SendEmail) context.getBean("sendEmail");
			System.out.println("Keyword(s) found!");
			// Email of the summary is composed and sent
			m.composeEmail(summary);
			System.out.println("Summary email sent.");
		} else
			System.out.println("Keyword(s) not found!");
		scanner.close();
	}
}
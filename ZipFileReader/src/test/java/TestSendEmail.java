import java.util.ArrayList;
import org.junit.Test;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.mockito.Mockito;
import junit.framework.TestCase;

public class TestSendEmail extends TestCase {
	// Test sending email
	@Test
	public void testComposeEmail() {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("fileSummary@email.com");
		msg.setTo("receiver@email.com");
		msg.setSubject("Summary");
		msg.setText("FILE SUMMARY: \n\n");
		MailSender mailSenderMock = Mockito.mock(MailSender.class);
		SendEmail testObject = new SendEmail();
		testObject.setMailSender(mailSenderMock);
		ArrayList<FileSummary> a = new ArrayList<FileSummary>();
		testObject.composeEmail(a);
		Mockito.verify(mailSenderMock).send(msg);
	}
}
import java.util.ArrayList;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SendEmail {
	public MailSender mailSender;

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void composeEmail(ArrayList<FileSummary> data) {
		// Email message details are set
		SimpleMailMessage msg = new SimpleMailMessage();
		// Sender email id
		msg.setFrom("fileSummary@email.com");
		// Receiver email id
		msg.setTo("receiver@email.com");
		msg.setSubject("Summary");
		StringBuilder message = new StringBuilder();
		// Appends multiple file summaries into one email
		for (FileSummary f : data) {
			message.append("\n-----------------------------------------------" + "\n\n Looking for keyword: "
					+ f.getKeyword() + "\n Found in the following file" + "\n Name: " + f.getFileName()
					+ "\n Last Modified Date: " + f.getModifiedDate());
		}
		msg.setText("FILE SUMMARY: \n\n" + message.toString());
		try {
			// Sending email
			mailSender.send(msg);
		} catch (MailException ex) {
			System.err.println(ex.getMessage());
		}
	}
}
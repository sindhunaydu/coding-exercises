import java.nio.file.attribute.FileTime;

//FileSummary class defines attributes of the summary
public class FileSummary {
	String keyword;
	String fileName;
	FileTime modifiedDate;
	
	public FileSummary(String keyword, String fileName, FileTime modifiedDate) {
		super();
		this.keyword = keyword;
		this.fileName = fileName;
		this.modifiedDate = modifiedDate;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public FileTime getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(FileTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
}
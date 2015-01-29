package pe.gob.oefa.efa.model;

import java.util.List;
 
import org.springframework.web.multipart.MultipartFile;
 
public class FileUploadForm {
 
    private List<MultipartFile> files;

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	public List<MultipartFile> getFiles() {
		return files;
	}
     
}
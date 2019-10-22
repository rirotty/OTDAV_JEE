package managedBeans;

import java.io.IOException;
import java.util.Scanner;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;

@ManagedBean
@ViewScoped
public class uploadBean {
	
	private Part file;
	
	
	public void upload() throws IOException{
		
		Scanner s=new Scanner(file.getInputStream());
		String fileContent=s.useDelimiter("\\A").next();
		s.close();
		
		System.out.println(fileContent);
	}
	

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}
	
	
	
	

}

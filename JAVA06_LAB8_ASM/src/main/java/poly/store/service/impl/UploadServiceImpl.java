package poly.store.service.impl;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import poly.store.service.UploadService;

@Service
public class UploadServiceImpl implements UploadService {
	@Autowired
	ServletContext app;
	
	public File save(MultipartFile file, String folder) {
		String s = System.currentTimeMillis()+file.getOriginalFilename();
		String name = Integer.toHexString(s.hashCode()) + s.substring(s.lastIndexOf("."));
		Path path = this.getPath(folder, name);
		try {
			File savedFile = path.toFile();
			file.transferTo(savedFile);
			System.out.println("Path Image: "+savedFile.getAbsolutePath());
			return savedFile;
		}catch(Exception e) {
			System.out.println("Lỗi implement: "+e);
			throw new RuntimeException(e);
		}
	}
	private Path getPath(String folder, String filename) {
		File dir = Paths.get(app.getRealPath("/assests/"), folder).toFile();
		if (!dir.exists()) {
			dir.mkdirs();
		}
		return Paths.get(dir.getAbsolutePath(), filename);
	}

	


}

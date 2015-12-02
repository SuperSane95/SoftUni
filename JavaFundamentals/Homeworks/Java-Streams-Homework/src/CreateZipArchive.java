import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive {

	public static void main(String[] args)  {
		List<File> files = new ArrayList<File>();
		files.add(new File("res/Words.txt"));
		files.add(new File("res/Count-chars.txt"));
		files.add(new File("res/SumLines.txt"));
		List<ZipEntry> filesInZip = new ArrayList<ZipEntry>();
		filesInZip.add(new ZipEntry("Words.txt"));
		filesInZip.add(new ZipEntry("Count-chars.txt"));
		filesInZip.add(new ZipEntry("SumLines.txt"));
		int in;
		ZipOutputStream zos = null;
		
		try {
			zos = new ZipOutputStream(new FileOutputStream(new File("res/text-files.zip")));
		} catch (FileNotFoundException e1) {
			System.out.println("No such zip file");
		}
		
		
		String line;
		for(int i = 0; i<files.size(); i++) {
			try {
				FileInputStream fis = new FileInputStream(files.get(i));
				zos.putNextEntry(filesInZip.get(i));
				while((in = fis.read()) != -1) {
					zos.write(in);
				}
				zos.closeEntry();
			}
			catch (IOException e) {
				System.out.println("Missing file");
			}
		}
		try {
			zos.close();
		} catch (IOException e) {
			System.out.println("Cannot close zip file");
		}
	}

}

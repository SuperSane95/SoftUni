import java.io.*;

public class CopyJpgFile {

	public static void main(String[] args) {

		// От условието в задачата, изобщо си нямам идея за какво ние byte[]
		// buffer. Така или иначе си мисля, че
		// BufferedOutputStream първо пълни буфер и след като го напълни флъшва.
		int output;
		try (BufferedInputStream fis = new BufferedInputStream(new FileInputStream(new File("res/java.jpg")));
				BufferedOutputStream bos = new BufferedOutputStream(
						new FileOutputStream(new File("res/my-copied-picture.jpg")))) {
			while ((output = fis.read()) != -1) {
				bos.write(output);
			}
		} catch (IOException e) {
			System.out.println("File Error");

		}

	}

}

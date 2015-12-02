
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Chunk;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.Phrase;
//import com.itextpdf.text.pdf.BaseFont;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
// Закоментираните библеотеки са част, от тази която изтрих, защото не можех да кача архива
// в сайта на софтуни. Резултата от тази програма може да видите във файла DeckToPDF.pdf
public class DeckToPDF {

	public static void main(String[] args) throws IOException {
		String[] numbers = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
		char[] colors = { '♣', '♦', '♥', '♠' };
		// char[] colors = {'♧','♢','♡','♤'};
		printDeck(numbers, colors);
		printDeckToPdf(numbers, colors);
	}

	public static void printDeck(String[] numbers, char[] colors) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				System.out.print(numbers[j]);
				System.out.print(colors[i]);
			}
			System.out.println();
		}
	}

	public static void printDeckToPdf(String[] numbers, char[] colors) throws IOException {
		Document deckPdf = new Document();
		try {
			PdfWriter.getInstance(deckPdf, new FileOutputStream("DeckToPDF.pdf"));
			BaseFont base = BaseFont.createFont("/usr/share/fonts/truetype/msttcorefonts/Arial.ttf",
					BaseFont.IDENTITY_H, true);
			Font[] arial = { new Font(base, 17, 0, new BaseColor(0, 0, 0)),
					new Font(base, 17, 0, new BaseColor(255, 0, 0)) };

			deckPdf.open();

			PdfPTable table = new PdfPTable(4);
			table.setWidthPercentage(18);

			for (int i = 0; i < colors.length; i++) {
				for (int j = 0; j < numbers.length; j++) {
					if (colors[i] == '♣' || colors[i] == '♠') {
						table.addCell(new Paragraph(numbers[j] + " " + colors[i], arial[0]));
					} else // if(colors[i] == '♦' || colors[i] == '♥')
					{
						table.addCell(new Paragraph(colors[i] + " " + numbers[j], arial[1]));
					}
				}
			}
			deckPdf.add(table);
			deckPdf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

}

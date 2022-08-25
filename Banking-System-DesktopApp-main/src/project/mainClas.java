package project;

import javax.swing.SwingUtilities;
import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class mainClas {
	{
		System.out.println("loading program , please wait");
	}

	// creating the array of objects (each element contains name , balance , ID,
	// status).
	// Our Banking System can hold up to 1000 account.
	public static accountHandler[] accountArray = new accountHandler[1001];

	public static void main(String[] args) throws FileNotFoundException {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// this runs the GUI
				// i don't know why exactly i implemented the whole invoke later thing but some
				// guys said it helps with stability
				new GUI();
				// code that saves array to excel sheet .

			}
		});

		// By implementing the code that reads data from excel sheet.
		try {
			// Please enter the url of the excel file (xlsx).
			File file = new File("ExcelTest.xlsx");
			// creating a new file instance
			FileInputStream fis = new FileInputStream(file);
			// creating Workbook instance that refers to .xlsx file
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);

			// By using arrays to store excel data.
			int cellNumber = 6;
			Row rowArray[] = new Row[3];
			Cell nameArray[] = new Cell[cellNumber];
			String nameArrayMod[] = new String[cellNumber];
			Cell balanceArray[] = new Cell[cellNumber];
			double balanceArrayMod[] = new double[cellNumber];
			Cell idArray[] = new Cell[cellNumber];
			int idArrayMod[] = new int[cellNumber];
			// Storing rows in rowArray.
			for (int i = 0; i < 3; i++) {
				rowArray[i] = sheet.getRow(i);
			}
			// Storing names in nameArray.
			for (int i = 0; i < cellNumber; i++) {
				nameArray[i] = rowArray[0].getCell(i + 1);
			}
			for (int i = 0; i < cellNumber; i++) {
				nameArrayMod[i] = nameArray[i].toString();
			}
			// for(int i=0;i<cellNumber;i++){ System.out.println(nameArrayMod[i]); }
			// Storing balances in balanceArray.
			for (int i = 0; i < cellNumber; i++) {
				balanceArray[i] = rowArray[1].getCell(i + 1);
			}
			for (int i = 0; i < cellNumber; i++) {
				balanceArrayMod[i] = Double.parseDouble(balanceArray[i].toString());
			}
			// for(int i=0;i<cellNumber;i++){ System.out.println(balanceArrayMod[i]); }
			// Storing IDs in idArray.
			for (int i = 0; i < cellNumber; i++) {
				idArray[i] = rowArray[2].getCell(i + 1);
			}
			for (int i = 0; i < cellNumber; i++) {
				idArrayMod[i] = (int) Double.parseDouble(idArray[i].toString());
			}
			// for(int i=0;i<cellNumber;i++){ System.out.println(idArrayMod[i]); }
			// Storing data in accountArray.
			for (int i = 0; i < cellNumber; i++) {
				accountArray[idArrayMod[i]] = new accountHandler(nameArrayMod[i], balanceArrayMod[i], idArrayMod[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

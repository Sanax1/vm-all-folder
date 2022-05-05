package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Baseclassexcel {
	public static Workbook book;
	public static Sheet sh;
	public static File f;

	public static Workbook xlworkbook(String filenameinexcelfolder) throws IOException {

	f = new File("excel\\" + filenameinexcelfolder + ".xlsx");

		FileInputStream fin = new FileInputStream(f);

		book = new XSSFWorkbook(fin);
		return book;
	}

	public static Sheet xlsheet(int index) {

		sh = book.getSheetAt(index);
		return sh;
	}

	public static void xlwritenewcell(String path, int sheetindex, String cellvalue) throws IOException {
		File f = new File(path);

		FileInputStream fin = new FileInputStream(f);

		Workbook book = new XSSFWorkbook(fin);

		Sheet sh = book.getSheetAt(sheetindex);

		int newrow = sh.getLastRowNum() + 1;

		Row createRow = sh.createRow(newrow);

		createRow.createCell(0).setCellValue(cellvalue);

		FileOutputStream fo = new FileOutputStream(f);
		book.write(fo);
		System.out.println("new value is updated excel sheet");
	}

	public static void xlwrite() throws IOException {
		FileOutputStream fo = new FileOutputStream(f);
		book.write(fo);
	}

	static Scanner s;

	public static void callscanner() {
		s = new Scanner(System.in);
	}

	public static String callgetstringfromuser() {

		String nextLine = s.nextLine();
		return nextLine;
	}

	public static String XLreadFromExcel(String path, int sheetindex, int row, int cell) throws IOException {
		File file = new File(path);
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet s = workbook.getSheetAt(sheetindex);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		int type = c.getCellType();
		String name;
		if (type == 1) {
			name = c.getStringCellValue();
		} else if (DateUtil.isCellInternalDateFormatted(c)) {
			java.util.Date date = c.getDateCellValue();
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			name = format.format(date);
		} else {
			double d = c.getNumericCellValue();
			long l = (long) d;
			name = String.valueOf(l);
		}
		return name;

	}

	public static void xlnewrow(int numberofrow, int numberofcell) {

		for (int j = 0; j < numberofrow; j++) {

			int newrow = sh.getLastRowNum() + 1;

			Row createRow = sh.createRow(newrow);
			callscanner();
			for (int i = 0; i < numberofcell; i++) {

				String s = callgetstringfromuser();
				createRow.createCell(i).setCellValue(s);

			}

		}
	}

}

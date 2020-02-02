/**
 * @author Administrator
 *
 */
package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils{
	
	public static String getCellValueToString(XSSFCell cell) {
		String value = null;
		if (cell == null) {
			return value;
		}
		CellType cellType = cell.getCellType();
		if (cellType == CellType.STRING) {
			return cell.getStringCellValue();
		} else {
			cell.setCellType(CellType.STRING);
			return cell.getStringCellValue();
		}
	}
	
	//start
	public static List<Map<String, String>> getListContainsMap(XSSFSheet sheet) {
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map = null;
		if (sheet == null) {
			return list;
		}
		int lastRowNum = sheet.getLastRowNum();
//		当lastRowNum 为 0时，他表示sheet中最多有一行内容
//		起码有一行存在
		XSSFRow firstRow = sheet.getRow(0);
		if (firstRow == null) {
			return list;
		}
		short firstRowCellNum = firstRow.getLastCellNum();
		System.out.println("sheet " + sheet.getSheetName() + " 中最大的行数为： " + lastRowNum);
		System.out.println("第一行最大的单元格数： " + firstRowCellNum);
//		最大行数，决定了List要增加多少次Map,Map是放置每一行的（k,v），这里面的K是第一行的对应单元格的值
		int count = 0;
		zr: for (int y = 1; y <= lastRowNum; y++) {
			map = new LinkedHashMap<>();
//			内层循环代表行循环
			for (short x = 0; x < firstRowCellNum; x++) {
				count++;
				XSSFCell cell = firstRow.getCell(x);
				String firstRowCellKey = getCellValueToString(cell);
				XSSFRow tempRow = sheet.getRow(y);
//				continue,终止本次循环，进行下一次循环
				if (tempRow == null) {
					continue zr;
				}
				XSSFCell tempCell = tempRow.getCell(x);
				String yRowCellValue = getCellValueToString(tempCell);
				map.put(firstRowCellKey, yRowCellValue);
			}
			list.add(map);
		}
		System.out.println("总共循环次数 ：" + count);
		return list;
	}
	
	//start
	public static LinkedHashMap<String,List<Map<String, String>>> getMapContainsAllList(String filePath) {
		LinkedHashMap<String,List<Map<String, String>>> lhmap = new LinkedHashMap<>();
		if(filePath == null)  {
			return lhmap;
		}
		filePath = filePath.trim();
		if(filePath.length() <6) {
			return lhmap;
		}
		if(!filePath.endsWith(".xlsx")) {
			return lhmap;
		}
		File file = new File(filePath);
		if(!file.exists()) {
			return lhmap ;
		}
		if(!file.isFile()) {
			return lhmap ;
		}
		XSSFWorkbook wk = null;
		try {
			wk = new XSSFWorkbook(file);
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		if(wk == null) {
			return lhmap ;
		}
		int numberOfSheets = wk.getNumberOfSheets();
		for(int x = 0 ; x < numberOfSheets ; x++) {
			XSSFSheet sheet = wk.getSheetAt(x);
			String sheetName = sheet.getSheetName();
			List<Map<String, String>> listContainsMap = getListContainsMap(sheet);
			lhmap.put(sheetName, listContainsMap);
		}
		return lhmap;
	}
	
	
	public static String readXls_x(String filePath, String sheetName, int row, int column) {
		filePath = filePath.trim();
		sheetName = sheetName.trim();
		File file = new File(filePath);
		if ((!file.exists()) || (!file.isFile()) || (filePath.length() < 5)) {
			System.out.println("请检查文件");
			return null;
		}
		int len = filePath.length();
		String reciprocalThree = filePath.substring(len - 3, len);
		String reciprocalFour = filePath.substring(len - 4, len);
		if ((!"xls".equalsIgnoreCase(reciprocalThree)) && (!"xlsx".equalsIgnoreCase(reciprocalFour))) {
			System.out.println("请检查文件类别");
			return null;
		}
		Sheet sh_x = null;
		Workbook wb = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			if ("xls".equalsIgnoreCase(reciprocalThree)) {
				wb = new HSSFWorkbook(fis);
			}
			if ("xlsx".equalsIgnoreCase(reciprocalFour)) {
				wb = new XSSFWorkbook(fis);
			}
			sh_x = wb.getSheet(sheetName);
			int lastRowNum = sh_x.getLastRowNum();
			if (row > 0 && row <= (lastRowNum +1)) {
				 Row sh_xRow = sh_x.getRow(row - 1);
				 short lastCellNum = sh_xRow.getLastCellNum();
				if (column > 0 && column <= lastCellNum) {
					Cell cell = sh_xRow.getCell(column-1);
					cell.setCellType(CellType.STRING);
					return cell.getStringCellValue();
				}
				return null;
			} else {
				return null;
			}
		} catch (Exception e) {
			String str1 = e.getMessage();
			return str1;
		} finally {
			try {
				if(fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("deprecation")
	public static boolean writeXls_x(String filePath, String sheetName, String src, int row, int column) {
		filePath = filePath.trim();
		sheetName = sheetName.trim();
		File file = new File(filePath);
		if ((!file.exists()) || (!file.isFile()) || (filePath.length() < 5)) {
			return false;
		}
		int len = filePath.length();
		String reciprocalThree = filePath.substring(len - 3, len);
		String reciprocalFour = filePath.substring(len - 4, len);
		if ((!"xls".equalsIgnoreCase(reciprocalThree)) && (!"xlsx".equalsIgnoreCase(reciprocalFour))) {
			return false;
		}
		Sheet sh_x = null;
		Workbook wb = null;
		FileOutputStream fout = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			if ("xls".equalsIgnoreCase(reciprocalThree)) {
				wb = new HSSFWorkbook(fis);
			}
			if ("xlsx".equalsIgnoreCase(reciprocalFour)) {
				wb = new XSSFWorkbook(fis);
			}

			sh_x = wb.getSheet(sheetName);
			if ((row > 0) && (column > 0) && (sh_x != null)) {
				row--;
				column--;
				Row xssfRow = sh_x.getRow(row);
				if (xssfRow == null) {
					xssfRow = sh_x.createRow(row);
				}
				Cell xssfCell = xssfRow.getCell(column);
				if (xssfCell == null) {
					xssfCell = xssfRow.createCell(column);
				}
				xssfCell.setCellType(CellType.STRING);
				xssfCell.setCellValue(src);
				fout = new FileOutputStream(file);
				wb.write(fout);
				fout.close();
				return true;
			}
			System.out.println("请检查sheet表名，以及行和列是否有效！");
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
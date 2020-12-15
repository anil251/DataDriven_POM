package co.DataDriven.POM.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	private String filepath;
	private FileInputStream fileInputStream;
	private Workbook workbook=null;
	private Sheet sheet=null;
	private Row row=null;
	private String CellValue;
	private Cell cell=null;
	private String value;
	
	public  ExcelReader(String filepath) throws EncryptedDocumentException, IOException
	{
		this.filepath=filepath;
		fileInputStream=new FileInputStream(filepath);
		 workbook = WorkbookFactory.create(fileInputStream);
		Optional<Workbook> optional=Optional.ofNullable(workbook);
		if (optional.isPresent()) {
			
			System.out.println("Work Book is Available");
		}
		else {
			//throw Exception
		}
		 
	
	}
public Sheet getsheet(String how,String value)	{
		
		if (how.equalsIgnoreCase("name")) {	
			sheet=workbook.getSheet(value);
		}
		else if (how.equalsIgnoreCase("index")) {
			int index=Integer.parseInt(value);
			sheet=workbook.getSheetAt(index);
		}
		else {
			System.out.println("Pass The Correct parameter");
			//throw Exception
		}
		return sheet;	
		}
	
	public int getToalNoofRows(String sheetName) {
		sheet=getsheet("name", sheetName);
		int rows=sheet.getLastRowNum();
		return rows;
	}
	public int getToalNoofcoloms(String sheetName,int rowNum) {
		sheet=getsheet("name", sheetName);
		row=sheet.getRow(rowNum);
		int cells = row.getLastCellNum();
		return cells;
	}
	
	//Get A Single data
	public String getSingleCelldata(String sheetName,int rowNum,int cellNum) {
		sheet=getsheet("name", sheetName);
		row=sheet.getRow(rowNum);
		cell=row.getCell(cellNum);
		
		if (cell.getCellType()==CellType.NUMERIC){
			value=cell.getNumericCellValue()+"";
			System.out.println(value);	
		}
		else if (cell.getCellType()==CellType.STRING){
			value=cell.getStringCellValue();
			System.out.println(value);		
		}
		else if (cell.getCellType()==CellType.BOOLEAN){
			value=cell.getBooleanCellValue()+"";
			System.out.println(value);			
		}
		return value;
	}
	
	//Get Single Row Data
	
	public List<String> getSingleRowData(String sheetName,int rowNum) {
		List<String> data= new ArrayList<String>();
	   sheet= getsheet("name", sheetName);
	   Row row =sheet.getRow(rowNum);
	   int cellCount=row.getLastCellNum();
	   for (int i = 0; i <cellCount; i++) {
		  cell= row.getCell(i);
		  if (cell.getCellType()==CellType.NUMERIC){
				value=cell.getNumericCellValue()+"";
				data.add(value);
				//System.out.println(value);	
			}
			else if (cell.getCellType()==CellType.STRING){
				value=cell.getStringCellValue();
				data.add(value);
				//System.out.println(value);		
			}
			else if (cell.getCellType()==CellType.BOOLEAN){
				value=cell.getBooleanCellValue()+"";
				data.add(value);
				//System.out.println(value);		
				
			}
		
    	}
	   return data;
		
	}
	
	//Get All Data
	public List<String> getTotalsheetdata(String sheetName) {
		
		List<String> data=new ArrayList<String>();
		sheet= getsheet("name", sheetName);		
		for (int i = 0; i < sheet.getLastRowNum(); i++)
		{			
			Row row=sheet.getRow(i);
			
			for (int j = 0; j < row.getLastCellNum(); j++)
			{				
				Cell cell= row.getCell(j);
				if (cell.getCellType()==CellType.NUMERIC) 
				{
					CellValue=cell.getNumericCellValue()+"";
			     			
				}
				else if (cell.getCellType()==CellType.STRING)
				{
					CellValue=cell.getStringCellValue();
										
				}
				else if (cell.getCellType()==CellType.BOOLEAN)
				{
					CellValue=cell.getBooleanCellValue()+"";
					
				}
				
				
			}
			
		}
			
	
		return data;
	}
	private void data(double numericCellValue) {
		// TODO Auto-generated method stub
		
	}
	

}

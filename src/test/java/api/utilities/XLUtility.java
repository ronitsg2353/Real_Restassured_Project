package api.utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class XLUtility {
    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;
    String path;

    public  XLUtility(String path){
        this.path=path;
    }


    public int getRowCount(String sheetName) throws IOException
    {
        fi=new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);
        sheet=workbook.getSheet(sheetName);
        int rowcount=sheet.getLastRowNum();
        workbook.close();
        fi.close();
        return rowcount;
    }


    public int getCellCount(String sheetName,int rownum) throws IOException
    {
        fi=new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);
        sheet=workbook.getSheet(sheetName);
        row=sheet.getRow(rownum);
        int cellcount=row.getLastCellNum();
        workbook.close();
        fi.close();
        return cellcount;
    }


    public String getCellData(String sheetName,int rownum,int colnum) throws IOException
    {
        fi=new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);
        sheet=workbook.getSheet(sheetName);
        row=sheet.getRow(rownum);
        cell=row.getCell(colnum);

        DataFormatter formatter=new DataFormatter();
        String data;
        try
        {
           data = formatter.formatCellValue(cell);
            return data;
        }
        catch (Exception e)
        {
            data="";
        }
        workbook.close();
        fi.close();
        return data;
    }

    public  void setCellData(String sheetName,int rownum,int colnum,String data) throws IOException
    {
        File file=new File(path);
        if(!file.exists()){
            workbook =new XSSFWorkbook();
            fo=new FileOutputStream(path);
            workbook.write(fo);

        }
        fi=new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);

        if(workbook.getSheetIndex(sheetName)==-1){
            workbook.createSheet(sheetName);
            sheet=workbook.getSheet(sheetName);
        }
        if(sheet.getRow(rownum)==null){
            sheet.createRow(rownum);
            row=sheet.getRow(rownum);
        }

    }

}

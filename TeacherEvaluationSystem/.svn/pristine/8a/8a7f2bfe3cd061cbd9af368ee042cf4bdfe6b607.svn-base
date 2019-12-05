package ssm.entity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUntil {
	/**
	 * 根据输入流生成实体集合
	 * 
	 * @param is
	 * @author Changhai
	 * @data 2017-7-5
	 * @return
	 * @throws IOException
	 * @throws org.apache.poi.openxml4j.exceptions.InvalidFormatException
	 */
    public static List<Map<String,String>> getList(InputStream is){
    	try{
    		//List<List<String>> list = readExcel(is);
            
            //-----------------------遍历数据到实体集合开始-----------------------------------
            List<Map<String,String>> listBean = new ArrayList<>();
           
            
            //----------------------------遍历数据到实体集合结束----------------------------------
            return listBean;
    	}catch(Exception ex){
    		return null;
    	}
        
    }

    /**
     * Excel读取 操作
     * @throws org.apache.poi.openxml4j.exceptions.InvalidFormatException 
     */
    @SuppressWarnings("deprecation")
	public static List<List<String>> readExcel(InputStream is)throws IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
        Workbook wb = null;
        try {  
              wb = WorkbookFactory.create(is);        
            } catch (FileNotFoundException e) {  
              e.printStackTrace();  
            } catch (InvalidFormatException e) {  
              e.printStackTrace();  
            } catch (IOException e) {  
              e.printStackTrace();  
            }  

        /** 得到第一个sheet */
        Sheet sheet = wb.getSheetAt(0);
        /** 得到Excel的行数 */
        int totalRows = sheet.getPhysicalNumberOfRows();

        /** 得到Excel的列数 */
        int totalCells = 0;
        if (totalRows >= 1 && sheet.getRow(0) != null) {
            totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }

        List<List<String>> dataLst = new ArrayList<List<String>>();
        /** 循环Excel的行 ,有表头去除，r=1*/
        for (int r = 1; r < totalRows; r++) {
            Row row = sheet.getRow(r);
            if (row == null)
                continue;
            List<String> rowLst = new ArrayList<String>();
            /** 循环Excel的列 */
            for (int c = 0; c < totalCells; c++) {
                Cell cell = row.getCell(c);
                String cellValue = "";
                if (null != cell) {
                
                HSSFDataFormatter hSSFDataFormatter = new HSSFDataFormatter();
				cellValue= hSSFDataFormatter.formatCellValue(cell);
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_NUMERIC: // 数字
                    	DecimalFormat df = new DecimalFormat("0");  
                    	cellValue = df.format(cell.getNumericCellValue());  
                        break;
                    case Cell.CELL_TYPE_STRING: // 字符串
                        cellValue = cell.getStringCellValue();
                        break;
                    case Cell.CELL_TYPE_BOOLEAN: // Boolean
                        cellValue = cell.getBooleanCellValue() + "";
                        break;
                    case Cell.CELL_TYPE_FORMULA: // 公式
                        cellValue = cell.getCellFormula() + "";
                        break;
                    case Cell.CELL_TYPE_BLANK: // 空值
                        cellValue = "";
                        break;
                    case Cell.CELL_TYPE_ERROR: // 故障
                        cellValue = "非法字符";
                        break;
                    default:
                        cellValue = "未知类型";
                        break;
                    }
                }
                rowLst.add(cellValue);
            }
            /** 保存第r行的第c列 */
            dataLst.add(rowLst);
        }
       return dataLst;
    }
    
    /**
     * 导入教师数据
     * @param is
     * @return
     * @throws InvalidFormatException
     * @throws IOException
     */
    public static List<Teacher> readTeacherExcel(InputStream is) throws InvalidFormatException, IOException {
    	List<List<String>> list=readExcel(is);    	
    	List<Teacher> teachers=new ArrayList<>();//新建一个存放教师信息的列表
    	for(int i=0;i<list.size();i++) {
    		Teacher t=new Teacher();
    		List<String> strings=list.get(i);//取出第一层列表------表格的每一行数据
    		t.setTeacher_id(Integer.parseInt(strings.get(0)));
    		t.setTeacher_name(strings.get(1));
    		t.setTeacher_insid(Integer.parseInt(strings.get(2)));
    		t.setTeacher_subid(Integer.parseInt(strings.get(3)));
    		t.setPassword(strings.get(0));
    		t.setRole_id(1);
    		teachers.add(t);
    	}
    	return teachers;
    }
    
    public static List<Student> readStudentExcel(InputStream is) throws InvalidFormatException, IOException{
    	List<List<String>> list=readExcel(is);    	
    	List<Student> students=new ArrayList<>();//新建一个存放学生信息的列表
    	for(int i=0;i<list.size();i++) {
    		Student s=new Student();
    		List<String> strings=list.get(i);//取出第一层列表------表格的每一行数据
    		s.setStudent_id(Integer.parseInt(strings.get(0)));
    		s.setStudent_name(strings.get(1));
    		s.setStudent_ins(Integer.parseInt(strings.get(2)));
    		s.setStudent_classid(Integer.parseInt(strings.get(3)));
    		s.setPassword(strings.get(0));
    		s.setRole_id(2);
    		students.add(s);
    	}
    	return students;
    }
}

package rest;


import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import au.com.bytecode.opencsv.bean.CsvToBean;
import au.com.bytecode.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class OpenCSVParserExample {

	public static void main(String[] args) throws IOException {

		parseCSVToBeanList();
		
	}

	public static void parseCSVToBeanList() throws IOException {
		
		HeaderColumnNameTranslateMappingStrategy<Employee> beanStrategy = new HeaderColumnNameTranslateMappingStrategy<Employee>();
		beanStrategy.setType(Employee.class);
	
		Map<String, String> columnMapping = new HashMap<String, String>();
		columnMapping.put("ID", "id");
		columnMapping.put("Name", "name");
		columnMapping.put("Role", "role");
		columnMapping.put("Salary", "salary");
		
		beanStrategy.setColumnMapping(columnMapping);
		
		CsvToBean<Employee> csvToBean = new CsvToBean<Employee>();
		CSVReader reader = new CSVReader(new FileReader("C:\\Users\\samuel.samuel-andoh\\workspace\\eclipse_workspace\\CocumberTestApplication\\src\\test\\java\\rest\\employees.csv"));
		List<Employee> emps = csvToBean.parse(beanStrategy, reader);
		int ID = 0;
		System.out.println(emps.get(ID));
	}
	
	
	public static String  readAll(Employee employee ){
		String request =""
		
		+ ""+employee.getId()+""
		+""+employee.getName()+""
		+""+employee.getRole()+""
		+""+employee.getSalary()+"";
		return request;

	}

	

}
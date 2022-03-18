package com.samsungds.codereview.teamd.print;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.vo.Employee;

public class FilePrint {
	private BufferedWriter writer;
	
	public FilePrint(String path) throws IOException {
		writer = new BufferedWriter(new FileWriter(new File(path)));
	}
	
	public void print(String command, Collection<Employee> employees, Boolean printOptionEnable) throws IOException {
		if(employees.size() == 0) {
			writer.write(command + ',' + Constants.NO_DATA);	
		}
		else {
			if(printOptionEnable) {
				for(Employee employee : employees) {
					writer.write(command + ',' + employee.toInfoString());
					writer.newLine();
				}
			}
			else {
				writer.write(command + ',' + employees.size());
				writer.newLine();
			}
		}
		
		writer.close();
	}

}

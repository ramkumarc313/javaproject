package com.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class fileio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			FileReader f=new FileReader("ram1111.txt");
	        FileInputStream fin= new FileInputStream("D:/ram1.txt"); 
	         BufferedReader br=new BufferedReader(f);

		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

}

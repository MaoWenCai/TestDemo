package com.test;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
public class TestFile {
	@Test
	public void test(){
		String filePath="/2016823/海石季度丰基金-五牛尊筹基金合同.pdf";
		String fileName="海石季度丰基金-五牛尊筹基金合同.pdf";
        String newFilePath = filePath.replaceAll(fileName,"123.pdf");
        System.out.println(newFilePath);//   /2016823/123.pdf
	}
	@Test
	public void test2(){
		String filePath2="/2016823/2号-封面+空白页.pdf";
		String fileName="2号-封面+空白页.pdf";
        String newFilePath = filePath2.replaceAll(fileName,"123.pdf");
        System.out.println(newFilePath);//  /2016823/2号-封面+空白页.pdf
	}
	@Test
	public void test3(){
		String filePath3="/2016823/SK1072+银烁资产定增1期私募基金 合同定稿-清洁稿final已排版电子合同.pdf";
		String fileName="SK1072+银烁资产定增1期私募基金 合同定稿-清洁稿final已排版电子合同.pdf";
        String newFilePath = filePath3.replaceAll(fileName,"123.pdf");
        System.out.println(newFilePath);//  /2016823/SK1072+银烁资产定增1期私募基金 合同定稿-清洁稿final已排版电子合同.pdf
	}
	@Test
	public void test4(){
		String filePath3="/2016823/SK1072+银烁资产.pdf";
		String fileName="SK1072+银烁资产.pdf";
        String newFilePath = filePath3.replaceAll(fileName,"123.pdf");
        System.out.println(newFilePath);//  /2016823/SK1072+银烁资产.pdf
	}
	@Test
	public void test5(){
		String filePath3="/2016823/SK1072+银烁资产.pdf";
		String fileName="SK1072+银烁资产.pdf";
		 String newFilePath =null;
		if(fileName.contains("+")){
			filePath3 = filePath3.replaceAll("\\+","");
			fileName = fileName.replaceAll("\\+","");
		}
        newFilePath = filePath3.replaceAll(fileName,"123.pdf");
        System.out.println(newFilePath);//  /2016823/123.pdf
	}
	@Test
	public void test6(){
		String filePath3="/2016823/SK1072-银烁资产.pdf";
		String fileName="SK1072-银烁资产.pdf";
		 String newFilePath =null;
		if(fileName.contains("+")){
			filePath3 = filePath3.replaceAll("\\+","");
			fileName = fileName.replaceAll("\\+","");
		}
        newFilePath = filePath3.replaceAll(fileName,"4563.pdf");
        System.out.println(newFilePath);//  /2016823/4563.pdf
	}
	@Test
	public void test7(){
		 File f = null;
	      File f1 = null;
	      boolean bool = false;
	      
	      try{      
	         // create new File objects
	         f = new File("C:/testABC666.txt");
	         f1 = new File("D:/test777.txt");
	         
	         // rename file
	         bool = f.renameTo(f1);//会把c盘文件剪切到d盘
	         // print
	         System.out.print("File renamed? "+bool);
	      }catch(Exception e){
	         // if any error occurs
	         e.printStackTrace();
	      }
	}
	@Test
	public void test8(){
		 File f = null;
	      File f1 = null;
	      boolean bool = false;
	      
	      try{      
	         // create new File objects
	         f = new File("C:/testABC666.txt");
	         f1 = new File("D:/test777.txt");
	         
	         // rename file
	         //bool = f.renameTo(f1);//会把c盘文件剪切到d盘
	         // print
	         //System.out.print("File renamed? "+bool);
	         FileUtils.copyFile(f,f1);//如果有直接替换
	      }catch(Exception e){
	         // if any error occurs
	         e.printStackTrace();
	      }
	}
	@Test
	public void test9(){
		 File f = null;
	      File f1 = null;
	      File f2 = null;
	      boolean bool = false;
	      
	      try{      
	         // create new File objects
	         //f = new File("C:/testABC666.txt");
	         //f1 = new File("D:/test777.txt");
	         f = new File("C:/a/b/c");
	         
	         // rename file
	         //bool = f.renameTo(f1);//会把c盘文件剪切到d盘
	         // print
	         //System.out.print("File renamed? "+bool);
	      // 判断目录或文件是否存在  
	         if (!f.exists()) {  // 不存在返回 false  
	            System.out.println("不存在...");
	         } else {  
	             // 判断是否为文件  
	             if (f.isFile()) {  // 为文件时调用删除文件方法  
	                f.delete();  
	             } else {  //为目录时调用删除目录方法  
	                 FileUtils.deleteDirectory(f);  
	             }  
	         }  
	      }catch(Exception e){
	         // if any error occurs
	         e.printStackTrace();
	      }
	}
}

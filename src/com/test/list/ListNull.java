package com.test.list;
import java.util.List;
import org.junit.Test;
public class ListNull {
	@Test
	public void test(){
		List ls=null;
		for(int i=0;i<ls.size();i++){
			System.out.println("aaa");
		}
	}
}

package com.test.digui;

/** 
 * 我想实现的功能是： 
 * struts2的拦截器实现的思想 
 * 事情1 事情2 事情3 处理  事情1release 事情2 release 事情3 release 
 *  
 * @author 追本溯源 
 * 
 */  
public class DiGuiTest {
    private int index = 0;  
    private String[] things = new String[]{"事情1","事情2","事情3"};  
    /** 首先用我熟悉的纵向递归实现**/  
    public void fun(String receiver){  
        if(receiver!=null){  
            try{  
                //该事件的一些处理  
                dealFunBegin(receiver);  
                fun(things[index++]);  
                  
            }catch(ArrayIndexOutOfBoundsException e){  
                fun(null);  
            }  
            invokeThings();  
            dealFunEnd(receiver);  
        }  
    }  
    
    //ivokeThings处理之前的的一系列处理  
    public void dealFunBegin(String receiver){  
        System.out.println(receiver+"事件开始处理");  
    }  
    
    public void invokeThings(){  
        System.out.println("中间主要的操作");  
    }  
    
    //invokeThings处理之后的一系列处理  
    public void dealFunEnd(String receiver){  
        System.out.println(receiver+"事情处理完毕");  
    }  
    
    public static void main(String[] args) {  
    	DiGuiTest sct = new DiGuiTest();  
    	
        sct.fun("开始事情处理");  
    }  
}
/*
 结果  
开始事情处理事件开始处理  
事情1事件开始处理  
事情2事件开始处理  
事情3事件开始处理  
中间主要的操作  
事情3事情处理完毕  
中间主要的操作  
事情2事情处理完毕  
中间主要的操作  
事情1事情处理完毕  
中间主要的操作  
开始事情处理事情处理完毕  
发现所谓的纵向递归不能实现上面的功能   
  
 * */

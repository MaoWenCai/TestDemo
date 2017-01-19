package com.test;

/**
 * 虽然是个小错误，不过我也要逐渐成为一名正式的程序员了，所以，在这里记录下我每天的收获。
新拿到老师交给我的库，里面繁多的文件确实让人崩溃。不过在使用的过程中逐渐知道了各个文件夹乃至文件名都是有意义的。
如题所示的错误，
需要在eclipse中添加jar包，点击project->Properties->Java Build Path，看到带着叉的jar包，
就是说需要这个包文件但是在指定路径下找不到这个文件。那么可以双击这它，找到库里面对应的jar包，就可以了。
之前apache相关的jar包也没有，我还到网上下载了一个进行“Add External JARs”，
这会子发现老师给我的库文件里面是有这个包的……幸福来得太突然的感觉~
 * @author maowc
 * 2016年12月8日
 */
public class TestContains {
	public static void main(String[] args) {
		String str1="abcdef";
		String tmp="cd";
		boolean a = str1.contains(tmp);
		System.out.println(a);
	}
}

package com;
/**
* @author 庄贵东 
* @version 创建时间：2016年10月18日 下午10:42:48 
*/
public class Student {
	String name = "覃雪青";		//姓名
	int age = 18;				//年龄
	String clas = "计算机1502班";	//班级
	String school = "河北工程大学";	//学校
	int totalScore = 944;		//成绩
	int subjectNamber = 16;		//科目数量
	
	//自我介绍
	public void selfIntroduction() {
		System.out.println("我的名字是" + name + ",今年" + age + "岁.");
		System.out.println("现在就读于" + school + clas + ".");
	}
	//输出考试平均分
	public void printAverage() {
		System.out.println(name + "的平均分为" + totalScore/subjectNamber + "分.");
	}
	
	//主方法
	public static void main(String[] args) {
		Student stu1 = new Student();
		stu1.selfIntroduction();
		stu1.printAverage();
	}
}

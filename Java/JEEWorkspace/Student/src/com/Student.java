package com;
/**
* @author ׯ�� 
* @version ����ʱ�䣺2016��10��18�� ����10:42:48 
*/
public class Student {
	String name = "��ѩ��";		//����
	int age = 18;				//����
	String clas = "�����1502��";	//�༶
	String school = "�ӱ����̴�ѧ";	//ѧУ
	int totalScore = 944;		//�ɼ�
	int subjectNamber = 16;		//��Ŀ����
	
	//���ҽ���
	public void selfIntroduction() {
		System.out.println("�ҵ�������" + name + ",����" + age + "��.");
		System.out.println("���ھͶ���" + school + clas + ".");
	}
	//�������ƽ����
	public void printAverage() {
		System.out.println(name + "��ƽ����Ϊ" + totalScore/subjectNamber + "��.");
	}
	
	//������
	public static void main(String[] args) {
		Student stu1 = new Student();
		stu1.selfIntroduction();
		stu1.printAverage();
	}
}

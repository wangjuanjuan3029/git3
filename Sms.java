package com.briup.ch12;
import java.util.Scanner;

public class Sms {
	private Student[] stus = new Student[3];
	private int index=0;
	//�������
	public static void main(String[] args){
		Sms sms =new Sms();
		sms.menu();
		Scanner scanner = new Scanner(System.in);

		while(true){

			System.out.print("�����빦�ܱ��");
  			String option = scanner.nextLine();
			switch(option){
		
				case "1": //��ѯ����ѧ����Ϣ
				System.out.println("����Ϊ����ѧ������Ϣ��");
				Student[] stus=sms.findAll();
				for(int i=0;i<stus.length;i++){
					System.out.println(stus[i]);
				}
				System.out.println("�ܼ�"+sms.index+"��");

					break;
				case "2":
					while(true){
						System.out.println("������ѧ����Ϣ��id#name#age����������break������һ��Ŀ¼");

						String stuStr =scanner.nextLine();
						if(stuStr.equals("break")){
							break;
						}
						String[] stuArr=stuStr.split("#");
						long id = Long.parseLong(stuArr[0]);
						String name = stuArr[1];
						int age = Integer.parseInt(stuArr[2]);
						Student stu = new Student(id,name,age);
						sms.save(stu);
						System.out.println("��ӳɹ�");
					}
					break;
				case "3":
					while(true){
						System.out.println("������Ҫɾ��ѧ����id������break������һ��Ŀ¼");
						String idStr = scanner.nextLine();
						if(idStr.equals("break")){
							break;
						} 
						long id = Long.parseLong(idStr);
						Student stu = sms.findById(id);
						if(stu==null){
							System.out.println("��Ҫɾ���Ķ�ѧ��������");
							continue;
						}
						sms.deleteById(id);
						System.out.println("ɾ���ɹ�");
					}
					break;
				case "4":
					while(true){
						System.out.println("������Ҫ�޸ĵ�ѧ��id������break������һ��Ŀ¼");
						
						String idStr = scanner.nextLine();
						if(idStr.equals("break")){
							break;
						}
						long id = Long.parseLong(idStr);
						Student stu = sms.findById(id);
						if(stu == null){
							System.out.println("��Ҫ�޸ĵ�ѧ����Ϣ�����ڣ�");
							continue;
						}
						System.out.println("ԭ����"+stu);
						System.out.println("�������޸ĺ����Ϣ��name#age");

						String stuStr=scanner.nextLine();

						String[] arr = stuStr.split("#");
						String name = arr[0];
						int age = Integer.parseInt(arr[1]);

						Student newStu = new Student(id,name,age);
						sms.update(newStu);
						System.out.println("�޸ĳɹ�");
						

					}
					break;
				case "5":
					while(true){
							System.out.println("������Ҫ��ѯѧ����id������break������һ��Ŀ¼");

							String idStr = scanner.nextLine();
							if(idStr.equals("break")){
								break;
							}
							
							long id = Long.parseLong(idStr);
							Student stu = sms.findById(id);
							System.out.println(stu==null? "sorry not found ": stu);
							

					}
					break;
				case "exit":
					System.exit(0);
					System.out.println("��ӭ�´�ʹ��ϵͳ��");
					break;
				case "help":
					sms.menu();
					break;
				default:
					System.out.println("�����������������");

					
			}
		}

	}
	//�˵�
	public void menu(){
		System.out.println("**********ѧ����Ϣ����ϵͳ**********");
		System.out.println("***1.��ѯ����ѧ����Ϣ");
		System.out.println("***2.���ѧ����Ϣ");
		System.out.println("***3.ɾ��ѧ����Ϣ");
		System.out.println("***4.�޸�ѧ����Ϣ");
		System.out.println("***5.����ѧ�Ų�ѯѧ����Ϣ");
		System.out.println("***exit.�˳�ϵͳ");
		System.out.println("***help.����");
		System.out.println("************************************");
	}
	//����ѧ����Ϣ
	public void save(Student stu){
		if(index>=stus.length){
			Student[] Demo = new Student[stus.length+5];
			System.arraycopy(stus,0,Demo,0,index);
			stus = Demo;
		}
		stus[index++]=stu;
	}
	//ɾ��ѧ����Ϣ
	public void deleteById(long id){
		//��ȡ��id�����������
		int num = findIndexById(id);
		for(int i=num;i<index-1;i++){
			stus[i]=stus[i+1];

		}
		stus[--index]=null;
		
	}
	//��ѯ
	public Student findById(long id){
		int num = findIndexById(id);
		return num==-1 ? null : stus[num];
	}

	private int findIndexById(long id){
		int num = -1;
		for(int i=0;i<index;i++){
			if(id==stus[i].getId()){
				num=i;
				break;
			}
		}
		return num;
	}
	//��ѯ����
	public Student[] findAll(){
		//���鿽��
		Student[] stusDemo = new Student[index];
        System.arraycopy(stus,0,stusDemo,0,index);
		return stusDemo;
		
	}
	//�޸�
	public void update(Student stu){
		for(int i =0;i<index;i++){
		
			if(stu.getId()==stus[i].getId()){
				stus[i].setName(stu.getName());
				stus[i].setAge(stu.getAge());
			}
		}
	
	}

}

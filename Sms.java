package com.briup.ch12;
import java.util.Scanner;

public class Sms {
	private Student[] stus = new Student[3];
	private int index=0;
	//程序入口
	public static void main(String[] args){
		Sms sms =new Sms();
		sms.menu();
		Scanner scanner = new Scanner(System.in);

		while(true){

			System.out.print("请输入功能编号");
  			String option = scanner.nextLine();
			switch(option){
		
				case "1": //查询所有学生信息
				System.out.println("以下为所有学生的信息：");
				Student[] stus=sms.findAll();
				for(int i=0;i<stus.length;i++){
					System.out.println(stus[i]);
				}
				System.out.println("总计"+sms.index+"个");

					break;
				case "2":
					while(true){
						System.out.println("请输入学生信息【id#name#age】或者输入break返回上一级目录");

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
						System.out.println("添加成功");
					}
					break;
				case "3":
					while(true){
						System.out.println("请输入要删除学生的id或输入break返回上一级目录");
						String idStr = scanner.nextLine();
						if(idStr.equals("break")){
							break;
						} 
						long id = Long.parseLong(idStr);
						Student stu = sms.findById(id);
						if(stu==null){
							System.out.println("您要删除的而学生不存在");
							continue;
						}
						sms.deleteById(id);
						System.out.println("删除成功");
					}
					break;
				case "4":
					while(true){
						System.out.println("请输入要修改的学生id或输入break返回上一级目录");
						
						String idStr = scanner.nextLine();
						if(idStr.equals("break")){
							break;
						}
						long id = Long.parseLong(idStr);
						Student stu = sms.findById(id);
						if(stu == null){
							System.out.println("您要修改的学生信息不存在！");
							continue;
						}
						System.out.println("原来："+stu);
						System.out.println("请输入修改后的信息【name#age");

						String stuStr=scanner.nextLine();

						String[] arr = stuStr.split("#");
						String name = arr[0];
						int age = Integer.parseInt(arr[1]);

						Student newStu = new Student(id,name,age);
						sms.update(newStu);
						System.out.println("修改成功");
						

					}
					break;
				case "5":
					while(true){
							System.out.println("请输入要查询学生的id或输入break返回上一级目录");

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
					System.out.println("欢迎下次使用系统！");
					break;
				case "help":
					sms.menu();
					break;
				default:
					System.out.println("输入出错！请重新输入");

					
			}
		}

	}
	//菜单
	public void menu(){
		System.out.println("**********学生信息管理系统**********");
		System.out.println("***1.查询所有学生信息");
		System.out.println("***2.添加学生信息");
		System.out.println("***3.删除学生信息");
		System.out.println("***4.修改学生信息");
		System.out.println("***5.根据学号查询学生信息");
		System.out.println("***exit.退出系统");
		System.out.println("***help.帮助");
		System.out.println("************************************");
	}
	//保存学生信息
	public void save(Student stu){
		if(index>=stus.length){
			Student[] Demo = new Student[stus.length+5];
			System.arraycopy(stus,0,Demo,0,index);
			stus = Demo;
		}
		stus[index++]=stu;
	}
	//删除学生信息
	public void deleteById(long id){
		//获取该id在数组的索引
		int num = findIndexById(id);
		for(int i=num;i<index-1;i++){
			stus[i]=stus[i+1];

		}
		stus[--index]=null;
		
	}
	//查询
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
	//查询所有
	public Student[] findAll(){
		//数组拷贝
		Student[] stusDemo = new Student[index];
        System.arraycopy(stus,0,stusDemo,0,index);
		return stusDemo;
		
	}
	//修改
	public void update(Student stu){
		for(int i =0;i<index;i++){
		
			if(stu.getId()==stus[i].getId()){
				stus[i].setName(stu.getName());
				stus[i].setAge(stu.getAge());
			}
		}
	
	}

}

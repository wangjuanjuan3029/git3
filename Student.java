package com.briup.ch12;

public class Student{

private long id;
private String name;
private int age;



public Student(){

}


public Student(long id,String name,int age){
	this.id = id;
	this.name = name;
	this.age = age;
}

public String toString(){
	return"student [name" + this.name+ ",id" +this.id+",age"+this.age;

}

public void setId (long id ){
	this.id = id ;
}
public long getId (){
	return this.id ;
}
public void setName (String name){
	this.name = name;
}
public String getName (){
	return this.name;
}
public void setAge(int age){
	this.age = age;
}
public int getAge(){
	return this.age;
}
/**
public void setId (long id)
	{this.id = id;}
public long getId ()
	{return this.id;}
public void setName(String name )
	{this.name = name;}
public String getName()
	{return this.name;}
public void setAge(int age)
	{this.age = age;}
public int getAge()
	{return this.age;}



/**public String toString(){
	return"this is a good boy" ;

}*/
/**
public String toString(){
	return"student [name" + this.name+ ",id" +this.id+",age"+this.age;

}

*/
}


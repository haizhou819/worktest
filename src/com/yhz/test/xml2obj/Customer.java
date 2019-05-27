package com.yhz.test.xml2obj;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement  
@XmlAccessorType(XmlAccessType.FIELD) 
public class Customer {
	
	@XmlElementWrapper(name="email-addresses")
	@XmlElement(name="email-address")
	private List<String> emailAddresses; 
	
	@XmlElementWrapper(name="email-addresses")
	@XmlElement(name="colors")
	private List<String> colors;

	@XmlElement(name="age")
	private String age;
	
	@XmlElement(name="A")
	private A a;
	
	@XmlElement(name="B")
	private B b;
	
	@XmlAttribute(name="height")
	private String height;
	
	
    public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public List<String> getColors() {
		return colors;
	}

	public void setColors(List<String> colors) {
		this.colors = colors;
	}

	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}

	public A getA() {
		return a;
	}

	public void setA(A a) {
		this.a = a;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Customer() {  
        emailAddresses = new ArrayList<String>();  
        colors = new ArrayList<String>();
    }  
   
    public List<String> getEmailAddresses() {  
        return emailAddresses;  
    }  
   
    public void setEmailAddresses(List<String> emailAddresses) {  
        this.emailAddresses = emailAddresses;  
    } 
}

@XmlRootElement (name="a") 
@XmlAccessorType(XmlAccessType.FIELD)
class A{
	public int id;
	public String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

@XmlRootElement (name="a") 
@XmlAccessorType(XmlAccessType.FIELD)
class B{
	public int id;
	public String color;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}

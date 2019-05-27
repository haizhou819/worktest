package com.yhz.test.xml2obj;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Demo {
	public static void main(String[] args) throws Exception {  
        JAXBContext jc = JAXBContext.newInstance(Customer.class);  
   
        Customer customer = new Customer();  
        customer.getEmailAddresses().add("janed@example.com");  
        customer.getEmailAddresses().add("jdoe@example.org");
        customer.setAge("16");
        customer.getColors().add("grey");
        customer.getColors().add("red");
        customer.setHeight("12");
        
        A a = new A();
        a.setId(13);
        a.setName("jeery");
        customer.setA(a);
        
        B b = new B();
        b.setColor("red");
        b.setId(19);
        customer.setB(b);
   
        Marshaller marshaller = jc.createMarshaller();  
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
        marshaller.marshal(customer, System.out);  
        
        
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
        			+"<customer>"
        				+"<email-addresses>"
        					+"<email-address>janed@example.com</email-address>"
        					+"<email-address>jdoe@example.org</email-address>"
        					+" </email-addresses>"
        				+" <age height='12'>16</age>"
        				+" <B>"
    					+"   <id>19</id>"
    					+"   <color>red</color>"
    				+"   </B>"
        				+" <A>"
        					+"  <id>13</id>"
        					+"  <name>jeery</name>"
        				+" </A>"
        				
        			+"</customer>";
        Unmarshaller u = jc.createUnmarshaller(); 
        InputStream in = new ByteArrayInputStream(xml.getBytes());
        Customer cust = (Customer)u.unmarshal(in);
        System.out.println(cust.getAge()+"---"+cust.getB().getColor());
        
        
        
        String str = "hello world!";
        String str1 = str.substring(2);
        System.out.println(str1);
        		
    } 
}

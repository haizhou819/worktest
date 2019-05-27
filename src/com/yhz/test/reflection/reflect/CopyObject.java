package com.yhz.test.reflection.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CopyObject {
	public Object copyObject(Object object) throws Exception {
		 
        // 1.获取待操作类的一个Class对象
        Class<?> classType = object.getClass();
 
        // 2.获取待操作类的一个实例
        Constructor<?> constructor = classType
                .getConstructor(new Class<?>[] {});
        Object copyObj = constructor.newInstance(new Object[] {});
 
        // 3.获取被拷贝类的成员变量
        Field[] fields = classType.getDeclaredFields();
 
        for (Field field : fields) {
            // 4.遍历数组获取各个成员变量名字
            String name = field.getName();// 获取成员变量名字；
            
 
            // 5.操作字符串获取成员变量的set和get方法名字；
            String firstLetter = name.substring(0, 1).toUpperCase();
            String getMethodName = "get" + firstLetter + name.substring(1);
            String setMethodName = "set" + firstLetter + name.substring(1);
 
            Method getMethod = classType.getMethod(getMethodName,
                    new Class<?>[] {});
            Method seMethod = classType.getMethod(setMethodName,
                    new Class<?>[] { field.getType() });
             
            Object value = getMethod.invoke(object, new Object[] {}); //获取object中的属性值
            seMethod.invoke(copyObj, new Object[] { value });   //将该值设置到copyObj中
        	
        	//上面的功能可以直接用下面的代码实现
        	/*field.setAccessible(true);
        	Object value = field.get(object);  //获取object中的属性值
        	field.set(copyObj, value);     //将该值设置到copyObj中
             */
        }
 
        return copyObj;
    }
 
    public static void main(String[] args) throws Exception {
 
        Student student = new Student("Tom", 21);
        student.setId(111030805);
        CopyObject copy = new CopyObject();
        Student student2 = (Student) copy.copyObject(student);
        System.out.println(student2.getId() + " " + student2.getName() + " "
                + student2.getAge());
    }
}

//一个被反射的JavaBean
class Student {

 private long id;
 private String name;
 private int age;

 public Student() {

 }

 public Student(String name, int age) {
     this.name = name;
     this.age = age;
 }

 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

 public int getAge() {
     return age;
 }

 public void setAge(int age) {
     this.age = age;
 }

 public long getId() {
     return id;
 }

 public void setId(long id) {
     this.id = id;
 }

}

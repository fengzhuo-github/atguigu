package project2;

import javax.print.DocFlavor;

public class Customer {
    private String name ;
    private String sex;
    private int age;
    private String tel;
    private String mail;

    public Customer(String name, String sex, int age, String tel, String mail){
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.tel = tel;
        this.mail = mail;
    }

    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMail() {
        return mail;
    }

    public String getSex() {
        return sex;
    }

    public String getTel() {
        return tel;
    }

    public String getDetails() {
        return name + "\t" + sex + "\t" + age + "\t\t" + tel + "\t" + mail;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}

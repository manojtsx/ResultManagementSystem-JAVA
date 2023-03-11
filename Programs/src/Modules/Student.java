package Modules;
import Reusable.LetUsConnect;
import java.sql.*;

public class Student implements ModuleInterface {
    LetUsConnect connect = new LetUsConnect();
    Connection conn = connect.getConnection();
    String name,username,password,phoneNo,email;
    int id,classs;
    public Student(){

    }
    public Student(int id,String name,String username,String password,String phoneNo, String email){
        this.id = id;
        this.name = name;
        this.username  = username;
        this.password = password;
        this.phoneNo = phoneNo;
        this.email = email;
    }
    @Override
    public void setName(String name){

    }
    @Override
    public String getName(){
       return name;
    }
    @Override
    public void setId(int id){
    }
    @Override
    public int getId(){
        return id;
    }
    public void setUsername(String username){

    }
    public String getUsername(){
        return username;
    }

    public void setPhoneNumber(String phoneNumber){}
    public String getPhoneNumber(){return phoneNo;}
    public void setEmail(String email){

    }
    public String getEmail(){
        return email;
    }

}

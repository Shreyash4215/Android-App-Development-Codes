package com.example.netclan;

/**
 * This class represents a chat app message DTO.
 */

//class to store the data temp and to pass data from main class to msg adapter class
public class MsgDTO {


    // Message content.
    private String main,sub,location,profession,dist,abt1,abt2,abt3,abt4;
    private  int progrs;

    // Message type.

    public MsgDTO(String main, String sub,String location,String profession,String dist,int progrs,String abt1,String abt2,String abt3,String abt4) {
        this.main = main;
        this.location = location;
        this.profession = profession;
        this.dist = dist;
        this.abt1 = abt1;
        this.abt2 = abt2;
        this.abt3 = abt3;
        this.abt4 = abt4;
        this.progrs = progrs;
        this.sub = sub;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String msgContent) {
        this.main = msgContent;
    }

    public String getlocation() {
        return location;
    }

    public void setlocation(String location) {
        this.location = location;
    }
    public String getprofession() {
        return profession;
    }

    public void setprofession(String profession) {
        this.profession = profession;
    }
    public String getdist() {
        return dist;
    }

    public void setdist(String dist) {
        this.dist = dist;
    }

    public int getprogrs() {
        return progrs;
    }

    public void setprogrs(int progrs) {
        this.progrs = progrs;
    }
    public String getabt1() {
        return abt1;
    }

    public void setabt1(String abt1) {
        this.main = abt1;
    }
    public String getabt2() {
        return abt2;
    }

    public void setabt2(String abt2) {
        this.main = abt2;
    }
    public String getabt3() {
        return abt3;
    }

    public void setabt3(String abt3) {
        this.main = abt3;
    }
    public String getabt4() {
        return abt4;
    }

    public void seabt4(String abt4) {
        this.main = abt4;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String msgType) {
        this.sub = msgType;
    }
}
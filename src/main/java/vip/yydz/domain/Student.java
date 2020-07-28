package vip.yydz.domain;

import java.util.List;

public class Student {
    private Integer stuid;

    private String stunumber;

    private String password;
    private List<Test> tests;

    public Student(Integer stuid, String stunumber, String password, List<Test> tests) {
        this.stuid = stuid;
        this.stunumber = stunumber;
        this.password = password;
        this.tests = tests;
    }
    public Student(){}

//    public Integer cal(){return 1;}

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public String getStunumber() {
        return stunumber;
    }

    public void setStunumber(String stunumber) {
        this.stunumber = stunumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuid=" + stuid +
                ", stunumber='" + stunumber + '\'' +
                ", password='" + password + '\'' +
                ", tests=" + tests +
                '}';
    }
}
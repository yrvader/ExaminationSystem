package vip.yydz.domain;

import java.util.Date;

public class Test {
    private Integer testid;

    private String subject;

    private Date sdate;

    private Date edate;

    private Boolean isubmit;

    private Integer pnumber;

    private String picturepaths;

    private Integer snumber;

    private String scores;

    private Boolean idread;

    private Integer testfk;
    private Student student;

    public Test(Integer testid, String subject, Date sdate, Date edate, Boolean isubmit, Integer pnumber, String picturepaths, Integer snumber, String scores, Boolean idread, Integer testfk, Student student) {
        this.testid = testid;
        this.subject = subject;
        this.sdate = sdate;
        this.edate = edate;
        this.isubmit = isubmit;
        this.pnumber = pnumber;
        this.picturepaths = picturepaths;
        this.snumber = snumber;
        this.scores = scores;
        this.idread = idread;
        this.testfk = testfk;
        this.student = student;
    }
    public  Test(){};
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getTestid() {
        return testid;
    }

    public void setTestid(Integer testid) {
        this.testid = testid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    public Date getEdate() {
        return edate;
    }

    public void setEdate(Date edate) {
        this.edate = edate;
    }

    public Boolean getIsubmit() {
        return isubmit;
    }

    public void setIsubmit(Boolean isubmit) {
        this.isubmit = isubmit;
    }

    public Integer getPnumber() {
        return pnumber;
    }

    public void setPnumber(Integer pnumber) {
        this.pnumber = pnumber;
    }

    public String getPicturepaths() {
        return picturepaths;
    }

    public void setPicturepaths(String picturepaths) {
        this.picturepaths = picturepaths;
    }

    public Integer getSnumber() {
        return snumber;
    }

    public void setSnumber(Integer snumber) {
        this.snumber = snumber;
    }

    public String getScores() {
        return scores;
    }

    public void setScores(String scores) {
        this.scores = scores;
    }

    public Boolean getIdread() {
        return idread;
    }

    public void setIdread(Boolean idread) {
        this.idread = idread;
    }

    public Integer getTestfk() {
        return testfk;
    }

    public void setTestfk(Integer testfk) {
        this.testfk = testfk;
    }

    @Override
    public String toString() {
        return "Test{" +
                "testid=" + testid +
                ", subject='" + subject + '\'' +
                ", sdate=" + sdate +
                ", edate=" + edate +
                ", isubmit=" + isubmit +
                ", pnumber=" + pnumber +
                ", picturepaths='" + picturepaths + '\'' +
                ", snumber=" + snumber +
                ", scores='" + scores + '\'' +
                ", idread=" + idread +
                ", testfk=" + testfk +
                ", student=" + student +
                '}';
    }
}
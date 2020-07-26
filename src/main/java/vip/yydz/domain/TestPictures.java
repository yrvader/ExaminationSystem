package vip.yydz.domain;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 储存考生学号与姓名、考试科目、提交状态、图片总数、提交图片的类
 */
public class TestPictures implements Serializable {
    private String idinpictures;
    private String studentname;
    private String subject;
    private Boolean issubmit;
    private Integer total;
    private byte[] p0;//一下储存图片
    private byte[] p1;
    private byte[] p2;
    private byte[] p3;
    private byte[] p4;
    private byte[] p5;
    private byte[] p6;
    private byte[] p7;
    private byte[] p8;
    private byte[] p9;

    public String getIdInPictures() {
        return idinpictures;
    }

    public void setIdInPictures(String idinpictures) {
        this.idinpictures = idinpictures;
    }

    public String getStudentName() {
        return studentname;
    }

    public void setStudentName(String studentname) {
        this.studentname = studentname;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Boolean getSubmit() {
        return issubmit;
    }

    public void setSubmit(Boolean issubmit) {
        this.issubmit = issubmit;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public byte[] getP0() {
        return p0;
    }

    public void setP0(byte[] p0) {
        this.p0 = p0;
    }

    public byte[] getP1() {
        return p1;
    }

    public void setP1(byte[] p1) {
        this.p1 = p1;
    }

    public byte[] getP2() {
        return p2;
    }

    public void setP2(byte[] p2) {
        this.p2 = p2;
    }

    public byte[] getP3() {
        return p3;
    }

    public void setP3(byte[] p3) {
        this.p3 = p3;
    }

    public byte[] getP4() {
        return p4;
    }

    public void setP4(byte[] p4) {
        this.p4 = p4;
    }

    public byte[] getP5() {
        return p5;
    }

    public void setP5(byte[] p5) {
        this.p5 = p5;
    }

    public byte[] getP6() {
        return p6;
    }

    public void setP6(byte[] p6) {
        this.p6 = p6;
    }

    public byte[] getP7() {
        return p7;
    }

    public void setP7(byte[] p7) {
        this.p7 = p7;
    }

    public byte[] getP8() {
        return p8;
    }

    public void setP8(byte[] p8) {
        this.p8 = p8;
    }

    public byte[] getP9() {
        return p9;
    }

    public void setP9(byte[] p9) {
        this.p9 = p9;
    }

    public TestPictures(String idinpictures, String studentname, String subject, Boolean issubmit, Integer total, byte[] p0, byte[] p1, byte[] p2, byte[] p3, byte[] p4, byte[] p5, byte[] p6, byte[] p7, byte[] p8, byte[] p9) {
        this.idinpictures = idinpictures;
        this.studentname = studentname;
        this.subject = subject;
        this.issubmit = issubmit;
        this.total = total;
        this.p0 = p0;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
        this.p6 = p6;
        this.p7 = p7;
        this.p8 = p8;
        this.p9 = p9;
    }
    public TestPictures(){}

    @Override
    public String toString() {
        return "TestPictures{" +
                "idInPictures='" + idinpictures + '\'' +
                ", studentName='" + studentname + '\'' +
                ", subject='" + subject + '\'' +
                ", isSubmit=" + issubmit +
                ", total=" + total +
                ", p0=" + Arrays.toString(p0) +
                ", p1=" + Arrays.toString(p1) +
                ", p2=" + Arrays.toString(p2) +
                ", p3=" + Arrays.toString(p3) +
                ", p4=" + Arrays.toString(p4) +
                ", p5=" + Arrays.toString(p5) +
                ", p6=" + Arrays.toString(p6) +
                ", p7=" + Arrays.toString(p7) +
                ", p8=" + Arrays.toString(p8) +
                ", p9=" + Arrays.toString(p9) +
                '}';
    }
}

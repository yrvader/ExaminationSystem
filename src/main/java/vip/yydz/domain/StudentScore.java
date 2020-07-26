package vip.yydz.domain;

import java.io.Serializable;

/**
 * 储存学生的学号、姓名、考试科目、批阅状态、总成绩、题数、各题成绩
 */
public class StudentScore implements Serializable {
    private String idinscore;
    private String studentname;
    private String subject;
    private Boolean iscomplete;
    private Integer score;
    private Integer total;
    private Integer s0;
    private Integer s1;
    private Integer s2;
    private Integer s3;
    private Integer s4;
    private Integer s5;
    private Integer s6;
    private Integer s7;
    private Integer s8;
    private Integer s9;

    public StudentScore(String idinscore, String studentname, String subject, Boolean iscomplete, Integer score, Integer total, Integer s0, Integer s1, Integer s2, Integer s3, Integer s4, Integer s5, Integer s6, Integer s7, Integer s8, Integer s9) {
        this.idinscore = idinscore;
        this.studentname = studentname;
        this.subject = subject;
        this.iscomplete = iscomplete;
        this.score = score;
        this.total = total;
        this.s0 = s0;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.s4 = s4;
        this.s5 = s5;
        this.s6 = s6;
        this.s7 = s7;
        this.s8 = s8;
        this.s9 = s9;
    }

    public String getIdinscore() {
        return idinscore;
    }

    public void setIdinscore(String idinscore) {
        this.idinscore = idinscore;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Boolean getIscomplete() {
        return iscomplete;
    }

    public void setIscomplete(Boolean iscomplete) {
        this.iscomplete = iscomplete;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getS0() {
        return s0;
    }

    public void setS0(Integer s0) {
        this.s0 = s0;
    }

    public Integer getS1() {
        return s1;
    }

    public void setS1(Integer s1) {
        this.s1 = s1;
    }

    public Integer getS2() {
        return s2;
    }

    public void setS2(Integer s2) {
        this.s2 = s2;
    }

    public Integer getS3() {
        return s3;
    }

    public void setS3(Integer s3) {
        this.s3 = s3;
    }

    public Integer getS4() {
        return s4;
    }

    public void setS4(Integer s4) {
        this.s4 = s4;
    }

    public Integer getS5() {
        return s5;
    }

    public void setS5(Integer s5) {
        this.s5 = s5;
    }

    public Integer getS6() {
        return s6;
    }

    public void setS6(Integer s6) {
        this.s6 = s6;
    }

    public Integer getS7() {
        return s7;
    }

    public void setS7(Integer s7) {
        this.s7 = s7;
    }

    public Integer getS8() {
        return s8;
    }

    public void setS8(Integer s8) {
        this.s8 = s8;
    }

    public Integer getS9() {
        return s9;
    }

    public void setS9(Integer s9) {
        this.s9 = s9;
    }

    @Override
    public String toString() {
        return "StudentScore{" +
                "idinscore='" + idinscore + '\'' +
                ", studentname='" + studentname + '\'' +
                ", subject='" + subject + '\'' +
                ", iscomplete=" + iscomplete +
                ", score=" + score +
                ", total=" + total +
                ", s0=" + s0 +
                ", s1=" + s1 +
                ", s2=" + s2 +
                ", s3=" + s3 +
                ", s4=" + s4 +
                ", s5=" + s5 +
                ", s6=" + s6 +
                ", s7=" + s7 +
                ", s8=" + s8 +
                ", s9=" + s9 +
                '}';
    }
}

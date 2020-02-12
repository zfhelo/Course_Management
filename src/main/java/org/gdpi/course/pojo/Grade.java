package org.gdpi.course.pojo;

public class Grade {
    private Integer id;
    private Integer cid;
    private Integer sid;
    private Float regularGrade;
    private Float finalGrade;
    private Student student;

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", cid=" + cid +
                ", sid=" + sid +
                ", regularGrade=" + regularGrade +
                ", finalGrade=" + finalGrade +
                ", student=" + student +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Float getRegularGrade() {
        return regularGrade;
    }

    public void setRegularGrade(Float regularGrade) {
        this.regularGrade = regularGrade;
    }

    public Float getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(Float finalGrade) {
        this.finalGrade = finalGrade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

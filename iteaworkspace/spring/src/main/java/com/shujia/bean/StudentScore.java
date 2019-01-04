package com.shujia.bean;

public class StudentScore {
    private String id;
    private String name;
    private String clazz;
    private String course;
    private Integer score;

    @Override
    public String toString() {
        return "StudentScore{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", clazz='" + clazz + '\'' +
                ", course='" + course + '\'' +
                ", score=" + score +
                '}';
    }

    public StudentScore() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public StudentScore(String id, String name, String clazz, String course, Integer score) {
        this.id = id;
        this.name = name;
        this.clazz = clazz;
        this.course = course;
        this.score = score;
    }
}

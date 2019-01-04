package day20.iotest2;

/**
 * 统计每个班级的人数
 * 1、读取班级信息表（学号，姓名，年龄，性别，班级）
 * 2、统计每个班级学生人数
 * 3、将结果写入到文件（班级名，人数）
 */
public class Student{
    private String id;
    private String name;
    private Integer age;
    private String gender;
    private String classroom;

    public Student() {
    }

    public Student(String id, String name, Integer age, String gender, String classroom) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", classroom='" + classroom + '\'' +
                '}';
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

}

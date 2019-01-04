package day20.reflect;

public class Score {
    private String studentId;
    private String courceId;
    private Integer score;

    public Score() {
    }

    public Score(String studentId, String courceId, Integer score) {
        this.studentId = studentId;
        this.courceId = courceId;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "studentId='" + studentId + '\'' +
                ", courceId='" + courceId + '\'' +
                ", score=" + score +
                '}';
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourceId() {
        return courceId;
    }

    public void setCourceId(String courceId) {
        this.courceId = courceId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}

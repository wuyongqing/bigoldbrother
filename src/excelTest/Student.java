package excelTest;

public class Student {
    private String name;
    private Integer score;
    private String percent;
    public Student (String name, Integer score, String percent) {
        this.name = name;
        this.score = score;
        this.percent = percent;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }
}

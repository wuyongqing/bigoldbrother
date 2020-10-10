import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestLambda {
    public static void main(String[] args) {
        Random r = new Random();
        List<Student> students = new ArrayList<Student>();
        for (int i = 0; i < 5; i++) {
            students.add(new Student("Student " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(students);
        System.out.println("使用匿名类的方式，筛选出 hp>90 && damange<50的英雄");
        HeroChecker checker = new HeroChecker() {
            @Override
            public boolean test(Student h) {
                return (h.getMathScore()>100 && h.getEnglishScore()<50);
            }
        };

        HeroChecker checker1 = (Student s) -> s.getMathScore() > 100 && s.getEnglishScore() < 50;

        filter(students,checker1);
    }

    private static void filter(List<Student> students,HeroChecker checker) {
        for (Student student : students) {
            if(checker.test(student))
                System.out.print(student);
        }
    }

}
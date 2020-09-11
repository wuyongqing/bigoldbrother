import java.util.List;

public class 四年级学生 {
    private String 姓名;
    private boolean 是不是老大哥;

    public 四年级学生(String 姓名, boolean 是不是老大哥) {
        this.姓名 = 姓名;
        this.是不是老大哥 = 是不是老大哥;
    }

    public void 自我介绍(){
        System.out.println(姓名 + ": 我是。。四年级学生" + 姓名 + "，是来监管你们的");
    }

    public void 教育新人() {
        if (是不是老大哥) {
            System.out.println(姓名 + ": 我们四年级学生是你们最好的老大哥！");
        } else {
            System.out.println(姓名 + ": 我们四年级学生是你们最好的大哥哥！");
        }
    }

    public void 点名(List<新学生> 新学生们) {
        System.out.println(姓名 + ": 从你那！开始！");
        新学生们.forEach(学生 -> {
            while (true) {
                if(学生.自我介绍()) {
                    this.听不见();
                    学生.set小不小声(false);
                } else {
                    this.很有精神();
                    this.下一个();
                    break;
                }
            }
        });
    }

    public void 下一个() {
        System.out.println(姓名 + ": 下一个！");
    }

    public void 听不见() {
        System.out.println(姓名 + ": 听不见！根本停不见！重来！这么小声还想开军舰？");
    }

    public void 很有精神() {
        System.out.println(姓名 + ": 好！很有精神！");
    }

}

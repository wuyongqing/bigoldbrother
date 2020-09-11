public class 新学生 {
    private String 姓名;
    private String 学校;
    private boolean 小不小声;

    public boolean is小不小声() {
        return 小不小声;
    }

    public void set小不小声(boolean 小不小声) {
        this.小不小声 = 小不小声;
    }

    public 新学生(String 姓名, String 学校 ,boolean 小不小声) {
        this.姓名 = 姓名;
        this.学校 = 学校;
        this.小不小声 = 小不小声;
    }

    public boolean 自我介绍() {
        if (小不小声) {
            System.out.println(姓名 + ": " + 学校 + "学生: " + 姓名 + "(小声)");
        } else {
            System.out.println(姓名 + ": " + 学校 + "学生: " + 姓名 + "!(超大声)");
        }
        return this.小不小声;
    }
}

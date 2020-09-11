import java.util.ArrayList;
import java.util.List;

public class 海军学校 {
    public static void main(String[] args) {
        新学生 天尊杨戬 = new 新学生("天尊杨戬", "福冈县县里东都中学", true);
        新学生 天山新泰罗 = new 新学生("天山新泰罗", "东京府府立第一中学中学", false);
        List<新学生> 新学生们 = new ArrayList<>();
        新学生们.add(天尊杨戬);
        新学生们.add(天山新泰罗);

        四年级学生 森下下士 = new 四年级学生("森下下士", true);
        森下下士.自我介绍();
        森下下士.教育新人();
        森下下士.点名(新学生们);
    }
}

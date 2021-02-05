package excelTest;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;

import java.util.Arrays;
import java.util.List;

public class HutoolTest {
    public static void main(String[] args) {
//        Student student1 = new Student("Student1", 100,"100%");
//        Student student2 = new Student("Student2", 99,"99%");
//        List<Student> rows = CollUtil.newArrayList(student1, student2);
//        ExcelWriter writer = ExcelUtil.getWriter("d:/writeBeanTest.xlsx");
//        // 合并单元格后的标题行，使用默认标题样式
//        writer.merge(4, "一班成绩单");
//        // 一次性写出内容，使用默认样式，强制输出标题
//        writer.write(rows, true);
//        // 关闭writer，释放内存
//        writer.close();
        List<String> names = Arrays.asList("".split(","));
        System.out.println(names);

        String a = "（A）", b = "(A)";
        System.out.println(a.equalsIgnoreCase(b));


    }
}

package charactor;

import java.util.ArrayList;
import java.util.List;

public class template_learn {

    public template_learn() {
        System.out.println("template_learn");
    }

    public abstract class shape {//抽象父类shape

        public abstract void draw();
    }

    public static class Circle extends shape {
        //内部类如果想被外部直接new使用需要声明为static

        public Circle() {
            new template_learn().super();
            //内部类声明为static 就需要一个外部类的实例对象来帮助它预先生成。
            //如果没有该段代码，编译会报no enclosing instance of type… in scope错误
        }

        @Override
        public void draw() {
            System.out.println("cirlce");
        }
    }

    public static class Rectangle extends shape {

        public Rectangle() {
            new template_learn().super();
        }

        @Override
        public void draw() {
            System.out.println("rec");
        }
    }

    public static class Show {


        public void draw(List<? extends shape> l) {
            //把shape 改成? extends shape 参数传递时就可以是List<Circle>或者
            // List<Rectangle>
            for (shape s : l
            ) {
                s.draw();
            }
        }
    }

    public static void main(String[] arg) {
        List<shape> c = new ArrayList<>();
        Rectangle rec = new Rectangle();
        Circle cr = new Circle();
        c.add(rec);
        List<Circle> cc = new ArrayList<>();
        //c.add(cc);
        Show s = new Show();
        s.draw(cc);
    }
}

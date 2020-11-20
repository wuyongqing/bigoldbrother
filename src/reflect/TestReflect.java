package reflect;

import cn.hutool.core.convert.Convert;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class TestReflect {
    public static void main(String[] args) throws Exception {
        ReflectPointer rp1 = new ReflectPointer(3,4);
        changeBtoA(rp1);
        System.out.println(rp1);
        String str = args[0];
        /*
         * 这样会数组角标越界，因为压根没有这个字符数组
         * 需要右键在run as-configurations-arguments里输入b.Inter（完整类名）
         *
         */
        Method m = Class.forName(str).getMethod("main",String[].class);
        //下面这两种方式都可以,main方法需要一个参数

        m.invoke(null, new Object[]{new String[]{"111","222","333"}});
        m.invoke(null, (Object)new String[]{"111","222","333"});//这个可以说明，数组也是Object
        /*
         * m.invoke(null, new String[]{"111","222","333"})
         * 上面的不可以,因为java会自动拆包
         */
        Method t = Class.forName(str).getMethod("println", null);
        t.invoke(null,null);
        int a = 0;
        String b = Convert.toStr(a);
        System.out.println(a);
        long[] c = {1,2,3,4,5};
        //bStr为："[1, 2, 3, 4, 5]"
        String bStr = Convert.toStr(c);
        System.out.println(bStr);
    }

    private static void changeBtoA(Object obj) throws Exception {
        Field[] fields = obj.getClass().getFields();

        for(Field field : fields) {
            //if(field.getType().equals(String.class))
            //由于字节码只有一份,用equals语义不准确
            if(field.getType()==String.class) {
                String oldValue = (String)field.get(obj);
                String newValue = oldValue.replace('b', 'a');
                field.set(obj,newValue);
            }
        }
    }
}


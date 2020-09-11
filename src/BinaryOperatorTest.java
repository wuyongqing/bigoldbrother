import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 *@author:liyongyong
 *@description: BinaryOperator函数式接口学习
 *@date 2019/1/22
 */
public class BinaryOperatorTest {
    public static void main(String[] args){
        BinaryOperatorTest test = new BinaryOperatorTest();
        test.testBinaryOperator(1,2,(num1,num2)->num1 + num2);
        test.testBinaryOperator(4,2,(num1,num2)->num1 - num2);
        test.testBinaryOperator(3,2,(num1,num2)->num1 * num2);
        test.testBinaryOperator(8,2,(num1,num2)->num1 / num2);
        test.testMinBy("hello","wonders",(str1,str2)->str1.length()-str2.length());
        //方法引用
        test.testMinBy("hello","wonders", Comparator.comparingInt(String::length));
        test.testMinBy("hello","wonders",(str1,str2)->str1.charAt(0)-str2.charAt(0));
        //方法引用
        test.testMinBy("hello","wonders", Comparator.comparingInt(str -> str.charAt(0)));
        test.testMaxBy("hello","wonders",(str1,str2)->str1.length()-str2.length());
        //方法引用
        test.testMaxBy("hello","wonders", Comparator.comparingInt(String::length));
        test.testMaxBy("hello","wonders",(str1,str2)->str1.charAt(0)-str2.charAt(0));
        //方法引用
        test.testMaxBy("hello","wonders", Comparator.comparingInt(str -> str.charAt(0)));
    }


    public void testBinaryOperator(Integer num1,Integer num2,BinaryOperator<Integer> result){
        System.out.println(result.apply(num1,num2));
    }

    /**
     * 返回两者里面较小的一个
     * @param str1
     * @param str2
     * @param comparator
     */
    public void testMinBy(String str1, String str2, Comparator<String> comparator){
        System.out.println(BinaryOperator.minBy(comparator).apply(str1,str2));
    }

    /**
     * 返回两者里面较大的一个
     * @param str1
     * @param str2
     * @param comparator
     */
    public void testMaxBy(String str1, String str2, Comparator<String> comparator){
        System.out.println(BinaryOperator.maxBy(comparator).apply(str1,str2));
    }
}


package spring;

import java.io.PrintStream;
import java.sql.Timestamp;
import java.text.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloWorld {
    private static final String NUMBER_PATTERN = ".*[a-zA-Z].*";
    private static final String LETTER_PATTERN = ".*[0-9]+.*";
    private static final String SPECIAL_PATTERN = ".*[ !\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~\\\\]+.*";

    //private static PrintStream stream;
    public static void main(String[] args) throws ParseException {
        //stream.println("123");
        DecimalFormat decimalFormat = new DecimalFormat("##.00%");
        Number number = decimalFormat.parse("0.5", new ParsePosition(0));
        System.out.println(number);
        System.out.println(decimalFormat.format(1 / 3.0));

        NumberFormat nt = NumberFormat.getPercentInstance();
        nt.setMinimumFractionDigits(2);
        System.out.println("百分数：" + nt.format(1.0 / 3));

        String str = "123^";

        String regex1 = ".*[a-zA-Z].*";
        String regex2 = ".*[0-9]+.*";
        String regex3 = ".*[ !\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~\\\\]+.*";

        System.out.println("=========================================");
        System.out.println("是否含有字母：" + Pattern.compile(regex1).matcher(str).find());
        System.out.println("是否含有数字：" + Pattern.compile(regex2).matcher(str).find());
        System.out.println("是否含有特殊字符："+Pattern.compile(regex3).matcher(str).find());

        System.out.println("=========================================");
        System.out.println("是否含有字母：" + str.matches(regex1));
        System.out.println("是否含有数字：" + str.matches(regex2));
        System.out.println("是否含有特殊字符：" + str.matches(regex3));

        System.out.println("=========================================");
        System.out.println("是否含有字母：" + check(str, regex1));
        System.out.println("是否含有数字：" + check(str, regex2));
        System.out.println("是否含有特殊字符：" + check(str, regex3));

        System.out.println("=========================================");
        Long start = new Date().getTime();
        System.out.println(start);
        System.out.println();
        long startTime = System.currentTimeMillis();    //获取开始时间

        System.out.println("是否符合：" + checkPassword(str));
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序执行时间为：" + (endTime-startTime) + "ms");

        String a = "(?=.*\\d)(?=.*[a-zA-Z])(?=.*[`!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?~])[\\da-zA-Z`!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?~]{6,20}";

//        List<String> list = Arrays.asList(" ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", ":", ";", "<", "=", ">", "?", "@", "[", "\\", "]", "^", "_", "`", "{", "|", "}", "~");
//        list.forEach(e -> {
//            System.out.println("特殊字符[" + e + "]：" + e.matches(regex4));
//        });

//        System.out.println("是否含有字母："+str.matches(regex1));
//        System.out.println("是否含有数字："+str.matches(regex2));
//        System.out.println("特殊字符1："+str.matches(regex3));
//        System.out.println("特殊字符2："+str.matches(regex4));

//
//        String regEx = "[ _`~!@#$%^&*()+=|{}':;,\\[\\].<>/?]";
//        System.out.println(Pattern.compile(regEx).matcher(str).find());
//
//
//        if (str.matches(".*[a-zA-z].*") && str.matches(".*[0-9].*") && str.matches(".*[ _`~!@#$%^&*()+=|{}':;,\\[\\].<>/?].*")) {
//            System.out.println(true);
//        } else {
//            System.out.println(false);
//        }

        LocalDate time = LocalDate.now().plusDays(-1);
        System.out.println(time.isBefore(time));
        System.out.println(time);
        String date = time.format(DateTimeFormatter.ISO_DATE);
        System.out.println(date);

        System.out.println("-------------------------------------------------------------------");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf.parse("2020-12-30");
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        System.out.println(cal.getFirstDayOfWeek());
        cal.setFirstDayOfWeek(Calendar.MONDAY);  //设置一周的第一天是周一
        System.out.println("cal: " + cal.getTime());
        //System.out.println(cal.);


    }
    private static boolean check(String source, String patternSource) {
        Pattern pattern = Pattern.compile(patternSource);
        Matcher matcher = pattern.matcher(source);
        return matcher.matches();
    }
    public static boolean checkPassword(String password) {
        if (check(password, NUMBER_PATTERN) && check(password, LETTER_PATTERN) && check(password, SPECIAL_PATTERN)) {
            return true;
        }
        return false;
    }
}

import cn.hutool.core.collection.CollectionUtil;
import com.sun.istack.internal.Nullable;
import util.MD5;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TestLambda {
    private static String PASSWORD_REGEX = "^^(?![a-zA-z]+$)(?!\\d+$)(?![!@#$%^&*_-]+$)(?![a-zA-z\\d]+$)(?![a-zA-z!@#$%^&*_-]+$)(?![\\d!@#$%^&*_-]+$)[a-zA-Z\\d!@#$%^&*_-]+$";
    public static void main(String[] args) throws UnsupportedEncodingException {
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

        System.out.println();
        Long a = 929L;
        Long b = 10L;
        Long c = a/(b*10);
        System.out.println(String.format("%.2f", a / 10.0 / b));

        String password = "545784*p";
        if (!Pattern.matches(PASSWORD_REGEX, password)) {
            System.out.println("不符合");
        } else {
            System.out.println("符合");
        }

        System.out.println(MD5.md5("123456"));


        Student student1 = new Student("1", 100, 100);
        Student student2 = new Student("2", 90, 90);
        Student student3 = new Student("3", 80, 80);
        List<Student> students1 = new ArrayList<>(Arrays.asList(student1, student2, student3));
        Map<String, Student> map = students1.stream().collect(Collectors.toMap(Student::getName, Function.identity()));

        LocalDateTime localDateTime = LocalDateTime.now().minusHours(1); // 小时减一
        LocalDate localDate = localDateTime.toLocalDate(); // 日期

        String today = localDate.toString(); // 今天的日期
        String yesterday = localDate.minusDays(1).toString(); // 昨天的日期
        int hourCurrent = localDateTime.getHour(); // 当前小时
        int hourPrevious = hourCurrent == 0 ? 23 : hourCurrent - 1; // 前一个小时
        String hourPreviousDay = hourPrevious == 23 ? yesterday : today; // 时间前移一个小时后的日期

        System.out.println(today+"  "+yesterday+"  "+hourCurrent+"  "+hourPrevious+"  "+hourPreviousDay);

        System.out.println(localDateTime.toLocalTime().withSecond(0).withMinute(0).format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        StringBuilder alarmTime = new StringBuilder(today + " " + localDateTime.toLocalTime().minusHours(1).withSecond(0).withMinute(0).format(DateTimeFormatter.ofPattern("HH:mm")) + "-" + localDateTime.toLocalTime().withSecond(0).withMinute(0).format(DateTimeFormatter.ofPattern("HH:mm")));
        System.out.println(alarmTime);

        System.out.println(AlarmMemberEnum.DEVELOPMENT.getMembers());

        Date date = new Date();
        LocalDateTime localDateTime1 = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime().withHour(11);
        System.out.println(localDateTime1);

        int count = 9999;
        int usedCount = 9699;

        Double[] alarmValues = {0.5, 0.7, 0.7, 0.8, 0.9, 0.95, 0.97, 0.99, 1.0};
        for (int i = 0; i < alarmValues.length; i++) {
            int value = (int) (count * alarmValues[i]);
            if (value == usedCount) {
                System.out.println("已经使用了 " + alarmValues[i] * 100 + "% 的卡券");
            }
        }

        StringBuilder abc = new StringBuilder().append(187 * 200000
                / (192941 - 2157876));
        System.out.println(abc.toString());

        Integer yesterdayHour = LocalTime.now().getHour();
        System.out.println(yesterdayHour);

        String s = "";
        String[] sspTargetList = s.split(",", -1);
        System.out.println(Arrays.toString(sspTargetList));
        System.out.println(sspTargetList.length);


        List<Integer> hasRunHourList = new ArrayList<>();
        List<Integer> hourList = new ArrayList<>(Arrays.asList(16,12,13,14,15));

        if (CollectionUtil.isNotEmpty(hourList)) {
            for (Integer hour : hourList) {
                if (yesterdayHour > hour) {
                    hasRunHourList.add(hour);
                }
            }
        } else {
            for (int hour = 0; hour < 24; hour++) {
                if (yesterdayHour > hour) {
                    hasRunHourList.add(hour);
                }
            }
        }
        if (isEmpty(hasRunHourList)) {
            hasRunHourList = null;
        }
        System.out.println(hasRunHourList);
        System.out.println(hasRunHourList == null);

        String[] hourArray = "24".split(",");
        hourList = new ArrayList<>(hourArray.length);
        for (int index = 0; index < hourArray.length; index++) {
            if (isNotEmpty(hourArray[index])) {
                Integer hour = Integer.valueOf(hourArray[index]);
                if (0 <= hour && 24 > hour) {
                    hourList.add(hour);
                }
            }
        }
        System.out.println(hourList);
        System.out.println(hourList.size());

        String openid1 = "o8uJ6uGrfytuCqWoEypKgE3E8mRg";
        Long adPlanId1 = 1234L, adPlaceId1 = 1233211L;

        String adPlanIdadPlaceId = openid1 + "," + adPlanId1 + "," + adPlaceId1;
        adPlanIdadPlaceId = URLEncoder.encode(adPlanIdadPlaceId, "UTF-8");
        System.out.println(adPlanIdadPlaceId);
        String[] openId_adPlanId_adPlaceId = URLDecoder.decode(adPlanIdadPlaceId, "UTF-8").split(",");
        String openId = openId_adPlanId_adPlaceId[0];
        Long adPlanId = Long.parseLong(openId_adPlanId_adPlaceId[1]), adPlaceId = Long.parseLong(openId_adPlanId_adPlaceId[2]);
        System.out.println(openId);
        System.out.println(adPlanId);
        System.out.println(adPlaceId);
        System.out.println(openId.equals(openid1));
        System.out.println(adPlanId.equals(adPlanId1));
        System.out.println(adPlaceId.equals(adPlaceId1));



        System.out.println("--------------------------------------------------------");
        StringBuilder sb = new StringBuilder();
        sb.appendCodePoint(1);
        sb.insert(0, "123");
        System.out.println(sb.toString());


        List<Double> aa = new ArrayList<Double>(Arrays.asList(1D,2D,3D,4D,5D));
        aa.sort((a1, b1) -> a1 - b1 > 0 ? -1 : 0);
        System.out.println(aa);

        String bb = "一、环比上小时\n" +
                "[上涨]\n" +
                "1. 分成模式测试1，固定分成CPM，3076531：358.72%↑（500 vs 109）\n" +
                "2. 票根测试，damon-test-xinxiliu，7861117：100.00%↑（1 vs 0）\n" +
                "1. 分成模式测试1，固定分成CPM，3076531：358.72%↑（500 vs 109）\n" +
                "2. 票根测试，damon-test-xinxiliu，7861117：100.00%↑（1 vs 0）\n" +
                "[下降]\n" +
                "1. 分成模式测试1，固定分成CPC，8778636：100.00%↓（0 vs 10）\n" +
                "2. ashley_分成模式，Ash分成CPC广告位，8798500：100.00%↓（0 vs 28）\n" +
                "2. ashley_分成模式，Ash分成CPC广告位，8798500：100.00%↓（0 vs 28）\n" +
                "2. ashley_分成模式，Ash分成CPC广告位，8798500：100.00%↓（0 vs 28）\n" +
                "})一、环比上小时\n" +
                "[上涨]\n" +
                "1. 分成模式测试1，固定分成CPM，3076531：358.72%↑（500 vs 109）\n" +
                "2. 票根测试，damon-test-xinxiliu，7861117：100.00%↑（1 vs 0）\n" +
                "1. 分成模式测试1，固定分成CPM，3076531：358.72%↑（500 vs 109）\n" +
                "2. 票根测试，damon-test-xinxiliu，7861117：100.00%↑（1 vs 0）\n" +
                "[下降]\n" +
                "1. 分成模式测试1，固定分成CPC，8778636：100.00%↓（0 vs 10）\n" +
                "2. ashley_分成模式，Ash分成CPC广告位，8798500：100.00%↓（0 vs 28）\n"+
                "1. 分成模式测试1，固定分成CPM，3076531：358.72%↑（500 vs 109）\n" +
                "2. 票根测试，damon-test-xinxiliu，7861117：100.00%↑（1 vs 0）\n";
        System.out.println(bb.length());
    }

    private static void test(List<Long> a) {
        a.add(3L);
        a = null;
    }
    private static void test(Long a) {
        a += 3L;
    }

    public static boolean isNotEmpty(@Nullable Object str) {
        return !(str == null || "".equals(str));
    }

    public static boolean isEmpty(@Nullable Collection<?> collection) {
        return (collection == null || collection.isEmpty());
    }

    private static void filter(List<Student> students,HeroChecker checker) {
        for (Student student : students) {
            if(checker.test(student))
                System.out.print(student);
        }
    }

}
package test;

import javax.xml.transform.Source;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

public class test {
    public static void main(String[] args) {
        //Long a = 259519L;
        //System.out.println(String .format("%.2f", a * 100.0));
        // System.out.println(Math.abs(dspNonsystemAuditingRequest.getPayAmount()-dspNonsystemAuditingRequest.getSystemCalCost()));

        //Date date = new Date();
        //System.out.println(date.getTime());

        //获得当前时间
        Instant instant = Instant.now();
        // 以ISO-8601输出

        instant = Instant.ofEpochMilli(new Date().getTime());
        Instant deadlineInstant = instant.atZone(ZoneId.systemDefault()).toInstant();
        System.out.println(deadlineInstant);
        System.out.println(instant);
        //instant = Instant.parse("1995-10-23T10:12:35Z");
        Instant instant1 = instant.plus(Duration.ofHours(5).plusMinutes(4));
        Instant instant2 = instant.minus(Duration.ofDays(5));
        Instant instant3 = instant.minus(5, ChronoUnit.DAYS);
        System.out.println(instant1);
        System.out.println(instant2);
        System.out.println(instant3);
        System.out.println(instant.isAfter(instant1));
        System.out.println(instant.isAfter(instant2));
        System.out.format("instant1.compareTo(instant) = %d \n", instant.compareTo(instant3));
        System.out.format("I am %d years %s \n", 12, "old");
        LocalDate localDate= LocalDate.ofYearDay(1997,1);
        System.out.println(localDate);
        localDate = LocalDate.ofYearDay(1997, 187);
        System.out.println(localDate);
        System.out.println(localDate.plusDays(178));
        System.out.println(localDate.getMonthValue());

        System.out.println(LocalTime.of(22, 23));
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(localDateTime2);
        System.out.println(localDateTime.toLocalDate());
        System.out.println(localDateTime.toLocalTime());
        System.out.println(localDateTime.plusMinutes(1));
        System.out.println(localDateTime.plus(Duration.ofDays(1)));
        System.out.println(localDateTime.plus(Period.ofDays(1)));
        Period period = Period.between(localDate, localDateTime2.toLocalDate());
        System.out.println("Years:" + period.getYears() +
                " months:" + period.getMonths() +
                " days:"+period.getDays());
        LocalDate birthday = LocalDate.of(1997, 7, 6);
        LocalDate deathDay = LocalDate.of(2077, 7, 6);
        Long daysILived = LocalDate.now().toEpochDay() - birthday.toEpochDay();
        Long daysILivedAll = deathDay.toEpochDay() - birthday.toEpochDay();
        Long daysILeft = deathDay.toEpochDay() - LocalDate.now().toEpochDay();
        System.out.println(daysILived);
        System.out.println(daysILivedAll);
        System.out.println(daysILeft);

        System.out.println("--------------------------------------------------------------");
        LocalDateTime deadlineDateTime1 = LocalDateTime.now();
        LocalDateTime deadlineDateTime = LocalDateTime.now().plusDays(0).withHour(23).withMinute(59).withSecond(59);
        deadlineInstant = deadlineDateTime1.atZone(ZoneId.systemDefault()).toInstant();
        System.out.println(deadlineDateTime1);
        System.out.println(deadlineInstant);
        deadlineInstant = deadlineDateTime.atZone(ZoneId.systemDefault()).toInstant();
        System.out.println(deadlineDateTime);
        System.out.println(deadlineInstant);
        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.UTC));
        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.MIN));
        Instant instant4 = LocalDateTime.now().toInstant(ZoneOffset.MAX);
        System.out.println(instant4);
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        LocalDateTime times = LocalDateTime.now().plusDays(0).withHour(23).withMinute(59).withSecond(59);
        System.out.println(times);
        System.out.println(times.atZone(ZoneId.systemDefault()));
        System.out.println(times.atZone(ZoneId.systemDefault()).toInstant());
    }
}

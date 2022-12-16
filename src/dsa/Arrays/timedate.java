package dsa.Arrays;

import java.time.*;

class Scratch {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        System.out.println(ldt);
        System.out.println(ldt.getDayOfMonth());
        System.out.println(Instant.now());

        //instant to zoned date time
        ZonedDateTime t = Instant.now().atZone(ZoneId.of("Asia/Tokyo"));
        System.out.println("zoned date time :: " +t);

        //zoned date time to instant
        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Asia/Tokyo"));
        Instant instant = zonedDateTime.toInstant();
        System.out.println("instant date :: " +instant);

        //local date time to zoned date time
        ZonedDateTime date = LocalDateTime.of(2022, 01, 05, 6, 51).atZone(ZoneId.systemDefault());
        System.out.println("zoned date time :: " + date);

        //zoned date time to local date time
        LocalDateTime localDateTime = ZonedDateTime.now().toLocalDateTime();
        System.out.println("local date time :: "+ localDateTime);

        //LocalDateTime to epoch milliseconds
        Instant instant1 = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        long timeInMillis = instant1.toEpochMilli();
        System.out.println(timeInMillis);

        //Using LocalDateTime.ofEpochSecond
        LocalDateTime localDateTime1 = LocalDateTime.ofEpochSecond(1567109422L, 0, ZoneOffset.UTC);
        System.out.println(localDateTime1);

        ZoneOffset zoneOffSet= ZoneOffset.of("+02:00");
        OffsetDateTime offsetDateTime = OffsetDateTime.now(zoneOffSet);
        System.out.println("offset date time :: " + offsetDateTime);
    }
}
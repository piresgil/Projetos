package application;/*
 *  @ Daniel
 */

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class Date {
    /*
     *
     */
    public static void main(String[] args) {
        // var´s para date formatter
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        LocalDate d01 = LocalDate.now();
        LocalDateTime d02 = LocalDateTime.now();
        Instant d03 = Instant.now();

        LocalDate d04 = LocalDate.parse("2022-07-20");
        LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:36");
        Instant d06 = Instant.parse("2022-07-20T01:30:36z");
        Instant d07 = Instant.parse("2022-07-20T01:30:36+01:00");// +01 para portugal

        LocalDate d08 = LocalDate.parse("20/07/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        // date rime formater pode ser instaciado em var(inicio codigo)
        LocalDateTime d09 = LocalDateTime.parse("20/07/2022 01:30", fmt);

        LocalDate d10 = LocalDate.of(2022, 07, 20);
        LocalDateTime d11 = LocalDateTime.of(2022, 07, 20, 20, 30);

        System.out.println("LocalDate = " + d01);
        System.out.println("LocalDateTime = " + d02);
        System.out.println("Instant = " + d03);
        System.out.println("----parse----");
        System.out.println("LocalDate= " + d04);
        System.out.println("LocalDateTime = " + d05);
        System.out.println("Instant = " + d06);
        System.out.println("Instante gmt+1 = " + d07);
        System.out.println("----DateTimeFormarter----");
        System.out.println("format dd/MM/yyyy = " + d08);
        System.out.println("format dd/MM/yyyy HH:mm = " + d09);

        System.out.println("----localDate.of----");
        System.out.println("Localdate.of = " + d10);
        System.out.println("Localdate.of = " + d11);
    }
}

/*
 *  @ Daniel
 */



class DateConverter {
    /*
     *
     */
    public static void main(String[] args) {
        // DADOS de Datas
        LocalDate d04 = LocalDate.parse("2022-07-20");
        LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:36");
        Instant d06 = Instant.parse("2022-07-20T23:30:36z");
        // Converções
        LocalDate r1 = LocalDate.ofInstant(d06, ZoneId.systemDefault());
        LocalDate r2 = LocalDate.ofInstant(d06, ZoneId.of("America/Sao_Paulo"));
        LocalDateTime r3 = LocalDateTime.ofInstant(d06, ZoneId.systemDefault());
        LocalDateTime r4 = LocalDateTime.ofInstant(d06, ZoneId.of("America/Sao_Paulo"));

        System.out.println("LocalDate(default)= " + r1);
        System.out.println("LocalDate America/S. Paulo = " + r2);
        System.out.println("LocalDateTime(default) = " + r3);
        System.out.println("LocalDate(America/S. Paulo) = " + r4);

        System.out.println("----------------------------");
        System.out.println("d04 dia = " + d04.getDayOfMonth());
        System.out.println("d04 Mes = " + d04.getMonthValue());
        System.out.println("d04 Ano = " + d04.getYear());
        System.out.println("----------------------------");
        System.out.println("d05 Hora = " + d05.getHour());
        System.out.println("d05 Minuto = " + d05.getMinute());
        System.out.println("d05 Segundo = " + d05.getSecond());

    }
}
class DateDuracao {
    /*
     *
     */
    public static void main(String[] args) {
        // DADOS de Datas
        LocalDate d04 = LocalDate.parse("2022-07-20");
        LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:36");
        Instant d06 = Instant.parse("2022-07-20T23:30:36z");
        // Durações
        LocalDate pastWeekLocalDate = d04.minusDays(7);
        LocalDate nextWeekLocalDate = d04.plusDays(7);

        LocalDateTime pastWeekLocalDateTime = d05.minusDays(7);
        LocalDateTime nextWeekLocalDateTime = d05.plusDays(7);

        Instant passWeekInstant = d06.minus(7, ChronoUnit.DAYS);
        Instant nextWeekInstant = d06.plus(7, ChronoUnit.DAYS);

        System.out.println("pastWeekLocalDate = " + pastWeekLocalDate);
        System.out.println("nextWeekLocalDate = " + nextWeekLocalDate);
        System.out.println("----------------------------");
        System.out.println("pastWeekLocalDateTime = " + pastWeekLocalDateTime);
        System.out.println("nextWeekLocalDateTime = " + nextWeekLocalDateTime);
        System.out.println("----------------------------");
        System.out.println("passWeekInstant = " + passWeekInstant);
        System.out.println("nextWeekInstant = " + nextWeekInstant);
        System.out.println("----------------------------");
        System.out.println("--------------Duration--------------");

        //uma outra forma
        //Duration t1 = Duration.between(pastWeekLocalDate.atTime(0, 0), d04.atTime(0, 0));
        Duration t1 = Duration.between(pastWeekLocalDate.atStartOfDay(), d04.atStartOfDay());
        Duration t2 = Duration.between(pastWeekLocalDateTime, d05);
        Duration t3 = Duration.between(passWeekInstant, d06);
        Duration t4 = Duration.between(d06,passWeekInstant);
        System.out.println("t1 dias= " + t1.toDays());
        System.out.println("t2 dias= " + t2.toDays());
        System.out.println("t3 dias= " + t3.toDays());
        System.out.println("t4 dias= " + t4.toDays());
    }
}
 class DateFormatter {
    /*
     *
     */
    public static void main(String[] args) {
        // DADOS de Datas
        LocalDate d04 = LocalDate.parse("2022-07-20");
        LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:36");
        Instant d06 = Instant.parse("2022-07-20T23:30:36z");
        // Formatções
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        // com fuso do sistema local
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
        // usando padrao ISO
        DateTimeFormatter fmt4 = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter fmt5 = DateTimeFormatter.ISO_INSTANT;

        System.out.println("LocalDate= " + d04.format(fmt1));
        System.out.println("LocalDate= " + fmt1.format(d04));
        System.out.println("LocalDate= " + d04.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        System.out.println("LocalDateTime = " + d05.format(fmt1));
        System.out.println("LocalDateTime = " + d05.format(fmt2));
        // fmt4
        System.out.println("LocalDateTime(ISO_DATE_TIME) = " + d05.format(fmt4));

        System.out.println("Instant = " + fmt3.format(d06));
        // fmt5
        System.out.println("Instant(ISO_INSTANT) = " + fmt5.format(d06));
    }
}

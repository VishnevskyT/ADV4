package exercise_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;



/**
* Завдання 3
* Спроектуйте та розробте метод, який визначає, скільки часу пройшло із заданої дати.
* За допомогою цього методи виведіть у консоль, скільки часу пройшло з вашого дня народження у зручному для сприйняття
* вигляді, наприклад: «Вам виповнилося 20 років, 3 місяці, 18 днів, 4 години, 5 хвилин та 10 секунд».
 */
public class Main {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введіть дату у форматі DD.MM.YYYY для розрахунку часу: _");
            String date = br.readLine();
            DateCalculator(date);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    static void DateCalculator (String date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate startDate = LocalDate.parse(date, dateTimeFormatter);
        LocalDate localDate = LocalDate.now();


        Period diff = Period.between(startDate, localDate);

        System.out.print("Між датами " + startDate + " та " + localDate + " пройшло чимало, а саме: ");

        if (diff.getYears() == 1 || diff.getYears() % 10 == 1)
            System.out.print(diff.getYears() + " рік, ");
        else if (diff.getYears() % 10 == 2 || diff.getYears() % 10 == 3 || diff.getYears() % 10 == 4)
            System.out.print(diff.getYears() + " роки, ");
        else
            System.out.print(diff.getYears() + " років, ");

        if (diff.getMonths() == 1 || diff.getMonths() % 10 == 1)
            System.out.print(diff.getMonths() + " місяць та ");
        else if (diff.getMonths() % 10 == 2 || diff.getMonths() % 10 == 3 || diff.getMonths() % 10 == 4)
            System.out.print(diff.getMonths() + " місяці та ");
        else
            System.out.print(diff.getMonths() + " місяців та ");

        if (diff.getDays() == 1 || diff.getDays() % 10 == 1)
            System.out.print(diff.getDays() + " день.");
        else if (diff.getDays() % 10 == 2 || diff.getDays() % 10 == 3 || diff.getDays() % 10 == 4)
            System.out.print(diff.getDays() + " дні.");
        else
            System.out.print(diff.getDays() + " днів.");


        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String myBirthdate = "13.06.1990 00:00:00";
        LocalDateTime myDate = LocalDateTime.parse(myBirthdate,dateTimeFormatter1);
        LocalDateTime localDateTime = LocalDateTime.now();
        Period diff2 = Period.between(myDate.toLocalDate(), localDateTime.toLocalDate());
        Duration duration = Duration.between(myDate,localDateTime);

        System.out.print("\nА ось один цікавий факт. Автору цього коду ");

        if (diff2.getYears() == 1 || diff2.getYears() % 10 == 1)
            System.out.print(diff2.getYears() + " рік, ");
        else if (diff2.getYears() % 10 == 2 || diff2.getYears() % 10 == 3 || diff2.getYears() % 10 == 4)
            System.out.print(diff2.getYears() + " роки, ");
        else
            System.out.print(diff2.getYears() + " років, ");

        if (diff2.getMonths() == 1 || diff2.getMonths() % 10 == 1)
            System.out.print(diff2.getMonths() + " місяць, ");
        else if (diff2.getMonths() % 10 == 2 || diff2.getMonths() % 10 == 3 || diff2.getMonths() % 10 == 4)
            System.out.print(diff2.getMonths() + " місяці, ");
        else
            System.out.print(diff2.getMonths() + " місяців, ");

        if (diff2.getDays() == 1 || diff2.getDays() % 10 == 1)
            System.out.print(diff2.getDays() + " день, ");
        else if (diff2.getDays() % 10 == 2 || diff2.getDays() % 10 == 3 || diff2.getDays() % 10 == 4)
            System.out.print(diff2.getDays() + " дні, ");
        else
            System.out.print(diff2.getDays() + " днів, ");


        if (duration.toHours()%24 == 1 || duration.toHours()%24 % 10 == 1)
            System.out.print(duration.toHours()%24 + " годину, ");
        else if (duration.toHours()%24 % 10 == 2 || duration.toHours()%24 % 10 == 3 || duration.toHours()%24 % 10 == 4)
            System.out.print(duration.toHours()%24 + " години, ");
        else
            System.out.print(duration.toHours()%24 + " годин, ");

        if (duration.toMinutes()%60 == 1 || duration.toMinutes()%60 % 10 == 1)
            System.out.print(duration.toMinutes()%60 + " хвилина та ");
        else if (duration.toMinutes()%60 % 10 == 2 || duration.toMinutes()%60 % 10 == 3 || duration.toMinutes()%60 % 10 == 4)
            System.out.print(duration.toMinutes()%60 + " хвилини та ");
        else
            System.out.print(duration.toMinutes()%60 + " хвилин та ");

        if (duration.toSeconds()%60 == 1 || duration.toSeconds()%60 % 10 == 1)
            System.out.print(duration.toSeconds()%60 + " секунда.");
        else if (duration.toSeconds()%60 % 10 == 2 || duration.toSeconds()%60 % 10 == 3 || duration.toSeconds()%60 % 10 == 4)
            System.out.print(duration.toSeconds()%60 + " секунди.");
        else
            System.out.print(duration.toSeconds()%60 + " секунд.");

    }

}

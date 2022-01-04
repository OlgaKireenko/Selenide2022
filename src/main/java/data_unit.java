import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class data_unit {
    public static void main(String[] args) {

        LocalDate date = LocalDate.now();
        System.out.println(date);
        LocalDate date1 = date.plusDays(3);
        System.out.println(date1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String text = date1.format(formatter);
        System.out.println(text);

    }
}
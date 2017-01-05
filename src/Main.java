import javax.swing.text.DateFormatter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

import static java.text.DateFormat.SHORT;

public class Main {

    public static void main(String[] args) {

        String language;
        String country;
        if (args.length != 2) {
            language = "en";
            country = "US";
        } else {
            language = args[0];
            country = args[1];
        }

        Locale currentLocale = new Locale(language, country);
        System.out.println("Locale is " + currentLocale);
        ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);

        System.out.println(messages.getString("hello"));
        System.out.println(messages.getString("inquiry"));

        Integer count = new Integer(123456);
        Double biggerCount = new Double(345987.24);

        NumberFormat numberFormatter = NumberFormat.getNumberInstance(currentLocale);
        System.out.println(numberFormatter.format(count));
        System.out.println(numberFormatter.format(biggerCount));

        Integer cost = 234;
        Double biggerCost = 3456.78;
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(currentLocale);
        String formattedCost = currencyFormatter.format(cost);
        System.out.println(formattedCost);
        System.out.println(currencyFormatter.format(biggerCost));

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/uuu", currentLocale);
        String formattedDate = dateTimeFormatter.format(date);
        System.out.println(formattedDate);


        String message = messages.getString("date");
        System.out.println("Message before concatination: " + message);
        System.out.println(MessageFormat.format(message, formattedDate));
    }
}

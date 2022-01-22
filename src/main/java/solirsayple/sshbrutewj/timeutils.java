package solirsayple.sshbrutewj;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;



public class timeutils {

    public static String rightnow(){

        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.now();

        return (df.format(localDate) + " " + tf.format(localTime));




    }
    
}

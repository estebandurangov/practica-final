
import java.time.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Duran
 */
public class time {
    LocalDate localDate = LocalDate.now();
    
    public static void main(String[] args) {
        ZoneId zoneId = ZoneId.of("America/Panama");
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
        System.out.println(localDateTime);
        System.out.println(zonedDateTime);  
    }
}

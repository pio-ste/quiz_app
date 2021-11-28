package pl.ps.demo.service.validation;

import pl.ps.demo.model.enums.Status;

import java.time.LocalDateTime;

public class ArgumentValidation {

    public ArgumentValidation() {
    }

    public static boolean minLength(String arg, Integer size){
        return arg.length() <= size;
    }

    public static boolean minValue(Integer arg, Integer minVal){
        return arg <= minVal;
    }

    public static boolean maxLength(String arg, Integer maxVal){
        return arg.length() >= maxVal;
    }

    public static boolean maxValue(Integer arg, Integer maxVal){
        return arg >= maxVal;
    }

    public static boolean isEmpty(String arg){
        return arg.isEmpty();
    }

    public static boolean isNull(String arg){
        return arg == null;
    }

    public static boolean isNull(Integer arg){
        return arg == null;
    }

    public static boolean isNull(LocalDateTime arg) { return arg == null; }

    public static boolean isNull(Boolean arg){
        return arg == null;
    }

    public static boolean isNull(Status status) {return status == null; }

    public static boolean isBeforeNow(LocalDateTime arg) { return arg.isBefore(LocalDateTime.now());}

    public static boolean endDateIsBeforeStartDate(LocalDateTime startDate, LocalDateTime endDate){
        return endDate.isBefore(startDate);
    }

    public static boolean isEmail(String arg){
        return arg.contains("@");
    }
}

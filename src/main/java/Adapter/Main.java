package Adapter;

public class Main {
    public static void main(String[] args) {
        CalendarToNewDateAdapter date = new CalendarToNewDateAdapter();
        date.setDay(1);
        date.setMonth(1);
        date.setYear(2024);
        System.out.println("Date: " + date.getDay() + "." + date.getMonth() + "." + date.getYear());

        date.advanceDays(15);
        System.out.println("Date after advancing 15 days: " + date.getDay() + "." + date.getMonth() + "." + date.getYear());
    }
}

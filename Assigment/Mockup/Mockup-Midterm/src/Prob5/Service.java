package Prob5;

import java.time.LocalDate;
import java.time.Period;

public abstract class Service {
    private int Daily_Price;
    private LocalDate Date_Subscribed;

    public void setDailyPrice(int dailyPrice) {
        this.Daily_Price = dailyPrice;
    }

    public int getDailyPrice() {
        return Daily_Price;
    }

    public void setDateSubscribed(LocalDate dateSubscribed) {
        this.Date_Subscribed = dateSubscribed;
    }

    public LocalDate getDateSubscribed() {
        return Date_Subscribed;
    }

    public int dateDifference() {
        LocalDate now = LocalDate.now();
        LocalDate subDate = Date_Subscribed;
        Period period = Period.between(subDate, now);
        int diff;
        int Month_diff = period.getMonths();
        int Day_diff = period.getDays();

        if (Month_diff != 0) {
            diff = (Month_diff * 30) + Day_diff;
        } else {
            diff = Day_diff;
        }
        return diff;
    }

    public abstract int calcFee();
}

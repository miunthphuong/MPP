package Prob5BonusA;

public class Monthly extends Service {
    @Override
    public int calcFee() {
        int totalDays = dateDifference();
        return totalDays * getDailyPrice();
    }
}

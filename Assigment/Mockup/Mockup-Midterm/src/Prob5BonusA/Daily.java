package Prob5BonusA;

public class Daily extends Service {
    @Override
    public int calcFee() {
        return getDailyPrice() * dateDifference();
    }
}

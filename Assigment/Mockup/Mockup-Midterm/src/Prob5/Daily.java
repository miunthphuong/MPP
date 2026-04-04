package Prob5;

public class Daily extends Service {
    @Override
    public int calcFee() {
        return getDailyPrice() * dateDifference();
    }
}

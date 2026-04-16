class Daily extends Service {

    @Override
    public double calcFee(double dailyPrice) {
        return dailyPrice * dateDifference();
    }
}

class Monthly extends Service {

    @Override
    public double calcFee(double dailyPrice) {
        return dailyPrice * 30;
    }
}


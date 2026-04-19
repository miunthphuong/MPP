package Prob4;

class MallardDuck extends Duck implements FlyBehavior, QuackBehavior {
    public void display() { System.out.println("  display"); }

    // Gọi trực tiếp đến default method của interface nếu Java yêu cầu
    @Override
    public void fly() { FlyBehavior.super.fly(); }

    @Override
    public void quack() { QuackBehavior.super.quack(); }
}

class RedheadDuck extends Duck implements FlyBehavior, QuackBehavior {
    public void display() { System.out.println("  displaying"); }

    @Override
    public void fly() { FlyBehavior.super.fly(); }

    @Override
    public void quack() { QuackBehavior.super.quack(); }
}

class RubberDuck extends Duck implements CannotFly, Squeak {
    public void display() { System.out.println("  displaying"); }

    @Override
    public void fly() { CannotFly.super.fly(); }

    @Override
    public void quack() { Squeak.super.quack(); }
}

class DecoyDuck extends Duck implements CannotFly, MuteQuack {
    public void display() { System.out.println("  displaying"); }

    @Override
    public void fly() { CannotFly.super.fly(); }

    @Override
    public void quack() { MuteQuack.super.quack(); }
}

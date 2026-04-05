class MallardDuck extends Duck {
    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }
    public void display() { System.out.println("  display"); }
}

class RedheadDuck extends Duck {
    public RedheadDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }
    public void display() { System.out.println("  displaying"); }
}

class RubberDuck extends Duck {
    public RubberDuck() {
        flyBehavior = new CannotFly();
        quackBehavior = new Squeak();
    }
    public void display() { System.out.println("  displaying"); }
}

class DecoyDuck extends Duck {
    public DecoyDuck() {
        flyBehavior = new CannotFly();
        quackBehavior = new MuteQuack();
    }
    public void display() { System.out.println("  displaying"); }
}

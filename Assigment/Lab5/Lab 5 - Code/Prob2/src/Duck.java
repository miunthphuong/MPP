public abstract class Duck {
    // The Duck class uses these interfaces through composition
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void fly() {
        // Delegate the behavior to the specific implementation
        flyBehavior.fly();
    }

    public void quack() {
        // Delegate the behavior to the specific implementation
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("  swimming");
    }

    public abstract void display();
}
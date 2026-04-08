class Quack implements QuackBehavior {
    public void quack() {
        System.out.println("  quacking");
    }
}

interface Squeak extends QuackBehavior {
    @Override
    default void quack() {
        System.out.println("  squeaking");
    }
}

interface MuteQuack extends QuackBehavior {
    @Override
    default void quack() {
        System.out.println("  cannot quack");
    }
}
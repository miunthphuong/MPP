class FlyWithWings implements FlyBehavior {
    public void fly() {
        System.out.println("  fly with wings");
    }
}

interface CannotFly extends FlyBehavior {
    @Override
    default void fly() {
        System.out.println("  cannot fly");
    }
}
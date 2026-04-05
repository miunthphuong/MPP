class FlyWithWings implements FlyBehavior {
    public void fly() {
        System.out.println("  fly with wings");
    }
}

class CannotFly implements FlyBehavior {
    public void fly() {
        System.out.println("  cannot fly");
    }
}
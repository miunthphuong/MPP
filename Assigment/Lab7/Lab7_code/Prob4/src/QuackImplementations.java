class Quack implements QuackBehavior {
    public void quack() {
        System.out.println("  quacking");
    }
}

class Squeak implements QuackBehavior {
    public void quack() {
        System.out.println("  squeaking");
    }
}

class MuteQuack implements QuackBehavior {
    public void quack() {
        System.out.println("  cannot quack");
    }
}
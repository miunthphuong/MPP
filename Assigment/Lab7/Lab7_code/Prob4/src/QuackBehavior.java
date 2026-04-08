public interface QuackBehavior {
    default void quack() {
        System.out.println("  quacking");
    }
}
public static Group<?> copy(Group<?> group) {
    return copyHelper(group);
}

private static <T> Group<T> copyHelper(Group<T> group) {
    T special = group.getSpecialElement();
    List<T> elements = group.getElements();
    return new Group<T>(special, elements);
}

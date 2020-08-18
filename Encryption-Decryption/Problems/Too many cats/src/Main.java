class Cat {

    // write static and instance variables
    public static int count;
    private String name;
    private int age;

    public Cat(String name, int age) {
        // implement the constructor
        // do not forget to check the number of cats
        this.name = name;
        this.age = age;
        count++;
        if (count > 5) {
            System.out.println("You have too many cats");
        }
    }

    public static int getNumberOfCats() {
        // implement the static method
        return count;
    }
}
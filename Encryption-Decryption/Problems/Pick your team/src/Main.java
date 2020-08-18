import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* The Strategy pattern is useful when we have multiple algorithms for performing a task and we want to choose any of the algorithms at runtime.
 This pattern is especially good when the number of algorithms increases because it isolates algorithms from the client code.
 */

//Context class
class SelectionContext {

    private PersonSelectionAlgorithm algorithm;

    public void setAlgorithm(PersonSelectionAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public Person[] selectPersons(Person[] persons) {
        // write your code here
        return this.algorithm.select(persons);
    }
}

//Strategy interfaceJava
interface PersonSelectionAlgorithm {

    Person[] select(Person[] persons);
}

// Concrete strategy classes to implement specific algorithm
class TakePersonsWithStepAlgorithm implements PersonSelectionAlgorithm {
    private int step;

    public TakePersonsWithStepAlgorithm(int step) {
        // write your code here
        this.step = step;

    }

    @Override
    public Person[] select(Person[] persons) {
        // write your code here
        List<Person> selected = new ArrayList<>();
        for (int i = 0; i < persons.length; i++) {
            if (i % step == 0) {
                selected.add(persons[i]);
            }
        }
        return selected.toArray(new Person[selected.size()]);
    }
}

// Concrete strategy classes to implement specific algorithm
class TakeLastPersonsAlgorithm implements PersonSelectionAlgorithm {
    private int count;

    public TakeLastPersonsAlgorithm(int count) {
        // write your code here
        this.count = count;
    }

    @Override
    public Person[] select(Person[] persons) {
        // write your code here
        return Arrays.copyOfRange(persons, persons.length - count, persons.length);

    }
}

class Person {

    String name;

    public Person(String name) {
        this.name = name;
    }
}

/* Do not change code below */
public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int count = Integer.parseInt(scanner.nextLine());
        final Person[] persons = new Person[count];

        for (int i = 0; i < count; i++) {
            persons[i] = new Person(scanner.nextLine());
        }

        final String[] configs = scanner.nextLine().split("\\s+");

        final PersonSelectionAlgorithm alg = create(configs[0], Integer.parseInt(configs[1]));
        SelectionContext ctx = new SelectionContext();
        ctx.setAlgorithm(alg);

        final Person[] selected = ctx.selectPersons(persons);
        for (Person p : selected) {
            System.out.println(p.name);
        }
    }

    public static PersonSelectionAlgorithm create(String algType, int param) {
        switch (algType) {
            case "STEP": {
                return new TakePersonsWithStepAlgorithm(param);
            }
            case "LAST": {
                return new TakeLastPersonsAlgorithm(param);
            }
            default: {
                throw new IllegalArgumentException("Unknown algorithm type " + algType);
            }
        }
    }
}
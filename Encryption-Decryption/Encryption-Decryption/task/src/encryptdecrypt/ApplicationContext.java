package encryptdecrypt;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ApplicationContext {
    private AlgorithmStrategy algorithmStrategy;

    public Input processCommandLineArguments(String[] args) {
        List<String> arguments = Arrays.asList(args);
        Input input = new Input();

        if (arguments.contains("-mode")) {
            input.setMode(arguments.get(arguments.indexOf("-mode") + 1));
        }
        if (arguments.contains("-key")) {
            input.setKey(Integer.valueOf(arguments.get(arguments.indexOf("-key") + 1)));
        }
        if (arguments.contains("-out")) {
            input.setOut(arguments.get(arguments.indexOf("-out") + 1));
        }
        if(arguments.contains("-alg")) {
            input.setAlgorithm(arguments.get(arguments.indexOf("-alg") + 1));
        }

        if (arguments.contains("-data")) {
            input.setData(arguments.get(arguments.indexOf("-data") + 1));
        } else if (arguments.contains("-in")) {
            input.setIn(arguments.get(arguments.indexOf("-in") + 1));
        }

        if (input.getData().isEmpty()) {
            try {
                input.setData(new String(Files.readAllBytes(Paths.get(input.getIn()))));
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return input;
    }

    public void setAlgorithmStrategy(AlgorithmStrategy algorithmStrategy) {
        this.algorithmStrategy = algorithmStrategy;
    }

    public String process(Input input) {
        if (input.getMode().equals("enc")) {
            return this.algorithmStrategy.encrypt(input.getData(), input.getKey());
        } else if (input.getMode().equals("dec")) {
            return this.algorithmStrategy.decrypt(input.getData(), input.getKey());
        } else {
            throw new IllegalArgumentException("Error: Mode not supported");
        }
    }

    public void printOutput(Input input, String message) {
        if (input.getOut().isEmpty()) {
            System.out.println(message);
        } else {
            try (PrintWriter writer = new PrintWriter(input.getOut())) {
                writer.println(message);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

package encryptdecrypt;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ApplicationContext();
        Input input = context.processCommandLineArguments(args);

        EncodingFactory encodingFactory = new EncodingFactory();
        AlgorithmStrategy algorithmStrategy = encodingFactory.getEncodingObject(input);

        context.setAlgorithmStrategy(algorithmStrategy);
        String message = context.process(input);
        context.printOutput(input, message);
    }
}

import String.StringUsage;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringUsage inputOutput = new StringUsage();
        try {
            inputOutput.operation();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
package compiler.buildcompiler.Compiler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CodeExecutor {

    public static String runCode(String language, String code) throws IOException, InterruptedException {
        if (language.equalsIgnoreCase("java")) {
            return runJava(code);
        }
        // Add support for more languages if needed
        return "Unsupported language.";
    }

    private static String runJava(String code) throws IOException, InterruptedException {
        // Save to file
        String filename = "Main.java";
        Files.write(Paths.get(filename), code.getBytes());

        // Compile
        Process compileProcess = Runtime.getRuntime().exec("javac Main.java");
        compileProcess.waitFor();

        // Run
        Process runProcess = Runtime.getRuntime().exec("java Main");
        BufferedReader reader = new BufferedReader(new InputStreamReader(runProcess.getInputStream()));

        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }
        return output.toString();
    }
}
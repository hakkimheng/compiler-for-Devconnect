package compiler.buildcompiler.Model.Response;

import lombok.Data;

@Data
public class PistonResponse {
    private Run run;

    @Data
    public static class Run {
        private String stdout;
        private String stderr;
        private String output;
        private int code;
        private String signal;
    }
}
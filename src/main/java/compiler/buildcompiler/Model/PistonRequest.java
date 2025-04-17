package compiler.buildcompiler.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PistonRequest {
    private String language;
    private String version;
    private List<FileObject> files;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class FileObject {
        private String name;
        private String content;
    }
}
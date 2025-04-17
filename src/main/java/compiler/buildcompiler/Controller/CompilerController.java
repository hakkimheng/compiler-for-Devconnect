package compiler.buildcompiler.Controller;


import compiler.buildcompiler.Compiler.CodeExecutor;
import compiler.buildcompiler.Model.CodeRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/compile")
public class CompilerController {
    @PostMapping
    public ResponseEntity<String> compileCode(@RequestBody CodeRequest codeRequest) {
        try {
            String output = CodeExecutor.runCode(codeRequest.getLanguage(), codeRequest.getCode());
            return ResponseEntity.ok(output);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }
}

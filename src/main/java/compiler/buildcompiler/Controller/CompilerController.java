package compiler.buildcompiler.Controller;


import compiler.buildcompiler.Model.PistonRequest;
import compiler.buildcompiler.Model.Response.ApiResponse;
import compiler.buildcompiler.Model.Response.PistonResponse;
import compiler.buildcompiler.Service.PistonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/compile")
@RequiredArgsConstructor
public class CompilerController {

    private final PistonService pistonService;

    @PostMapping
    public ResponseEntity<ApiResponse<PistonResponse>> compileWithPistonRequest(@RequestBody PistonRequest pistonRequest) {
        PistonResponse output = pistonService.executeWithPistonRequest(pistonRequest);
        ApiResponse<PistonResponse> apiResponse = ApiResponse.<PistonResponse>builder()
                .status(HttpStatus.OK)
                .message("Compilation successful")
                .payload(output)
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
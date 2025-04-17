package compiler.buildcompiler.Model.Response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
public class ApiResponse <T>{
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();
    private String message;
    private HttpStatus status;
    private T payload;
}

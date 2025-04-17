package compiler.buildcompiler.Service;


import compiler.buildcompiler.Model.PistonRequest;
import compiler.buildcompiler.Model.Response.PistonResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PistonService {

    private static final String PISTON_URL = "https://emkc.org/api/v2/piston/execute";
    private final RestTemplate restTemplate = new RestTemplate();

    public PistonResponse executeWithPistonRequest(PistonRequest request) {
        if (request.getLanguage() == null || request.getVersion() == null || request.getFiles() == null) {
            throw new IllegalArgumentException("Missing required fields: language, version, or files.");
        }
        PistonResponse response = restTemplate.postForObject(
                PISTON_URL,
                request,
                PistonResponse.class
        );
        if (response == null || response.getRun() == null) {
            throw new RuntimeException("No response or run result from Piston API.");
        }
        return response;
    }
}
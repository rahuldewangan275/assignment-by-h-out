package com.example.AssignmentOptimize.HTTP.Server;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class DataController {
    private static final String DATA_PATH = "tmp/data/";

    @GetMapping("/data")
    public ResponseEntity getData(@RequestParam String n, @RequestParam(required = false) Integer m) throws IOException {
        String filePath = DATA_PATH + n + ".txt";

        try {
            if (Files.exists(Paths.get(filePath))) {
                if (m != null) {
                    // Read specific line
                    String lineContent = readLine(filePath, m);
                    return ResponseEntity.ok(lineContent);
                } else {
                    // Read entire file
                    String fileContent = readEntireFile(filePath);
                    return ResponseEntity.ok(fileContent);
                }
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("File not found for n=" + n);
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error reading the file: " + e.getMessage());
        }
    }

    private String readLine(String filePath, int lineNumber) throws IOException {
        return Files.lines(Paths.get(filePath))
                .skip(lineNumber - 1)
                .findFirst()
                .orElse("");
    }

    private String readEntireFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
    }
}

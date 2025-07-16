package Fortis_Sidera.spotform.controller;

import Fortis_Sidera.spotform.dto.DocumentRequest;
import Fortis_Sidera.spotform.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @PostMapping("/generate")
    public ResponseEntity<?> generateDocument(@RequestBody DocumentRequest request) {
        String downloadLink = documentService.generateDocument(request);
        return ResponseEntity.ok().body(new Response(downloadLink));
    }

    record Response(String url) {}

}

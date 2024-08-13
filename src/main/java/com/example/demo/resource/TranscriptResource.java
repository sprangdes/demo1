package com.example.demo.resource;

import com.example.demo.entity.Transcript;
import com.example.demo.service.TranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transcript")
public class TranscriptResource {

    @Autowired
    private TranscriptService transcriptService;

    @GetMapping("/{id}")
    public Transcript getTranscript(@PathVariable Long id) {
        return transcriptService.getTranscript(id);
    }

    @GetMapping
    public List<Transcript> getAllTranscripts() {
        return transcriptService.findAllTranscript();
    }

    @PutMapping
    public Transcript updateTranscript(Transcript transcript) {
        return transcriptService.updateTranscript(transcript);
    }

    @PostMapping
    public Transcript createTranscript(Transcript transcript) {
        return transcriptService.createTranscript(transcript);
    }

    @DeleteMapping("/{id}")
    public String deleteTranscript(@PathVariable Long id) {
        if(transcriptService.deleteTranscript(id)) {
            return "Transcript deleted.";
        }
        return "Transcript Not Found.";
    }
}

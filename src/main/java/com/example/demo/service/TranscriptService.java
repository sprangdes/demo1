package com.example.demo.service;

import com.example.demo.entity.Transcript;
import com.example.demo.repository.TranscriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class TranscriptService {

    @Autowired
    private TranscriptRepository transcriptRepository;

    public Transcript getTranscript(Long transcriptId) {
        return transcriptRepository.findById(transcriptId).orElse(null);
    }

    public List<Transcript> findAllTranscript() {
        return transcriptRepository.findAll();
    }

    public Transcript updateTranscript(Transcript transcript){
        return transcriptRepository.save(transcript);
    }

    public Transcript createTranscript(Transcript transcript){
        transcript.setId(null);
        return transcriptRepository.save(transcript);
    }

    public boolean deleteTranscript(Long Id){
        if(transcriptRepository.findById(Id).isEmpty()){
            return false;
        }
        transcriptRepository.deleteById(Id);
        return true;
    }
}

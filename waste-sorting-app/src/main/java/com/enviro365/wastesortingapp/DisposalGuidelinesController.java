package com.enviro365.wastesortingapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelinesController {
    @Autowired
    private DisposalGuidelinesService disposalGuidelinesService;

    @GetMapping
    public ResponseEntity<List<DisposalGuidelines>> getAllDisposalGuidelines() {
        List<DisposalGuidelines> guidelinesList = disposalGuidelinesService.getAllDisposalGuidelines();
        return ResponseEntity.ok(guidelinesList);
    }

    @PostMapping
    public ResponseEntity<DisposalGuidelines> createDisposalGuidelines(@Valid @RequestBody DisposalGuidelines disposalGuidelines) {
        DisposalGuidelines savedGuidelines = disposalGuidelinesService.saveDisposalGuidelines(disposalGuidelines);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGuidelines);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuidelines> updateDisposalGuidelines(@PathVariable Long id, @Valid @RequestBody DisposalGuidelines disposalGuidelines) {
        DisposalGuidelines existingGuidelines = disposalGuidelinesService.getDisposalGuidelinesById(id);
        if (existingGuidelines == null) {
            return ResponseEntity.notFound().build();
        }
        disposalGuidelines.setId(id);
        DisposalGuidelines updatedGuidelines = disposalGuidelinesService.saveDisposalGuidelines(disposalGuidelines);
        return ResponseEntity.ok(updatedGuidelines);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisposalGuidelines(@PathVariable Long id) {
        DisposalGuidelines existingGuidelines = disposalGuidelinesService.getDisposalGuidelinesById(id);
        if (existingGuidelines == null) {
            return ResponseEntity.notFound().build();
        }
        disposalGuidelinesService.deleteDisposalGuidelines(id);
        return ResponseEntity.noContent().build();
    }
}

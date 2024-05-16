package com.enviro365.wastesortingapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {
    @Autowired
    private RecyclingTipService recyclingTipService;

    @GetMapping
    public ResponseEntity<List<RecyclingTip>> getAllRecyclingTips() {
        List<RecyclingTip> tipsList = recyclingTipService.getAllRecyclingTips();
        return ResponseEntity.ok(tipsList);
    }

    @PostMapping
    public ResponseEntity<RecyclingTip> createRecyclingTip(@Valid @RequestBody RecyclingTip recyclingTip) {
        RecyclingTip savedTip = recyclingTipService.saveRecyclingTip(recyclingTip);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTip);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTip> updateRecyclingTip(@PathVariable Long id, @Valid @RequestBody RecyclingTip recyclingTip) {
        RecyclingTip existingTip = recyclingTipService.getRecyclingTipById(id);
        if (existingTip == null) {
            return ResponseEntity.notFound().build();
        }
        recyclingTip.setId(id);
        RecyclingTip updatedTip = recyclingTipService.saveRecyclingTip(recyclingTip);
        return ResponseEntity.ok(updatedTip);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecyclingTip(@PathVariable Long id) {
        RecyclingTip existingTip = recyclingTipService.getRecyclingTipById(id);
        if (existingTip == null) {
            return ResponseEntity.notFound().build();
        }
        recyclingTipService.deleteRecyclingTip(id);
        return ResponseEntity.noContent().build();
    }
}

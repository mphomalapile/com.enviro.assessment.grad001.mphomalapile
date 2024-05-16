package com.enviro365.wastesortingapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/waste-categories")
public class WasteController {
    @Autowired
    private WasteService wasteService;

    @GetMapping
    public ResponseEntity<List<WasteCategory>> getAllWasteCategories() {
        List<WasteCategory> wasteCategories = wasteService.getAllWasteCategories();
        return ResponseEntity.ok(wasteCategories);
    }

    @PostMapping
    public ResponseEntity<WasteCategory> createWasteCategory(@Valid @RequestBody WasteCategory wasteCategory) {
        WasteCategory savedCategory = wasteService.saveWasteCategory(wasteCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateWasteCategory(@PathVariable Long id, @Valid @RequestBody WasteCategory wasteCategory) {
        WasteCategory existingCategory = wasteService.getWasteCategoryById(id);
        if (existingCategory == null) {
            return ResponseEntity.notFound().build();
        }
        wasteCategory.setId(id);
        WasteCategory updatedCategory = wasteService.saveWasteCategory(wasteCategory);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWasteCategory(@PathVariable Long id) {
        WasteCategory existingCategory = wasteService.getWasteCategoryById(id);
        if (existingCategory == null) {
            return ResponseEntity.notFound().build();
        }
        wasteService.deleteWasteCategory(id);
        return ResponseEntity.noContent().build();
    }
}

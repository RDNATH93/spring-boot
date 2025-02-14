package com.example.envers.hibernate_envers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/batch")
public class BatchController {

    private final BatchService batchService;

    BatchController(BatchService batchService) {
        this.batchService = batchService;
    }

    @GetMapping("/{batchId}")
    public Batch getBatch(@PathVariable Long batchId) {
        return batchService.findBatch(batchId).orElseThrow();
    }

    @PostMapping("/add")
    Batch addBatch(@RequestBody Batch batch) {
        return batchService.addBatch(batch);
    }

    @PutMapping("/update/{batchId}")
    public Batch putMethodName(@PathVariable Long batchId, @RequestBody Batch batch) {
        return batchService.updateBatch(batchId, batch);
    }
}

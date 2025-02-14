package com.example.envers.hibernate_envers;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class BatchService {

    private final BatchRepository batchRepository;

    BatchService(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    Optional<Batch> findBatch(Long batchId){
        return batchRepository.findById(batchId);
    }

    Batch addBatch(Batch batch){
        return batchRepository.save(batch);
    }

    Batch updateBatch(Long batchId,Batch batch){
        if(batchId != batch.getId()){
            throw new RuntimeException("batchId doesn't match");
        }
        findBatch(batch.getId()).orElseThrow();
        return batchRepository.save(batch);
    }
}

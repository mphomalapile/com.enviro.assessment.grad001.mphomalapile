package com.enviro365.wastesortingapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class DisposalGuidelinesService {
    @Autowired
    private DisposalGuidelinesRepository disposalGuidelinesRepository;

    public List<DisposalGuidelines> getAllDisposalGuidelines() {
        return disposalGuidelinesRepository.findAll();
    }

    public DisposalGuidelines saveDisposalGuidelines(DisposalGuidelines disposalGuidelines) {
        return disposalGuidelinesRepository.save(disposalGuidelines);
    }

    public DisposalGuidelines updateDisposalGuidelines(DisposalGuidelines disposalGuidelines) {
        return disposalGuidelinesRepository.save(disposalGuidelines);
    }

    public void deleteDisposalGuidelines(Long id) {
        disposalGuidelinesRepository.deleteById(id);
    }

    public DisposalGuidelines getDisposalGuidelinesById(Long id) {
        Optional<DisposalGuidelines> guidelinesOptional = disposalGuidelinesRepository.findById(id);
        return guidelinesOptional.orElse(null);
    }
}

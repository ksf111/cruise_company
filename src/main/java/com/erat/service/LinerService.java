package com.erat.service;

import com.erat.annotation.Inject;
import com.erat.annotation.Service;
import com.erat.db.LinerRepository;
import com.erat.db.entity.Liner;

@Service
public class LinerService {

    @Inject
    private final LinerRepository linerRepository;

    public LinerService(LinerRepository linerRepository) {
        this.linerRepository = linerRepository;
    }

    public Liner createLiner(Liner liner) {
        // check if data is entered correctly (e.g. validate dates). This is called 'Business logic'
        return linerRepository.create(liner);
    }

    public boolean deleteLiner (String name){
        return linerRepository.deleteByName(name);
    }
}

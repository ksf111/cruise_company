package com.epam.service;

import com.epam.annotation.Inject;
import com.epam.annotation.Service;
import com.epam.db.LinerRepository;
import com.epam.db.entity.Liner;

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

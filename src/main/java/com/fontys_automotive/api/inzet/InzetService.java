package com.fontys_automotive.api.inzet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InzetService {

    private final InzetRepository inzetRepository;

    @Autowired
    public InzetService(InzetRepository inzetRepository) {
        this.inzetRepository = inzetRepository;
    }


}

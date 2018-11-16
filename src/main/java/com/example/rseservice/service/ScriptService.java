package com.example.rseservice.service;

import com.example.rseservice.entity.Script;
import com.example.rseservice.entity.repository.ScriptRepository;
import com.example.rseservice.service.exception.ScriptNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScriptService {

    private final ScriptRepository scriptRepository;

    @Autowired
    public ScriptService(ScriptRepository scriptRepository) {
        this.scriptRepository = scriptRepository;
    }

    public Script save(Script script) {
        return this.scriptRepository.save(script);
    }

    public Script findScriptById(Long id) {
        return this.scriptRepository.findById(id)
                .orElseThrow(ScriptNotFoundException::new);
    }

    public void delete(Script script){
        this.scriptRepository.delete(script);
    }

}

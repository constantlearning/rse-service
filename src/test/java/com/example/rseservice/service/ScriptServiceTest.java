package com.example.rseservice.service;

import com.example.rseservice.entity.Client;
import com.example.rseservice.entity.Script;
import com.example.rseservice.entity.repository.ScriptRepository;
import com.example.rseservice.service.exception.ScriptNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ScriptServiceTest {

    private ScriptService scriptService;

    @Mock
    private ScriptRepository scriptRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        this.scriptService = new ScriptService(scriptRepository);
    }

    @Test
    void should_create_new_script() {

        Script script = buildScript();
        Script scriptInDatabase = buildScript();

        when(scriptRepository.save(script)).thenReturn(scriptInDatabase);

        Script newScript = this.scriptService.save(script);

        assertEquals(scriptInDatabase, newScript);
    }

    @Test
    void should_get_script_from_id() {

        Script script = buildScript();

        when(scriptRepository.findById(1L)).thenReturn(Optional.of(script));

        Script scriptFindById = this.scriptService.findScriptById(1L);

        assertNotNull(scriptFindById);
        assertEquals(Long.valueOf(1L), scriptFindById.getId());
    }

    @Test
    void should_deny_find_script_if_not_exists() {

        Script script = buildScript();

        when(scriptRepository.findById(1L)).thenReturn(Optional.of(script));

        assertThrows(ScriptNotFoundException.class, () -> this.scriptService.findScriptById(9L));
    }

    private Script buildScript() {

        String javaScriptContent = "function myFunction(p1, p2) {" +
                "    return p1 * p2;" +
                "}";

        final Client client = Client.ClientBuilder.aClient()
                .id(2L)
                .document("123456")
                .name("Lucas Gontijo")
                .birthDay(LocalDate.of(1994, 7, 1))
                .build();

        final Script script = Script
                .Build.aScript()
                .id(1L)
                .client(client)
                .content(javaScriptContent)
                .howManyArguments(2L)
                .build();

        client.setScripts(List.of(script));

        return script;
    }
}
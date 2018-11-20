package com.example.rseservice.controller;

import com.example.rseservice.domain.Client;
import com.example.rseservice.domain.User;
import com.example.rseservice.domain.request.ClientRequest;
import com.example.rseservice.domain.response.ClientResponse;
import com.example.rseservice.service.implement.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping(value="")
public class ClientController {

    @Autowired
    private ClientService clientService;

//    @PostMapping()
//    public ResponseEntity create(@Valid @RequestBody ClientRequest clientRequest) {
//        ClientResponse clientResponse = clientService.create(clientRequest);
//        return new ResponseEntity<>(clientResponse, HttpStatus.CREATED);
//    }
//
//    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity update(@PathVariable("id") Long id, @Valid @RequestBody ClientRequest clientRequest) {
//        ClientResponse clientResponse = clientService.update(clientRequest, id);
//        return new ResponseEntity<>(clientResponse, HttpStatus.OK);
//    }
//
//    @GetMapping(value = "/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity get(@PathVariable("clientId") Long clientId) {
//        ClientResponse clientResponse = clientService.findById(clientId);
//        return new ResponseEntity<>(clientResponse, HttpStatus.OK);
//    }
//
//    @DeleteMapping()
//    public ResponseEntity cancelUser(@Valid @RequestBody ClientRequest clientRequest) {
//
//        clientService.cancelUser(clientRequest);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @GetMapping(value={"/home"})
    public ModelAndView home(Principal principal) {

        Client client = this.clientService.findByUsername(principal.getName());
        ModelAndView mv = new ModelAndView("/home");
        mv.addObject("client", client);
        return mv;
    }

    @GetMapping(value="/add")
    public ModelAndView add(Client client) {

        ModelAndView mv = new ModelAndView("/client_create");
        mv.addObject("client", client);
        return mv;
    }

    @PostMapping(value="/save")
    public ModelAndView save(@RequestParam(value = "password") String password, @RequestParam(value = "username") String username, @RequestParam(value = "cpf") String cpf) {
        Client client = new Client();
        client.setUsername(username);
        client.setCpf(cpf);
        client = clientService.create(client, password);

        return new ModelAndView("redirect:/home");
    }
}

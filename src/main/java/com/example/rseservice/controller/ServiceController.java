package com.example.rseservice.controller;

import com.example.rseservice.config.feign.request.CGIRequest;
import com.example.rseservice.config.feign.response.CGIResponse;
import com.example.rseservice.config.feign.service.CGIService;
import com.example.rseservice.domain.Client;
import com.example.rseservice.domain.Service;
import com.example.rseservice.domain.request.ServiceRequest;
import com.example.rseservice.domain.response.ServiceResponse;
import com.example.rseservice.service.implement.ClientService;
import com.example.rseservice.service.implement.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="service")
public class ServiceController {

    @Autowired
    private ServiceService serviceS;

    @Autowired
    private ClientService clientService;

    @Autowired
    private CGIService cgiService;

//    @PostMapping()
//    public ResponseEntity create(@Valid @RequestBody ServiceRequest serviceRequest) {
//        Service serviceResponse = serviceS.create(serviceRequest);
//        return new ResponseEntity<>(serviceResponse, HttpStatus.CREATED);
//    }
//
//    @GetMapping(value = "/{serviceId}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity getService(@PathVariable("serviceId") Long serviceId) {
//        ServiceResponse service = serviceS.findById(serviceId);
//        return new ResponseEntity<>(service, HttpStatus.OK);
//    }
//
//    @GetMapping(value = "/services/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity getServices(@PathVariable("clientId") Long clientId) {
//        List<ServiceResponse> services = serviceS.findAll(clientId);
//        return new ResponseEntity<>(services, HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ModelAndView serviceDetailView(@PathVariable(value="id") Long service_id) {
        Service service = this.serviceS.findById(service_id);
        ModelAndView mv = new ModelAndView("/service_detail");
        mv.addObject("service", service);
        return mv;
    }

    @GetMapping("/cgi")
    public ModelAndView cgi() {

        // TESTE DE CHAMADA CGI


        CGIRequest cgiRequest = dummyCgiRequest();

        CGIResponse cgiResponse = cgiService.execute(cgiRequest);

        System.out.println();
        System.out.println(cgiResponse);
        System.out.println();


        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/add")
    public ModelAndView serviceCreateView(){
        return new ModelAndView("service_create");
    }

    @PostMapping("/activate")
    public ModelAndView serviceActivate(@RequestParam(value="id") Long service_id) {
        Service service = this.serviceS.findById(service_id);
        service.setEnabled(true);
        this.serviceS.update(service);
        ModelAndView mv = new ModelAndView("/service_detail");
        mv.addObject("service", service);
        return mv;
    }

    @PostMapping("/disable")
    public ModelAndView serviceDisable(@RequestParam(value="id") Long service_id) {


        Service service = this.serviceS.findById(service_id);
        service.setEnabled(false);
        this.serviceS.update(service);
        ModelAndView mv = new ModelAndView("/service_detail");
        mv.addObject("service", service);
        return mv;
    }

    @PostMapping("/")
    public ModelAndView serviceCreate(Principal principal, @RequestParam("title") String title, @RequestParam("language") String language, @RequestParam("code") String code){
        Client client = this.clientService.findByUsername(principal.getName());

        Service service = new Service();
        service.setTitle(title);
        service.setLanguage(language);
        service.setCode(code);
        service.setEnabled(true);
        service.setClient(client);
        service = this.serviceS.create(service);

        return new ModelAndView("redirect:/home");
    }

    private CGIRequest dummyCgiRequest() {
        Long id = 1L;

        String type = "php";

        Long howManyArguments = 2L;

        String content = "ZnVuY3Rpb24gc3VtKCR2YWwxLCAkdmFsMiwgJG9wKXsKCWlmKCBlbXB0eSgkdmFsMSkgfCBlbXB0eSgkdmFsMikgfCBlbXB0eSgkb3ApICkKCQlkaWUoKTsKCgkkcmVzdWx0ID0gbnVsbDsKCXN3aXRjaCAoJG9wKSB7CgkJY2FzZSAnYWRpY2FvJzoKCQkJJHJlc3VsdCA9ICR2YWwxICsgJHZhbDI7CgkJCWJyZWFrOwoJCWNhc2UgJ3N1YnRyYWNhbyc6CgkJCSRyZXN1bHQgPSAkdmFsMSAtICR2YWwyOwoJCQlicmVhazsKCQljYXNlICdtdWx0aXBsaWNhY2FvJzoKCQkJJHJlc3VsdCA9ICR2YWwxICogJHZhbDI7CgkJCWJyZWFrOwoJCWNhc2UgJ2RpdmlzYW8nOgoJCQkkcmVzdWx0ID0gJHZhbDEgLyAkdmFsMjsKCQkJYnJlYWs7CgkJZGVmYXVsdDoKCQkJYnJlYWs7Cgl9CgoJcmV0dXJuICRyZXN1bHQ7Cn0";;

        List<String> args = new ArrayList<>();
        args.add("1");
        args.add("2");
        args.add("adicao");

        return new CGIRequest(id,type,howManyArguments,content,args);
    }
}

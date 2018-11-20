package com.example.rseservice.controller;

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
import java.util.List;

@Controller
@RequestMapping(value="service")
public class ServiceController {

    @Autowired
    private ServiceService serviceS;

    @Autowired
    private ClientService clientService;

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
}

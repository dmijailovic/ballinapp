package com.ballinapp.controller;

import com.ballinapp.data.NewRequest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ballinapp.data.Request;
import com.ballinapp.service.RequestService;

@RestController
public class RequestController {

    @Autowired
    private final RequestService requestService = RequestService.getInstance();

    @RequestMapping(value = "/requests", method = RequestMethod.POST)
    public void sendRequest(@RequestBody Request request) {
        requestService.sendRequest(request);
    }

    @RequestMapping(value = "/requests/{id}", method = RequestMethod.GET)
    public Request getRequestById(@PathVariable int id) {
        return requestService.getRequestById(id);
    }

    @RequestMapping(value = "/requests/new/{id}", method = RequestMethod.GET)
    public List<NewRequest> getRequests(@PathVariable Long id) {
        return requestService.getRequests(id);
    }

    @RequestMapping(value = "/requests/{teamId}", method = RequestMethod.DELETE)
    public void deleteAllRequests(@PathVariable Long teamId) {
        requestService.deleteAllRequests(teamId);
    }
}

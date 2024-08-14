package com.diffie.controller;

import com.diffie.model.DiffieRequest;
import com.diffie.model.DiffieResponse;
import com.diffie.service.DiffieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diffie")
public class DiffieController
{
    @Autowired
    private DiffieService service;

    @GetMapping("/{id}")
    public ResponseEntity<DiffieResponse> getRecord(@PathVariable("id") String userId) {
        DiffieResponse response = service.getRecordById(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createRecord(@RequestBody DiffieRequest request){
        String createdMessage = service.createRecord(request);
        return new ResponseEntity<>(createdMessage,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecord(@PathVariable("id") String userId){
        String deleteMessage = service.deleteRecord(userId);
        return new ResponseEntity<>(deleteMessage,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateRecord(@RequestBody DiffieRequest request){
        String updateMessage = service.updateRecord(request);
        return new ResponseEntity<>(updateMessage,HttpStatus.OK);
    }

}

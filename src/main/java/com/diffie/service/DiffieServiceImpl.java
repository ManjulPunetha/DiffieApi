package com.diffie.service;

import com.diffie.entity.DiffieEntity;
import com.diffie.model.DiffieRequest;
import com.diffie.model.DiffieResponse;
import com.diffie.repository.DiffieRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiffieServiceImpl implements DiffieService
{
    @Autowired
    private DiffieRepository repository;

    @Override
    public String createRecord(DiffieRequest request) {
        repository.createRecord(request);
        return "Record with id: " + request.getUserId() + " created.";
    }

    @Override
    public DiffieResponse getRecordById(String userId) {
        DiffieEntity diffieEntity = repository.getRecordById(userId);
        DiffieResponse diffieResponse = new DiffieResponse();
        BeanUtils.copyProperties(diffieEntity, diffieResponse);
        return diffieResponse;
    }

    @Override
    public String deleteRecord(String userId) {
        repository.deleteRecord(userId);
        return "Record with id: " + userId + " deleted.";
    }

    @Override
    public String updateRecord(DiffieRequest request) {
        repository.updateRecord(request);
        return "Record with id: " + request.getUserId() + " updated.";
    }
}

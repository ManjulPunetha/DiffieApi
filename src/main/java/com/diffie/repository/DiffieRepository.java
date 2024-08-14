package com.diffie.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.diffie.entity.DiffieEntity;
import com.diffie.model.DiffieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DiffieRepository
{
    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public void createRecord(DiffieRequest diffieRequest) {
        dynamoDBMapper.save(diffieRequest);
    }

    public DiffieEntity getRecordById(String userId) {
        return dynamoDBMapper.load(DiffieEntity.class, userId);
    }

    public void deleteRecord(String userId) {
        DiffieEntity diffieEntity = dynamoDBMapper.load(DiffieEntity.class, userId);
        dynamoDBMapper.delete(diffieEntity);
    }

    public void updateRecord(DiffieRequest request){
        DiffieEntity diffieEntity = dynamoDBMapper.load(DiffieEntity.class, request.getUserId());
        diffieEntity.setGenerator(request.getGenerator());
        diffieEntity.setPrimeNum(request.getPrimeNum());
        dynamoDBMapper.save(diffieEntity);
    }
}

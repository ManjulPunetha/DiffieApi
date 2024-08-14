package com.diffie.service;

import com.diffie.model.DiffieRequest;
import com.diffie.model.DiffieResponse;

import java.math.BigInteger;

public interface DiffieService
{
    String createRecord(DiffieRequest request);

    DiffieResponse getRecordById(String userId);

    String deleteRecord(String userId);

    String updateRecord(DiffieRequest request);
}

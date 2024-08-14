package com.diffie.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;

import java.math.BigInteger;

@Data
@DynamoDBTable(tableName = "diffie")
public class DiffieRequest
{
    @DynamoDBHashKey
    private String userId;

    @DynamoDBAttribute
    private BigInteger generator;

    @DynamoDBAttribute
    private BigInteger primeNum;
}

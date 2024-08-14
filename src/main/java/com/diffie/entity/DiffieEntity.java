package com.diffie.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamoDBTable(tableName = "diffie")
public class DiffieEntity
{
    @DynamoDBHashKey
    private String userId;

    @DynamoDBAttribute
    private BigInteger generator;

    @DynamoDBAttribute
    private BigInteger primeNum;
}

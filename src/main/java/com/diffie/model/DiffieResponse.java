package com.diffie.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
public class DiffieResponse
{
    private String userId;
    private BigInteger generator;
    private BigInteger primeNum;
}

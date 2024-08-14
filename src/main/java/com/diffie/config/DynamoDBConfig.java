package com.diffie.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDBConfig
{
    @Value("${amazon.dynamodb.serviceEndpoint}")
    private String amazonDynamoDBServiceEndpoint;

    @Value("${amazon.dynamodb.signingRegion}")
    private String amazonDynamoDBSigningRegion;

    @Value("${amazon.aws.accesskey}")
    private String amazonAWSAccessKey;

    @Value("${amazon.aws.secretkey}")
    private String amazonAWSSecretKey;

    @Bean
    public DynamoDBMapper dynamoDBMapper() {
        return new DynamoDBMapper(buildAmazonDynamoDB());
    }

    private AmazonDynamoDB buildAmazonDynamoDB() {
        return AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(amazonDynamoDBServiceEndpoint
                                , amazonDynamoDBSigningRegion
                        ))
                .withCredentials(
                        new AWSStaticCredentialsProvider(
                                new BasicAWSCredentials(amazonAWSAccessKey,
                                        amazonAWSSecretKey
                                )))
                .build();
    }
}

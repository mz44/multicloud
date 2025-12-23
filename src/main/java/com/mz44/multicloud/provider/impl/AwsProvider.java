package com.mz44.multicloud.provider.impl;

import com.mz44.multicloud.provider.CloudProvider;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AwsProvider implements CloudProvider {
    @Override
    public String getName() {
        return "aws";
    }

    @Override
    public Map<String, Object> getAccountDetails(String accountId) {
        // Placeholder skeleton for AWS integration
        return Map.of("accountId", accountId, "provider", "aws", "status", "stub");
    }
}

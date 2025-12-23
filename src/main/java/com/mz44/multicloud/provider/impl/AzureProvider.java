package com.mz44.multicloud.provider.impl;

import com.mz44.multicloud.provider.CloudProvider;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AzureProvider implements CloudProvider {
    @Override
    public String getName() {
        return "azure";
    }

    @Override
    public Map<String, Object> getAccountDetails(String accountId) {
        // Placeholder skeleton for Azure integration
        return Map.of("accountId", accountId, "provider", "azure", "status", "stub");
    }
}

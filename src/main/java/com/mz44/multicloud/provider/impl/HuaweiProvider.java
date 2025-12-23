package com.mz44.multicloud.provider.impl;

import com.mz44.multicloud.provider.CloudProvider;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class HuaweiProvider implements CloudProvider {
    @Override
    public String getName() {
        return "huawei";
    }

    @Override
    public Map<String, Object> getAccountDetails(String accountId) {
        return Map.of("accountId", accountId, "provider", "huawei", "status", "stub");
    }
}

package com.mz44.multicloud.provider.impl;

import com.mz44.multicloud.provider.CloudProvider;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TencentProvider implements CloudProvider {
    @Override
    public String getName() {
        return "tencent";
    }

    @Override
    public Map<String, Object> getAccountDetails(String accountId) {
        return Map.of("accountId", accountId, "provider", "tencent", "status", "stub");
    }
}

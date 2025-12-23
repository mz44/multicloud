package com.mz44.multicloud.provider;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ProviderRegistry {
    private final List<CloudProvider> providers;

    public ProviderRegistry(List<CloudProvider> providers) {
        this.providers = providers;
    }

    public List<String> listProviderNames() {
        return providers.stream().map(CloudProvider::getName).collect(Collectors.toList());
    }

    public CloudProvider getByName(String name) {
        return providers.stream().filter(p -> p.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public Map<String, Object> getAccountDetails(String providerName, String accountId) {
        CloudProvider p = getByName(providerName);
        if (p == null) return null;
        return p.getAccountDetails(accountId);
    }
}

package com.mz44.multicloud.provider;

import java.util.Map;

public interface CloudProvider {
    String getName();
    Map<String, Object> getAccountDetails(String accountId);
}

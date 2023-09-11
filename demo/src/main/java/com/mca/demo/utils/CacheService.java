package com.mca.demo.utils;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

    @CacheEvict(value = "apiDataCache", key = "#apiEndpoint")
    public void clearApiDataCache(String apiEndpoint) {
        // This method clears the cache for the specified 'apiEndpoint'
    }

    // Clears the cache daily at midnight
    @CacheEvict(value = "similarProductsCache", allEntries = true)
    @Scheduled(cron = "0 0 0 * * ?")
    public void clearDailyCache() {
        // This method clears the entire cache daily at midnight
    }
}

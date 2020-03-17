package com.hujy.demo.hint;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

public class ShardingTable implements PreciseShardingAlgorithm<Integer> {
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Integer> preciseShardingValue) {
        long value = 0;
        try {
            value = preciseShardingValue.getValue();
        } catch (Exception e) {
            value = Math.abs(preciseShardingValue.getValue().hashCode());
        }
        for (String tableName : availableTargetNames) {
            if (tableName.endsWith(String.valueOf(value % 2))) {
                return tableName;
            }
        }
        throw new IllegalArgumentException();
    }
}

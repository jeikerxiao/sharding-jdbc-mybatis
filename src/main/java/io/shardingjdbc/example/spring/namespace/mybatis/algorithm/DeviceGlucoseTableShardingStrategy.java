package io.shardingjdbc.example.spring.namespace.mybatis.algorithm;

import io.shardingjdbc.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * Description: 设备血糖表-分表策略(sn)
 * Created by jeikerxiao on 2018/7/13 下午5:10
 */
public class DeviceGlucoseTableShardingStrategy implements PreciseShardingAlgorithm<Long> {

    private Logger log = LoggerFactory.getLogger(PreciseModuloTableShardingAlgorithm.class);

    private int tableCount = 10;

    @Override
    public String doSharding(final Collection<String> availableTargetNames, final PreciseShardingValue<Long> shardingValue) {
        for (String each : availableTargetNames) {
            // 根据分表键值，确定数据落入的数据库
            if (each.endsWith(Math.abs(shardingValue.hashCode()) % tableCount + 1 + "")) {
                // 返回真实的数据库表名
                System.out.println("logicTable: " + shardingValue);
                log.info("table name: {}", each);
                System.out.println("table name: " + each);
                return each;
            }
        }
        throw new UnsupportedOperationException();
    }
}

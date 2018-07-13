/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingjdbc.example.spring.namespace.mybatis.algorithm;

import io.shardingjdbc.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

public final class PreciseModuloTableShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    private Logger log = LoggerFactory.getLogger(PreciseModuloTableShardingAlgorithm.class);
    
    @Override
    public String doSharding(final Collection<String> availableTargetNames, final PreciseShardingValue<Long> shardingValue) {
        for (String each : availableTargetNames) {
            // 根据分表键值，确定数据落入的数据库
            if (each.endsWith(shardingValue.getValue() % 10 + "")) {
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

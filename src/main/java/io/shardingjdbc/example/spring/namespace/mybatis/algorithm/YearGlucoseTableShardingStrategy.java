package io.shardingjdbc.example.spring.namespace.mybatis.algorithm;

import cn.hutool.core.date.DateUtil;
import io.shardingjdbc.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Date;

/**
 * Description: 年度血糖表-分表策略
 * Created by jeikerxiao on 2018/7/13 下午5:11
 */
public class YearGlucoseTableShardingStrategy implements PreciseShardingAlgorithm<Date> {

    private Logger log = LoggerFactory.getLogger(PreciseModuloTableShardingAlgorithm.class);

    @Override
    public String doSharding(final Collection<String> availableTargetNames, final PreciseShardingValue<Date> shardingValue) {
        for (String each : availableTargetNames) {
            // 根据分表键值，确定数据落入的数据库
            // shardingValue 为 测试时间
            String year = DateUtil.format(shardingValue.getValue(), "yyyy");

            if (each.endsWith(year)) {
                // 返回真实的数据库表名
                System.out.println("logicTable: " + shardingValue);
                log.info("table name: {}", each);
                System.out.println("table name: " + each);
                return each;
            }
        }
        log.error("out of table");
        throw new UnsupportedOperationException();
    }

    /**
     private static final String	YEAR_RULE_FORMAT	= "yyyy";

     @Override protected <T> String praseShardingKeyTableName(T t) {
     if(t!=null){
     if(t instanceof QueryVO){
     return getTableName(DateUtils.getDateTime(((QueryVO) t).getBeginTestDate()));
     }
     if(t instanceof SncGlucoseData){
     return getTableName(((SncGlucoseData) t).getTestTime());
     }
     if(t instanceof SharpQueryVO) {
     return logicTableName+TABLE_LINK_SYMBOL+((SharpQueryVO)t).getYear();
     }
     if(t instanceof SncGlucoseDataExample){
     for(Criteria cr:((SncGlucoseDataExample) t).getOredCriteria()){
     for(Criterion crion:cr.getCriteria()){
     if(StringUtils.containsIgnoreCase(crion.getCondition(), shardingColumns)
     && crion.getValue()!=null){
     return getTableName(crion.getValue());
     }
     }
     }
     }
     }
     return logicTableName;
     }



     @Override protected String getTableName(Object testDate){
     String year = DateUtils.formatDate((Date) testDate,YEAR_RULE_FORMAT);
     return logicTableName+TABLE_LINK_SYMBOL+year;
     }
     */
}

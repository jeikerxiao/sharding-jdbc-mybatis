package io.shardingjdbc.example.spring.namespace.mybatis.algorithm;

import io.shardingjdbc.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * Description: 用户血糖表-分表策略
 * Created by jeikerxiao on 2018/7/13 下午5:11
 */
public class UserGlucoseTableShardingStrategy implements PreciseShardingAlgorithm<Long> {

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

    /**默认分10个表，spring-dao-sharding.xml中可以配置(但是加表后会导致数据错乱，所以日后如果10个表不满足，加表的时候需要先将数据整理好)*/
    /**
     private int tableCount=10;

     public int getTableCount() {
     return tableCount;
     }

     public void setTableCount(int tableCount) {
     this.tableCount = tableCount;
     }


     @Override protected <T> String praseShardingKeyTableName(T t) {
     if(t!=null){
     if(t instanceof SncUserGlucoseData){
     return getTableName(((SncUserGlucoseData) t).getUserCode());
     }
     if(t instanceof AppRequestUserGlucoseVo){
     return getTableName(((AppRequestUserGlucoseVo) t).getUserCode());
     }
     if(t instanceof SncUserGlucoseDataExample){
     for(Criteria cr:((SncUserGlucoseDataExample) t).getOredCriteria()){
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


     public String getTableName(Object userCode){
     int tableSuffix=Math.abs(userCode.hashCode())%tableCount+1;
     return logicTableName+TABLE_LINK_SYMBOL+tableSuffix;
     }

     public static void main(String[] args) {
     UserOfGlucoseSingleKeyTableShardingAlgorithm d=new UserOfGlucoseSingleKeyTableShardingAlgorithm();
     d.setLogicTableName("snc_user_glucose_data");
     System.out.println(d.getTableName("wx_ohoqaw8S6vpbZDiPEGkTk6sB2bko"));
     }

     */
}

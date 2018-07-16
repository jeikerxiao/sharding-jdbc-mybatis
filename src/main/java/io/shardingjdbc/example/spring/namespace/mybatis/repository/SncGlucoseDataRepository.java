package io.shardingjdbc.example.spring.namespace.mybatis.repository;

import io.shardingjdbc.example.spring.namespace.mybatis.entity.SncGlucoseData;

import java.util.List;

/**
 * Description: sharding-jdbc-mybatis
 * Created by jeikerxiao on 2018/7/16 上午9:44
 */
public interface SncGlucoseDataRepository {

    void createIfNotExistsTable();

    void truncateTable();

    Long insert(SncGlucoseData model);

    void delete(Long id);

    void dropTable();

    List<SncGlucoseData> selectAll();

}

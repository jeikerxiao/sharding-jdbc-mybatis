package io.shardingjdbc.example.spring.namespace.mybatis.repository;

import io.shardingjdbc.example.spring.namespace.mybatis.entity.SncUserGlucoseData;

import java.util.List;

/**
 * Description: sharding-jdbc-mybatis
 * Created by jeikerxiao on 2018/7/16 上午9:44
 */
public interface SncUserGlucoseDataRepository {

    void createIfNotExistsTable();

    void truncateTable();

    Long insert(SncUserGlucoseData model);

    void delete(Long id);

    void dropTable();

    List<SncUserGlucoseData> selectAll();

}

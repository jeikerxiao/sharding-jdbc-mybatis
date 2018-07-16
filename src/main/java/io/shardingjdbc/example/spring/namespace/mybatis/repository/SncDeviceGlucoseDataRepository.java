package io.shardingjdbc.example.spring.namespace.mybatis.repository;

import io.shardingjdbc.example.spring.namespace.mybatis.entity.SncDeviceGlucoseData;

import java.util.List;

/**
 * Description: sharding-jdbc-mybatis
 * Created by jeikerxiao on 2018/7/16 上午9:44
 */
public interface SncDeviceGlucoseDataRepository {

    void createIfNotExistsTable();

    void truncateTable();

    Long insert(SncDeviceGlucoseData model);

    void delete(Long id);

    void dropTable();

    List<SncDeviceGlucoseData> selectAll();


}

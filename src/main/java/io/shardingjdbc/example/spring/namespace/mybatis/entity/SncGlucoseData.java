package io.shardingjdbc.example.spring.namespace.mybatis.entity;

import java.util.Date;

/**
 * Description: sharding-jdbc-mybatis
 * Created by jeikerxiao on 2018/7/16 上午9:41
 */
public class SncGlucoseData {

    private long id;
    private String sn;
    private String userCode;
    private Date testTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Date getTestTime() {
        return testTime;
    }

    public void setTestTime(Date testTime) {
        this.testTime = testTime;
    }

    @Override
    public String toString() {
        return "SncDeviceGlucoseData{" +
                "id=" + id +
                ", sn='" + sn + '\'' +
                ", userCode='" + userCode + '\'' +
                ", testTime=" + testTime +
                '}';
    }
}

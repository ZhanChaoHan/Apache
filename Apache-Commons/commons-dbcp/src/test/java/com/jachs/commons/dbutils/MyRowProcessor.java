package com.jachs.commons.dbutils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.RowProcessor;

public class MyRowProcessor implements RowProcessor {

    /** 
     * @Title: toArray
     * @Description: TODO
     * @param rs
     * @return
     * @throws SQLException 
     * @see org.apache.commons.dbutils.RowProcessor#toArray(java.sql.ResultSet) 
     */ 
    public Object[] toArray ( ResultSet rs ) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * @Title: toBean
     * @Description: TODO
     * @param <T>
     * @param rs
     * @param type
     * @return
     * @throws SQLException 
     * @see org.apache.commons.dbutils.RowProcessor#toBean(java.sql.ResultSet, java.lang.Class) 
     */ 
    public <T> T toBean ( ResultSet rs , Class<? extends T> type ) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * @Title: toBeanList
     * @Description: TODO
     * @param <T>
     * @param rs
     * @param type
     * @return
     * @throws SQLException 
     * @see org.apache.commons.dbutils.RowProcessor#toBeanList(java.sql.ResultSet, java.lang.Class) 
     */ 
    public <T> List<T> toBeanList ( ResultSet rs , Class<? extends T> type ) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * @Title: toMap
     * @Description: TODO
     * @param rs
     * @return
     * @throws SQLException 
     * @see org.apache.commons.dbutils.RowProcessor#toMap(java.sql.ResultSet) 
     */ 
    public Map<String, Object> toMap ( ResultSet rs ) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }


}

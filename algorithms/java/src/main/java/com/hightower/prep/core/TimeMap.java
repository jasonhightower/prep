package com.hightower.prep.core;

public interface TimeMap {

    void set(String key, String value, long timestamp);

    String get(String key, long timestamp);

}

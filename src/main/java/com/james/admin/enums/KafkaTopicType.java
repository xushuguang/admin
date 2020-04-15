package com.james.admin.enums;

public enum KafkaTopicType {

    TEST1("test1","测试1"),
    TEST2("test2","测试2"),
    TEST3("test3","测试3");
    public String value;
    public String name;

    KafkaTopicType(String value,String name){
        this.value = value;
        this.name = name;
    }
}

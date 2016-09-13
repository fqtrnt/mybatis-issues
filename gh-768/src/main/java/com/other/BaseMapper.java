package com.other;

public interface BaseMapper<Example, Model, ModelKey> extends BaseNoKeyMapper<Example, Model> {

  int deleteByPrimaryKey(ModelKey modelKey);

}
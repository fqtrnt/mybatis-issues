package com.other;

import org.apache.ibatis.annotations.Param;

public interface BaseNoKeyMapper<Example, Model> {

//  int updateByExampleSelective(Model record, Example example);
  int updateByExampleSelective(@Param("record") Model record, @Param("example") Example example);
}
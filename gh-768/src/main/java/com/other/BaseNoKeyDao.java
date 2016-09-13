
package com.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public abstract class BaseNoKeyDao<Example, Model> {

  @Autowired
  private BaseNoKeyMapper<Example, Model> baseMapper;

  public int updateByExampleSelective(Model record, Example example) {
    return baseMapper.updateByExampleSelective(record, example);
  }

}

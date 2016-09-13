
package com.other;

import org.springframework.stereotype.Component;

@Component
public abstract class BaseDao<Example, Model extends BaseDto, ModelKey extends BaseDto>
    extends BaseNoKeyDao<Example, Model> {
}


package com.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DatetaskLogicImpl implements DatetaskLogic {

    /** Dao */
    @Autowired
    private DateTaskDao orgdateDao;
    @Transactional(propagation = Propagation.REQUIRED)
    public int execute(DateTaskDto u) {
        DateTaskExample example = new DateTaskExample();
        DateTaskExample.Criteria cr = example.createCriteria();
        cr.andDateTaskIdEqualTo(u.getDateTaskId());
        DateTask dateTask = new DateTask();
        dateTask.setDateTaskName("0");
        return orgdateDao.updateByExampleSelective(dateTask, example);
    }

}


package com.other;

import java.io.Serializable;

public abstract class BaseDto implements Serializable {

    /** serialVersionUID */

    private static final long serialVersionUID = -568485323780966755L;

    private String exclusiveDatetime;

    private String exclusiveFlag;

    private String updateDatetime;

    private String updateUserId;

    private String updateApp;

    private String updateUserIp;

    /**
     * @return the exclusiveFlag
     */
    public String getExclusiveFlag() {

        return exclusiveFlag;
    }

    /**
     * @param exclusiveFlag the exclusiveFlag to set
     */
    public void setExclusiveFlag(String exclusiveFlag) {

        this.exclusiveFlag = exclusiveFlag;
    }

    /**
     * @return the exclusiveDatetime
     */
    public String getExclusiveDatetime() {

        return exclusiveDatetime;
    }

    /**
     * @param exclusiveDatetime the exclusiveDatetime to set
     */
    public void setExclusiveDatetime(String exclusiveDatetime) {

        this.exclusiveDatetime = exclusiveDatetime;
    }

    /**
     * @return the updateDatetime
     */
    public String getUpdateDatetime() {

        return updateDatetime;
    }

    /**
     * @param updateDatetime the updateDatetime to set
     */
    public void setUpdateDatetime(String updateDatetime) {

        this.updateDatetime = updateDatetime;
    }

    /**
     * @return the updateUserId
     */
    public String getUpdateUserId() {

        return updateUserId;
    }

    /**
     * @param updateUserId the updateUserId to set
     */
    public void setUpdateUserId(String updateUserId) {

        this.updateUserId = updateUserId;
    }

    /**
     * @return the updateApp
     */
    public String getUpdateApp() {

        return updateApp;
    }

    /**
     * @param updateApp the updateApp to set
     */
    public void setUpdateApp(String updateApp) {

        this.updateApp = updateApp;
    }

    /**
     * @return the updateUserIp
     */
    public String getUpdateUserIp() {

        return updateUserIp;
    }

    /**
     * @param updateUserIp the updateUserIp to set
     */
    public void setUpdateUserIp(String updateUserIp) {

        this.updateUserIp = updateUserIp;
    }
}

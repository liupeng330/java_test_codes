package com.heika.test.entities.verify;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "verify_user", schema = "", catalog = "heika_new")
public class VerifyUserEntity
{
    private Integer id;
    private String email;
    private String realName;
    private Timestamp createTime;
    private Integer loginTimes;
    private Timestamp lastLoginTime;
    private Integer isAdmin;
    private Integer isDelete;
    private Integer version;

    @Id
    @Column(name = "id")
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    @Basic
    @Column(name = "email")
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Basic
    @Column(name = "real_name")
    public String getRealName()
    {
        return realName;
    }

    public void setRealName(String realName)
    {
        this.realName = realName;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime)
    {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "login_times")
    public Integer getLoginTimes()
    {
        return loginTimes;
    }

    public void setLoginTimes(Integer loginTimes)
    {
        this.loginTimes = loginTimes;
    }

    @Basic
    @Column(name = "last_login_time")
    public Timestamp getLastLoginTime()
    {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime)
    {
        this.lastLoginTime = lastLoginTime;
    }

    @Basic
    @Column(name = "is_admin")
    public Integer getIsAdmin()
    {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin)
    {
        this.isAdmin = isAdmin;
    }

    @Basic
    @Column(name = "is_delete")
    public Integer getIsDelete()
    {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete)
    {
        this.isDelete = isDelete;
    }

    @Basic
    @Column(name = "version")
    public Integer getVersion()
    {
        return version;
    }

    public void setVersion(Integer version)
    {
        this.version = version;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VerifyUserEntity that = (VerifyUserEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (realName != null ? !realName.equals(that.realName) : that.realName != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (loginTimes != null ? !loginTimes.equals(that.loginTimes) : that.loginTimes != null) return false;
        if (lastLoginTime != null ? !lastLoginTime.equals(that.lastLoginTime) : that.lastLoginTime != null)
            return false;
        if (isAdmin != null ? !isAdmin.equals(that.isAdmin) : that.isAdmin != null) return false;
        if (isDelete != null ? !isDelete.equals(that.isDelete) : that.isDelete != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (realName != null ? realName.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (loginTimes != null ? loginTimes.hashCode() : 0);
        result = 31 * result + (lastLoginTime != null ? lastLoginTime.hashCode() : 0);
        result = 31 * result + (isAdmin != null ? isAdmin.hashCode() : 0);
        result = 31 * result + (isDelete != null ? isDelete.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }
}

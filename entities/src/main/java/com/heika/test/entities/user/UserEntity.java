package com.heika.test.entities.user;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user", schema = "", catalog = "heika_new")
public class UserEntity
{
    private Integer userId;
    private Boolean isBan;
    private String channel;
    private Integer channelId;
    private Boolean isFrozen;
    private Integer inviteUserId;
    private String mobile;
    private String nickName;
    private Timestamp registerTime;
    private String userType;
    private Integer version;
    private Timestamp updateTime;

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    @Basic
    @Column(name = "is_ban")
    public Boolean getIsBan()
    {
        return isBan;
    }

    public void setIsBan(Boolean isBan)
    {
        this.isBan = isBan;
    }

    @Basic
    @Column(name = "channel")
    public String getChannel()
    {
        return channel;
    }

    public void setChannel(String channel)
    {
        this.channel = channel;
    }

    @Basic
    @Column(name = "channel_id")
    public Integer getChannelId()
    {
        return channelId;
    }

    public void setChannelId(Integer channelId)
    {
        this.channelId = channelId;
    }

    @Basic
    @Column(name = "is_frozen")
    public Boolean getIsFrozen()
    {
        return isFrozen;
    }

    public void setIsFrozen(Boolean isFrozen)
    {
        this.isFrozen = isFrozen;
    }

    @Basic
    @Column(name = "invite_user_id")
    public Integer getInviteUserId()
    {
        return inviteUserId;
    }

    public void setInviteUserId(Integer inviteUserId)
    {
        this.inviteUserId = inviteUserId;
    }

    @Basic
    @Column(name = "mobile")
    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "nick_name")
    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    @Basic
    @Column(name = "register_time")
    public Timestamp getRegisterTime()
    {
        return registerTime;
    }

    public void setRegisterTime(Timestamp registerTime)
    {
        this.registerTime = registerTime;
    }

    @Basic
    @Column(name = "user_type")
    public String getUserType()
    {
        return userType;
    }

    public void setUserType(String userType)
    {
        this.userType = userType;
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

    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime)
    {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (isBan != null ? !isBan.equals(that.isBan) : that.isBan != null) return false;
        if (channel != null ? !channel.equals(that.channel) : that.channel != null) return false;
        if (channelId != null ? !channelId.equals(that.channelId) : that.channelId != null) return false;
        if (isFrozen != null ? !isFrozen.equals(that.isFrozen) : that.isFrozen != null) return false;
        if (inviteUserId != null ? !inviteUserId.equals(that.inviteUserId) : that.inviteUserId != null) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        if (nickName != null ? !nickName.equals(that.nickName) : that.nickName != null) return false;
        if (registerTime != null ? !registerTime.equals(that.registerTime) : that.registerTime != null) return false;
        if (userType != null ? !userType.equals(that.userType) : that.userType != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (isBan != null ? isBan.hashCode() : 0);
        result = 31 * result + (channel != null ? channel.hashCode() : 0);
        result = 31 * result + (channelId != null ? channelId.hashCode() : 0);
        result = 31 * result + (isFrozen != null ? isFrozen.hashCode() : 0);
        result = 31 * result + (inviteUserId != null ? inviteUserId.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        result = 31 * result + (registerTime != null ? registerTime.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return String.format("userId=%d, isBan=%s, channel=%s, channelId=%d, isFrozen=%s, inviteUserId=%d, " +
                        "mobile=%s, nickName=%s, registerTime=%s, userType=%s, version=%d, updateTime=%s",
                userId,
                isBan,
                channel,
                channelId,
                isFrozen,
                inviteUserId,
                mobile,
                nickName,
                registerTime,
                userType,
                version,
                updateTime);
    }
}

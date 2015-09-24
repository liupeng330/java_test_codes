package com.heika.test.entities.user;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by admin on 2015/9/6.
 */
@Entity
@Table(name = "user_material", schema = "", catalog = "heika_new")
public class UserMaterialEntity
{
    private Integer id;
    private String path;
    private String type;
    private Timestamp uploadTime;
    private Integer userId;
    private Integer version;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    @Basic
    @Column(name = "path")
    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    @Basic
    @Column(name = "type")
    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    @Basic
    @Column(name = "upload_time")
    public Timestamp getUploadTime()
    {
        return uploadTime;
    }

    public void setUploadTime(Timestamp uploadTime)
    {
        this.uploadTime = uploadTime;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
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

        UserMaterialEntity that = (UserMaterialEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (path != null ? !path.equals(that.path) : that.path != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (uploadTime != null ? !uploadTime.equals(that.uploadTime) : that.uploadTime != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (uploadTime != null ? uploadTime.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }
}

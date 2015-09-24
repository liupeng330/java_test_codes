package com.heika.test.entities.user;

import javax.persistence.*;

/**
 * Created by admin on 2015/9/10.
 */
@Entity
@Table(name = "region", schema = "", catalog = "heika_new")
public class RegionEntity
{
    private Integer id;
    private String name;
    private Integer parentId;
    private String shortName;
    private Integer level;
    private String code;
    private String zip;
    private String mergeName;
    private String longitude;
    private String latitude;
    private String pinyin;
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
    @Column(name = "name")
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Basic
    @Column(name = "parent_id")
    public Integer getParentId()
    {
        return parentId;
    }

    public void setParentId(Integer parentId)
    {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "short_name")
    public String getShortName()
    {
        return shortName;
    }

    public void setShortName(String shortName)
    {
        this.shortName = shortName;
    }

    @Basic
    @Column(name = "level")
    public Integer getLevel()
    {
        return level;
    }

    public void setLevel(Integer level)
    {
        this.level = level;
    }

    @Basic
    @Column(name = "code")
    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    @Basic
    @Column(name = "zip")
    public String getZip()
    {
        return zip;
    }

    public void setZip(String zip)
    {
        this.zip = zip;
    }

    @Basic
    @Column(name = "merge_name")
    public String getMergeName()
    {
        return mergeName;
    }

    public void setMergeName(String mergeName)
    {
        this.mergeName = mergeName;
    }

    @Basic
    @Column(name = "longitude")
    public String getLongitude()
    {
        return longitude;
    }

    public void setLongitude(String longitude)
    {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "latitude")
    public String getLatitude()
    {
        return latitude;
    }

    public void setLatitude(String latitude)
    {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "pinyin")
    public String getPinyin()
    {
        return pinyin;
    }

    public void setPinyin(String pinyin)
    {
        this.pinyin = pinyin;
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

        RegionEntity that = (RegionEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (parentId != null ? !parentId.equals(that.parentId) : that.parentId != null) return false;
        if (shortName != null ? !shortName.equals(that.shortName) : that.shortName != null) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (zip != null ? !zip.equals(that.zip) : that.zip != null) return false;
        if (mergeName != null ? !mergeName.equals(that.mergeName) : that.mergeName != null) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (pinyin != null ? !pinyin.equals(that.pinyin) : that.pinyin != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (zip != null ? zip.hashCode() : 0);
        result = 31 * result + (mergeName != null ? mergeName.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (pinyin != null ? pinyin.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }
}

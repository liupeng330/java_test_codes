package com.heika.test.entities.user;

import javax.persistence.*;

/**
 * Created by admin on 2015/9/10.
 */
@Entity
@Table(name = "university_info", schema = "", catalog = "heika_new")
public class UniversityInfoEntity
{
    private Integer id;
    private String name;
    private String oldName;
    private String managerName;
    private String location;
    private String level;
    private Integer isPrivate;
    private Integer is985;
    private Integer is211;
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
    @Column(name = "old_name")
    public String getOldName()
    {
        return oldName;
    }

    public void setOldName(String oldName)
    {
        this.oldName = oldName;
    }

    @Basic
    @Column(name = "manager_name")
    public String getManagerName()
    {
        return managerName;
    }

    public void setManagerName(String managerName)
    {
        this.managerName = managerName;
    }

    @Basic
    @Column(name = "location")
    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    @Basic
    @Column(name = "level")
    public String getLevel()
    {
        return level;
    }

    public void setLevel(String level)
    {
        this.level = level;
    }

    @Basic
    @Column(name = "is_private")
    public Integer getIsPrivate()
    {
        return isPrivate;
    }

    public void setIsPrivate(Integer isPrivate)
    {
        this.isPrivate = isPrivate;
    }

    @Basic
    @Column(name = "is_985")
    public Integer getIs985()
    {
        return is985;
    }

    public void setIs985(Integer is985)
    {
        this.is985 = is985;
    }

    @Basic
    @Column(name = "is_211")
    public Integer getIs211()
    {
        return is211;
    }

    public void setIs211(Integer is211)
    {
        this.is211 = is211;
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

        UniversityInfoEntity that = (UniversityInfoEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (oldName != null ? !oldName.equals(that.oldName) : that.oldName != null) return false;
        if (managerName != null ? !managerName.equals(that.managerName) : that.managerName != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;
        if (isPrivate != null ? !isPrivate.equals(that.isPrivate) : that.isPrivate != null) return false;
        if (is985 != null ? !is985.equals(that.is985) : that.is985 != null) return false;
        if (is211 != null ? !is211.equals(that.is211) : that.is211 != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (oldName != null ? oldName.hashCode() : 0);
        result = 31 * result + (managerName != null ? managerName.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (isPrivate != null ? isPrivate.hashCode() : 0);
        result = 31 * result + (is985 != null ? is985.hashCode() : 0);
        result = 31 * result + (is211 != null ? is211.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }
}

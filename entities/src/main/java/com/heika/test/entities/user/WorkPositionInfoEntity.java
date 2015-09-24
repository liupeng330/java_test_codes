package com.heika.test.entities.user;

import javax.persistence.*;

/**
 * Created by admin on 2015/9/9.
 */
@Entity
@Table(name = "work_position_info", schema = "", catalog = "heika_new")
public class WorkPositionInfoEntity
{
    private Integer id;
    private String name;
    private Integer detailLevel;
    private Integer level;
    private String industry;
    private String note;
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
    @Column(name = "detail_level")
    public Integer getDetailLevel()
    {
        return detailLevel;
    }

    public void setDetailLevel(Integer detailLevel)
    {
        this.detailLevel = detailLevel;
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
    @Column(name = "industry")
    public String getIndustry()
    {
        return industry;
    }

    public void setIndustry(String industry)
    {
        this.industry = industry;
    }

    @Basic
    @Column(name = "note")
    public String getNote()
    {
        return note;
    }

    public void setNote(String note)
    {
        this.note = note;
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

        WorkPositionInfoEntity that = (WorkPositionInfoEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (detailLevel != null ? !detailLevel.equals(that.detailLevel) : that.detailLevel != null) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;
        if (industry != null ? !industry.equals(that.industry) : that.industry != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (detailLevel != null ? detailLevel.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (industry != null ? industry.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }
}

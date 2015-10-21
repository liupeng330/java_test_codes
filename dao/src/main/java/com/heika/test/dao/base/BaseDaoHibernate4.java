package com.heika.test.dao.base;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class BaseDaoHibernate4<T> implements BaseDao<T>
{
    //DAO组件进行持久化操作底层依赖的SessionFactory组件
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory()
    {
        return this.sessionFactory;
    }

    //根据ID加载实体
    @SuppressWarnings("unchecked")
    public T get(Class<T> entityClass, Serializable id)
    {
        return (T)getSessionFactory().getCurrentSession().get(entityClass, id);
    }

    public T get(Class<T> entityClass, String columnName, Serializable columnValue)
    {
        List<T> ret = getList(entityClass, columnName, columnValue);
        if(ret != null && ret.size() > 0)
        {
            return ret.get(0);
        }
        return null;
    }

    public List<T> getList(Class<T> entityClass, String columnName, Serializable columnValue)
    {
        return this.find("from " + entityClass.getSimpleName() + " en where en." + columnName + "=?", columnValue);
    }

    public <U> List<T> getList(Class<T> entityClass, String columnName, List<U> columnValues)
    {
        return this.findByList("from " + entityClass.getSimpleName() + " en where en." + columnName + " in (:lst)", "lst", columnValues);
    }

    //保存实体
    public Serializable save(T entity)
    {
        return getSessionFactory().getCurrentSession().save(entity);
    }

    //更新实体
    public void update(T entity)
    {
        getSessionFactory().getCurrentSession().saveOrUpdate(entity);
    }

    //删除实体
    public void delete(T entity)
    {
        getSessionFactory().getCurrentSession().delete(entity);
    }

    //根据ID删除实体
    public void delete(Class<T> entityClass, Serializable id)
    {
        getSessionFactory().getCurrentSession()
                .createQuery("delete " + entityClass.getSimpleName() + " en where en.id = :id")
                .setInteger("id", (Integer) id)
                .executeUpdate();
    }

    public void delete(Class<T> entityClass, String columnName, Serializable columnValue)
    {
        getSessionFactory().getCurrentSession()
                .createQuery("delete " + entityClass.getSimpleName() + " en where " + columnName + " = :otherId")
                .setInteger("otherId", (Integer) columnValue)
                .executeUpdate();
    }

    //获取所有实体
    public List<T> findAll(Class<T> entityClass)
    {
        return find("select en from " + entityClass.getSimpleName() + " en");
    }

    //获取实体总数
    public long findCount(Class<T> entityClass)
    {
        List<?> l = find("select count(*) from " + entityClass.getSimpleName());

        //返回查询得到的实体总数
        if(l != null && l.size() == 1)
        {
            return (Long)l.get(0);
        }
        return 0;
    }

    //根据HQL语句查询实体
    @SuppressWarnings("unchecked")
    protected List<T> find(String hql)
    {
        return (List<T>)getSessionFactory().getCurrentSession()
                .createQuery(hql)
                .list();
    }

    //根据带占位符参数的HQL语句查询实体
    @SuppressWarnings("unchecked")
    protected List<T> find(String hql, Object... params)
    {
        //创建查询
        Query query = getSessionFactory().getCurrentSession()
                .createQuery(hql);
        return find(query, params);
    }

    private List<T> find(Query query, Object... params)
    {
        //为包含占位符的HQL语句设置参数
        for(int i = 0, len = params.length; i< len; i++)
        {
            query.setParameter(i, params[i]);
        }
        return (List<T>)query.list();
    }

    protected <U> List<T> findByList(String hql, String paramName, List<U> list)
    {
        return this.getListQuery(hql, paramName, list).list();
    }

    private <U> Query getListQuery(String hql, String paramName, List<U> list)
    {
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        return query.setParameterList(paramName, list);
    }
}

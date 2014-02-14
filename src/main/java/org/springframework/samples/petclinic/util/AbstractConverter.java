package org.springframework.samples.petclinic.util;

import java.util.ArrayList;
import java.util.Collection;

import org.dozer.Mapper;
import org.springframework.util.CollectionUtils;


public abstract class AbstractConverter<T, V> implements Converter<T, V> {

	 private Mapper mapper;
	 private Class<T> beanClass;
	 private Class<V> myBeanClass;
	 
	 
	 public AbstractConverter(Mapper mapper, Class<T> beanClass, Class<V> myBeanClass) {
		  this.mapper = mapper;
		  this.beanClass = beanClass;
		  this.myBeanClass = myBeanClass;
	 }
	 
	 @Override
	 public Object convertMyBean(Object bean) {
		 Object myBean = null;
		  if(bean != null) {
			  myBean = mapper.map(bean, myBeanClass);
		  }
		  return myBean;
	 }
	 
	 @Override
	 public Collection<V> convertMyBeanList(Collection<T> beanList) {
		 ArrayList<V> myBeanList = null;
		  if(!CollectionUtils.isEmpty(beanList)) {
			  myBeanList = new ArrayList<V>();
			   for (T bean : beanList) {
				   myBeanList.add((V)convertMyBean(bean));
			   }
		  }
		  return myBeanList;
	 }
	 
	 @Override
	 public Object convertBean(Object myBean) {
		 Object bean = null;
		  if(myBean != null) {
			  bean = mapper.map(myBean, beanClass);
		  }
		  return bean;
	 }
	 
	 @Override
	 public Collection<T> convertBeanList(Collection<V> myBeanList) { 
		 ArrayList<T> beanList = null;
		  if(!CollectionUtils.isEmpty(myBeanList)) {
			  beanList = new ArrayList<T>();
			   for (V myBean : myBeanList) {
				   beanList.add((T)convertBean(myBean));
			   }
		  }
		  return beanList;
	 }
	}
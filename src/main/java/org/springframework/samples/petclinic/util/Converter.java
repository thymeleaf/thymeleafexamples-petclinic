package org.springframework.samples.petclinic.util;

import java.util.ArrayList;
import java.util.Collection;

public interface Converter<T,V> {

	 public Object convertMyBean(Object bean);
	 
	 public Collection<V> convertMyBeanList(Collection<T> beanList);
	 
	 public Object convertBean(Object myBean);
	 
	 public Collection<T> convertBeanList(Collection<V> myBeanList);
}
package org.springframework.samples.petclinic.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.samples.petclinic.Clinic;
import org.springframework.samples.petclinic.PetType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Component
public class ClinicRequestMappingHandlerAdapterCustomizer implements BeanPostProcessor {

    @Autowired 
    protected Clinic clinic;

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
      if (bean instanceof RequestMappingHandlerAdapter) {
        RequestMappingHandlerAdapter adapter = (RequestMappingHandlerAdapter) bean;
        ConfigurableWebBindingInitializer initializer = 
          (ConfigurableWebBindingInitializer) adapter.getWebBindingInitializer();
        initializer.setPropertyEditorRegistrar(new PropertyEditorRegistrar() {
            public void registerCustomEditors(PropertyEditorRegistry registry) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateFormat.setLenient(false);
                registry.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
                registry.registerCustomEditor(String.class, new StringTrimmerEditor(false));
                registry.registerCustomEditor(PetType.class, new PetTypeEditor(ClinicRequestMappingHandlerAdapterCustomizer.this.clinic));
            }
        });
      }
      return bean;
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
      return bean;
    }

  }


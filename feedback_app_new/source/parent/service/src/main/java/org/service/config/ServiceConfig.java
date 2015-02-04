package org.service.config;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ComponentScan({ "org.service.config"})
//@PropertySource(value = { "classpath:application.properties" })
public class ServiceConfig {

    @Bean
    public DozerBeanMapper javaBeanMapper() {
    	System.out.println("dozer........");
        List<String> mappingFiles = new ArrayList<String>();
        mappingFiles.add("dozer-bean-mapping.xml");
        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.setMappingFiles(mappingFiles);
        return mapper;
    }
    
 /*   @Bean
    public MailSender mailSender(){
    	MailSender mailSender = new JavaMailSenderImpl();
    }*/
	
}

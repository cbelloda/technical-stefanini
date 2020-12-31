package com.belloda;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import com.belloda.dao.BankDao;
import com.belloda.entity.Bank;
import com.belloda.service.MaintenanceRestService;
import com.belloda.service.PaymentsRestService;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.jaxrs.provider.JAXBElementProvider;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

public class RestfulServer {
    public static void main(String args[]) throws Exception {


      
        Bank bbva= new Bank("name", "address", new Date());
        boolean saveBankresult=new BankDao().save(bbva);

        System.out.println("el banco ha sido grabado "+saveBankresult);
        BankDao bankDao=new BankDao();
        bankDao.getAll();

        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();

        Map<Object, Object> extensionMappings = new HashMap<Object, Object>();
        extensionMappings.put("xml", MediaType.APPLICATION_XML);
        extensionMappings.put("json", MediaType.APPLICATION_JSON);
        factoryBean.setExtensionMappings(extensionMappings);
        List<Object> providers = new ArrayList<Object>();
        providers.add(new JAXBElementProvider<>());
        providers.add(new JacksonJsonProvider());
        factoryBean.setProviders(providers);

        factoryBean.setResourceClasses(MaintenanceRestService.class);
        factoryBean.setResourceClasses(PaymentsRestService.class);
        factoryBean.setResourceProvider(new SingletonResourceProvider(new MaintenanceRestService()));
        factoryBean.setResourceProvider(new SingletonResourceProvider(new PaymentsRestService()));
        factoryBean.setAddress("http://localhost:8080/");
        Server server = factoryBean.create();

        System.out.println("Server Starting");
        Thread.sleep(1000 * 1000);
        System.out.println("Server Shutting Down");
        server.destroy();
        System.exit(0);
    }
}

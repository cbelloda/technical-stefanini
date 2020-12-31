package com.belloda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.xml.ws.Endpoint;

import com.belloda.dao.BankDao;
import com.belloda.dao.BranchOfficeDao;
import com.belloda.dao.PaymentOrderDao;
import com.belloda.service.BankService;
import com.belloda.service.BranchOfficeService;
import com.belloda.service.MaintenanceRestService;
import com.belloda.service.PaymentOrderService;
import com.belloda.service.PaymentsRestService;
import com.belloda.soap.DefaultBranchOfficeServiceSoap;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.jaxrs.provider.JAXBElementProvider;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

public class AppServer {
    public static void main(String args[]) throws Exception {


        BankDao bankDao= new BankDao();
        BranchOfficeDao branchOfficeDao = new BranchOfficeDao();
        PaymentOrderDao paymentOrderDao = new PaymentOrderDao();

        BankService bankService= new BankService(bankDao);
        BranchOfficeService branchOfficeService = new BranchOfficeService(branchOfficeDao);
        PaymentOrderService paymentOrderService = new PaymentOrderService(paymentOrderDao);

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
        factoryBean.setResourceProvider(new SingletonResourceProvider(new MaintenanceRestService(bankService, branchOfficeService, paymentOrderService)));
        factoryBean.setResourceProvider(new SingletonResourceProvider(new PaymentsRestService(branchOfficeService,paymentOrderService)));
        factoryBean.setAddress("http://localhost:8080/");
        Server server = factoryBean.create();


        DefaultBranchOfficeServiceSoap implementor = new DefaultBranchOfficeServiceSoap();
        String address = "http://localhost:8081/branchesOffice";
        Endpoint.publish(address, implementor);

        System.out.println("Server Starting");
        Thread.sleep(1000 * 1000);
        System.out.println("Server Shutting Down");
        server.destroy();
        System.exit(0);
    }
}

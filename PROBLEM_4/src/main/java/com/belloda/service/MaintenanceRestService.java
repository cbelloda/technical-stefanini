package com.belloda.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.belloda.dto.BankDto;
import com.belloda.dto.BranchOfficeDto;
import com.belloda.dto.PaymentOrderDto;

@Path("maintenance")
public class MaintenanceRestService {

    private BankService bankService;
    private BranchOfficeService branchOfficeService;
    private PaymentOrderService paymentOrderService;

    public MaintenanceRestService() {
        bankService = new BankService();
        branchOfficeService = new BranchOfficeService();
        paymentOrderService = new PaymentOrderService();
    }

    @POST
    @Path("bank/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveBank(BankDto bank) {

        return Response.ok().entity(bankService.save(bank)).build();
    }

    @POST
    @Path("bank/{bank-id}/branch")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveBranchOffice(@PathParam("bank-id") int idBank, BranchOfficeDto branchOffice) {

        if (bankService.invalidBank(idBank)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().entity(branchOfficeService.save(idBank, branchOffice)).build();
    }

    @POST
    @Path("bank/{bank-id}/branch/{branch-id}/payment-order")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response savePaymentOrder(@PathParam("bank-id") int idBank,@PathParam("branch-id") int idBranch, 
    PaymentOrderDto paymentOrderDto) {

        if (branchOfficeService.invalidBranchOffice(idBranch,idBank)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().entity(paymentOrderService.save(idBranch, paymentOrderDto)).build();
    }

}

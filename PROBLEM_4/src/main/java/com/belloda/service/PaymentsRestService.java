package com.belloda.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.belloda.dto.Currency;
import com.belloda.entity.PaymentOrder;

@Path("payment")
public class PaymentsRestService {

    BranchOfficeService branchOfficeService;
    PaymentOrderService paymentOrderService;

    public PaymentsRestService(){
        branchOfficeService=new BranchOfficeService();
        paymentOrderService=new PaymentOrderService();
    }

    @GET
    @Path("{bank-id}/orders/{branch-id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPayments(@PathParam("bank-id") int bankId,@PathParam("branch-id") int branchId,@QueryParam("currency") Currency currency) {

        if (branchOfficeService.invalidBranchOffice(branchId,bankId)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        List<PaymentOrder> payments=paymentOrderService.getPayments(branchId, currency);
        return Response.ok().entity(payments).build();
    }


}

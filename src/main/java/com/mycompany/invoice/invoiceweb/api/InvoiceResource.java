package com.mycompany.invoice.invoiceweb.api;

import com.mycompany.invoice.core.entity.invoice.Invoice;
import com.mycompany.invoice.core.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoice")
public class InvoiceResource {

    @Autowired
    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("")
    public Invoice create(@RequestBody Invoice invoice) {
        return invoiceService.createInvoice(invoice);

    }
   @GetMapping
   public Iterable<Invoice> list() {
       System.out.println("InvoiceResource (API) -> la méthode displayHome a été invoquée");
       return invoiceService.getInvoiceList();
   }
    //@RequestMapping("/{id}")
    @GetMapping("/{id}")
    public @ResponseBody Invoice getInvoice(@PathVariable("id") String number) {
        System.out.println("InvoiceResource (API) -> la méthode getInvoice a été invoquée");
        return invoiceService.getInvoiceByNumber(number);
    }

}

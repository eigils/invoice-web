package com.mycompany.invoice.invoiceweb.controller;

import com.mycompany.invoice.core.entity.customer.Address;
import com.mycompany.invoice.core.entity.customer.Customer;
import com.mycompany.invoice.core.entity.invoice.Invoice;
import com.mycompany.invoice.core.service.InvoiceServiceInterface;
import com.mycompany.invoice.invoiceweb.form.InvoiceForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/invoice")
public class InvoiceControllerWeb {

    @Autowired
    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    //@RequestMapping(value = "", method = RequestMethod.POST)
    @PostMapping("/create")
    public String createInvoice(@Valid @ModelAttribute InvoiceForm invoiceForm, BindingResult results) {

        if(results.hasErrors()) {
            return "invoice-create-form";
        }
        /*String customerName = "user";
        Invoice invoice = new Invoice();
        invoice.setCustomerName(customerName);*/
        Invoice invoice = new Invoice();
        Customer customer = new Customer(invoiceForm.getCustomerName());
        invoice.setCustomer(customer);
        Address address = new Address(invoiceForm.getStreetName(),invoiceForm.getStreetNumber(),invoiceForm.getCity(),invoiceForm.getZipCode(), invoiceForm.getCountry());
        customer.setAddress(address);
        invoice.setOrderNumber(invoiceForm.getOrderNumber());
        invoiceService.createInvoice(invoice);
        return "invoice-created";
    }

   /* @RequestMapping("/invoice-home")
    public String displayHome(HttpServletRequest request) {
        System.out.println("la méthode DisplayHome a été invoquée");
        List<Invoice> invoices = invoiceService.getInvoiceList();
        System.out.println(invoices.get(0).getNumber());
        System.out.println(invoices.get(0).getCustomerName());
        request.setAttribute("Invoices",invoices);
        return "index";
    }*/
   //@RequestMapping("/home")
    @GetMapping("/home")
   public String displayHome(Model model) {
       System.out.println("InvoiceControllerWeb (Controller) -> la méthode displayHome a été invoquée");

        model.addAttribute("invoices", invoiceService.getInvoiceList());
        /*ModelAndView mv = new ModelAndView("invoice-home");
        mv.addObject("invoices", invoiceService.getInvoiceList());*/
        return "invoice-home";
   }
    //@RequestMapping("/{id}")
    /* @GetMapping("/{id}")
   public String displayInvoice(@PathVariable("id") String number, Model model) {
        System.out.println("la méthode displayInvoice a été invoquée");
        model.addAttribute("invoice", invoiceService.getInvoiceByNumber(number));
       //ModelAndView mv = new ModelAndView("invoice-details");
        //mv.addObject("invoice", invoiceService.getInvoiceByNumber(number));
        return "invoice-details";
    }*/

    //@RequestMapping("/create-form")
    @GetMapping("/create-form")
    public String displayInvoiceCreateFom(@ModelAttribute InvoiceForm invoiceForm) {
       return "invoice-create-form";
    }
}

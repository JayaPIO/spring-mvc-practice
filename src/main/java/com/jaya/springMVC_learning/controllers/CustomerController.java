package com.jaya.springMVC_learning.controllers;

import com.jaya.springMVC_learning.models.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    // add an initBinder to remove leading and tailing white spaces
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class , stringTrimmerEditor);
    }
    @GetMapping
    public String showForm(Model model){
        model.addAttribute("customer",new Customer());
        return "customerForm.html";
    }
    @PostMapping
    public String customerDetails(@Valid @ModelAttribute ("customer") Customer theCustomer, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "customerForm.html";
        }
        else{
            return "customerConfirmation.html";
        }
    }

}

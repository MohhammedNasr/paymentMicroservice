package com.project.payment.Controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.payment.models.pay;

@Controller
@RequestMapping("/library")
public class paymentController {
    @Autowired
    private com.project.payment.Repositories.paymentRepository paymentRepository;

    @GetMapping("pay")
    public ModelAndView showPaymentForm(Model model) {
        ModelAndView mav = new ModelAndView("Pay.html");
        return mav;

    }

    @PostMapping("/library/save-payment")
    public String savePay(@ModelAttribute pay pay, Model model) {
        paymentRepository.save(pay);
        if (pay.getPaymentMethod().equals("cash-on-delivery")) {
            return "paymentConfirmation";
        } else if (pay.getPaymentMethod().equals("payment-via-visa")) {
            return "payVisa";
        }
        return "redirect:/";
    }

}
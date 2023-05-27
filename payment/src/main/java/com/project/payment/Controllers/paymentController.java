package com.project.payment.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.payment.models.pay;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/library/Pay")
public class paymentController {
    @Autowired
    private com.project.payment.Repositories.paymentRepository paymentRepository;

    @GetMapping("")
    public ResponseEntity getAllPayments() {
        List<pay> payments = this.paymentRepository.findAll();
        return new ResponseEntity<>(payments, HttpStatus.OK);

    }

    @GetMapping("{payId}")
    public ResponseEntity getPaymentById(@PathVariable(name = "payId") Long payId) {
        pay payment = this.paymentRepository.findById(payId).orElse(null);
        return new ResponseEntity<>(payment, HttpStatus.OK);

    }

    @PostMapping("")
    public ResponseEntity savePay(@RequestBody pay pay) {
        pay res = paymentRepository.save(pay);
        return new ResponseEntity(res, HttpStatus.CREATED);
    }

    @PutMapping("{payId}")
    public ResponseEntity updatePayment(@PathVariable(name = "payId") Long id, @RequestBody pay pay) {
        pay.setId(id);
        pay res = paymentRepository.save(pay);
        return new ResponseEntity(res, HttpStatus.CREATED);
    }

    @DeleteMapping("{payId}")
    public ResponseEntity deletePayment(@PathVariable(name = "payId") Long id) {
        this.paymentRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

}
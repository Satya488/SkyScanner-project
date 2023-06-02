package com.skyscanner.controller;

import com.skyscanner.payload.SMSRequest;
import com.skyscanner.service.SMSService;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SMSController {

    private final SMSService smsService;

    public SMSController(SMSService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/send-sms")
    public ResponseEntity<String> sendSMS(@RequestBody SMSRequest request) {
        smsService.sendSMS(request.getToPhoneNumber(), request.getMessage());
        return new ResponseEntity<>("Message send successfully",HttpStatus.OK);
    }
}


package com.skyscanner.payload;

import lombok.Data;

@Data
public class SMSRequest {
    private String toPhoneNumber;
    private String message;

}


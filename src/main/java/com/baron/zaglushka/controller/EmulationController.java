package com.baron.zaglushka.controller;

import com.baron.zaglushka.model.RequestDto;
import com.baron.zaglushka.model.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

@RestController
@Slf4j
public class EmulationController {

    @PostMapping
    public ResponseDto emulate(@RequestBody RequestDto request) {
        String clientId = request.getClientId();
        String account = request.getAccount();
        String currency;
        String maxLimit;

        if (clientId.startsWith("8")) {
            currency = "US";
            maxLimit = "2000.00";
        } else if (clientId.startsWith("9")) {
            currency = "EU";
            maxLimit = "1000.00";
        } else {
            currency = "RU";
            maxLimit = "50000.00";
        }

        BigDecimal maxLimitBigDecimal = new BigDecimal(maxLimit);
        BigDecimal balance = maxLimitBigDecimal.multiply(BigDecimal.valueOf(Math.random()))
                .setScale(2, RoundingMode.HALF_UP);

        ResponseDto response = new ResponseDto();
        response.setRqUID(request.getRqUID());
        response.setClientId(clientId);
        response.setAccount(account);
        response.setCurrency(currency);
        response.setBalance(String.format("%.2f", balance));
        response.setMaxLimit(maxLimit);

        log.info("Emulator request received: {}", request);
        log.info("Emulator response generated: {}", response);

        return response;
    }

}

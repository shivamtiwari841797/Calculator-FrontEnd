package com.company.calculatorfe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UIController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${calc.service.url}")
    private String calcUrl;

    @GetMapping("/add")
    public Long add(@RequestParam("number1") int num1, @RequestParam("number2") int num2) {
        String addUrl = calcUrl + "add/" + num1 + "/" + num2;
        ResponseEntity<Long> reponseEntity = restTemplate.getForEntity(addUrl, Long.class);
        return reponseEntity.getBody();
    }

    @GetMapping("/sub")
    public Long sub(@RequestParam("number1") int num1, @RequestParam("number2") int num2) {
        String subUrl = calcUrl + "sub/" + num1 + "/" + num2;
        ResponseEntity<Long> reponseEntity = restTemplate.getForEntity(subUrl, Long.class);
        return reponseEntity.getBody();
    }

}

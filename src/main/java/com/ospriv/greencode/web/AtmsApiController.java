package com.ospriv.greencode.web;


import com.ospriv.greencode.dto.ATM;
import com.ospriv.greencode.dto.Task;
import com.ospriv.greencode.service.AtmsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AtmsApiController {

    private final AtmsService service;

    public AtmsApiController(AtmsService service) {
        this.service = service;
    }

    /**
     * POST /atms/calculateOrder
     * Calculates ATMs order for service team
     * <p>
     * http://localhost:8080/atms/calculateOrder
     *
     * @param tasks (required)
     * @return Successful operation (status code 200)
     */
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/atms/calculateOrder",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    public ResponseEntity<List<ATM>> calculate(@RequestBody List<Task> tasks) {

        return ResponseEntity.ok(service.calculateOrder(tasks));
    }

}

package com.ospriv.greencode.web;


import com.ospriv.greencode.dto.Clan;
import com.ospriv.greencode.dto.Players;
import com.ospriv.greencode.service.OnlinegameGroupsDispatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class OnlinegameApiController {

    /**
     * POST /onlinegame/calculate
     * Calculate order
     * http://localhost:8080/onlinegame/calculate
     *
     * @param players (required)
     * @return Successful operation (status code 200)
     */
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/onlinegame/calculate",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    public ResponseEntity<List<List<Clan>>> calculate(@RequestBody Players players) {
        final OnlinegameGroupsDispatcher disp = new OnlinegameGroupsDispatcher(players);
        List<List<Clan>> result = disp.dispatch();
        return ResponseEntity.ok(result);
    }

}

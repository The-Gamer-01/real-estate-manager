package com.hyx.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 房子关注相关.
 *
 * @author hyx
 **/

@RestController
public class HouseManagerController {
    @PostMapping("/house")
    public boolean createHouse() {
        return false;
    }
    
    @DeleteMapping("/{id}")
    public boolean deleteHouse(@PathVariable String id) {
        return false;
    }
    
}

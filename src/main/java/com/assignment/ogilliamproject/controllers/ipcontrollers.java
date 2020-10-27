package com.assignment.ogilliamproject.controllers;

import org.apache.commons.net.util.SubnetUtils;
import org.springframework.web.bind.annotation.*;

import static com.assignment.ogilliamproject.datasources.datasource.*;

@RestController
public class ipcontrollers {

    @GetMapping("/")
    public String getCIDR(@RequestParam(value = "cidr") String cidr) {
        try{
            SubnetUtils util = new SubnetUtils(cidr);
            addAddresses(util.getInfo().getAllAddresses());
            return "Success";
        } catch(Exception e){
            return "Error processing addresses";
        }
    }

    @GetMapping("/all")
    public String getAll(){
        return listAddresses();
    }

    @GetMapping("/acquire")
    public String getAcquire(@RequestParam(value = "ip") String ip){
        return acquireIP(ip);
    }

    @GetMapping("/release")
    public String getAvailable(@RequestParam(value = "ip") String ip){
        return releaseIp(ip);
    }
}

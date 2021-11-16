package com.oskarro.comparator.gateway;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class InterfaceGateway {

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/product")
    public String insertProduct() {
        return "insert-product";
    }

}

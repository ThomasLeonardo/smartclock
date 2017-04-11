package br.ufpe.nti.controller.routing;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Routes
{
    @RequestMapping(value = "/clock", method = RequestMethod.GET)
    public String clock()
    {
        return "tis a clock";
    }
    
}

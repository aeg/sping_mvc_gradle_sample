package com.habuma.spitter.com.habuma.spitter.mvc;

import com.habuma.spitter.domain.Spittle;
import com.habuma.spitter.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @RequestMapping("/home.htm")
    public ModelAndView showHomePage() {
        List<Spittle> spittles = _spitterService.getLast50Spittles();

        return new ModelAndView("home", "spittles", spittles);
    }

    @Autowired
    private SpitterService _spitterService;
}

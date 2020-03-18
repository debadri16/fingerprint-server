package stcet.group2020.fpr.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/fpserver")
public class FPServerWelcomeMsgController {
    @GetMapping("/welcomemsg")
    public String welcome() {
        return "Welcome From FP Server.";
    }
}

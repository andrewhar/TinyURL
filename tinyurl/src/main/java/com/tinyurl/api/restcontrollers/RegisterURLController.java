package com.tinyurl.api.restcontrollers;



import com.tinyurl.api.model.URL;
import com.tinyurl.api.repository.OrgURLRepository;
import com.tinyurl.api.repository.TinyURLRepository;
import com.tinyurl.api.repository.URLRepository;
import com.tinyurl.api.restcontrollers.dto.URLRequest;
import com.tinyurl.api.restcontrollers.dto.URLResponse;
import com.tinyurl.api.service.urldel.DeleteURLService;
import com.tinyurl.api.service.urlregistration.RegisterURLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class RegisterURLController {

    @Autowired
    private RegisterURLService registerURLService;

    @Autowired
    private DeleteURLService deleteURLService;

    @RequestMapping(value = "/registertinyurls", method = RequestMethod.POST)
    public URLResponse registerURL(@RequestBody URLRequest request) {
        System.out.println("[RegisterURLController] registerURL");
        URLResponse response=registerURLService.registerURL(request);
        return response;
    }

    @RequestMapping(value = "/deltinyurls", method = RequestMethod.GET)
    public URLResponse delURL(@RequestBody URLRequest request) {
        System.out.println("[RegisterURLController] delURL");
        URLResponse response=deleteURLService.deleteURL(request);
        return response;
    }
}

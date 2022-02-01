package com.example.weaponshop2.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/guns", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class GunsController {

    @Autowired
    private final GunsService gunsService;

    public GunsController(GunsService gunsService) {
        this.gunsService = gunsService;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("ERROR: " + exception.getMessage());
    }

    @GetMapping(value = "/getAll")
    public ArrayList<Gun> getAll() throws Exception {
        return gunsService.getAll();
    }
}

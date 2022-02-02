package com.example.weaponshop2.controllers;

import com.example.weaponshop2.models.Gun;
import com.example.weaponshop2.services.GunsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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

    @GetMapping(value = "/getById/{id}")
    public Gun getById(@PathVariable int id) throws Exception {
        return gunsService.getById(id);
    }

    @PostMapping(value = "/insertOne")
    public Gun insertOne(@RequestBody Gun gun) throws Exception {
        return gunsService.insertOne(gun);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable int id) throws Exception {
        gunsService.deleteById(id);
    }

    @PutMapping(value = "/updateById/{id}")
    public Gun updateById(@PathVariable int id, @RequestBody Gun gun) throws Exception {
        return gunsService.updateById(id, gun);
    }
}

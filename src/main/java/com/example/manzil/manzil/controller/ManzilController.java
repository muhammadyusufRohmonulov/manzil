package com.example.manzil.manzil.controller;

import com.example.manzil.manzil.model.Manzil;
import com.example.manzil.manzil.service.ManzilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("manzil")
public class ManzilController {
    @Autowired
    ManzilService manzilService;
    @PostMapping("/insert")
    public HttpEntity<?> insert(@RequestBody Manzil manzil){
        boolean b = manzilService.insert2(manzil);
        if (!b){
            return ResponseEntity.status(HttpStatus.OK).body("Malumot Bazaga Joylandi");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Malumot Bazaga Joylandi");
    }
    @GetMapping("/view/{id}")
    public HttpEntity<?> view(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(manzilService.view2(id));
    }
    @PutMapping("/update/{id}")
    public HttpEntity<?> update(@RequestBody Manzil manzil,@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(manzilService.update2(id, manzil));
    }
    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(manzilService.delete2(id));
    }
    @GetMapping("/page")
    public HttpEntity<?> sahifalash(@RequestParam(defaultValue = "1") Integer sahifa,@RequestParam(defaultValue="5") int soni){
        return ResponseEntity.status(HttpStatus.OK).body(manzilService.sahifalash(sahifa,soni));
    }
}

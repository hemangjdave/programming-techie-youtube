package com.techrevolution.ms.inventoryservice.controller;

import com.techrevolution.ms.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {


    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Boolean> isInStock(@RequestParam String skuCode, @RequestParam Integer quantity) {
        return ResponseEntity.ok(inventoryService.isInStock(skuCode, quantity));
    }
}

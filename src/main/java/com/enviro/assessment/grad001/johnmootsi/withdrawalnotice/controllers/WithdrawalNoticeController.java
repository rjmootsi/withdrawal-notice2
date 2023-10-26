package com.enviro.assessment.grad001.johnmootsi.withdrawalnotice.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class WithdrawalNoticeController {





    @GetMapping("/hello")
    public String sayHello() {
        return "Oh hai, world!";
    }

//    @GetMapping("/properties")
//    public ResponseEntity<List<PropertyDTO>> getAllProperties() {
//        List<PropertyDTO> propertyDTOList = propertyService.getAllProperties();
//        return new ResponseEntity<List<PropertyDTO>>(propertyDTOList, HttpStatus.OK);
//    }
//
//    @GetMapping("/properties/{id}")
//    public ResponseEntity<PropertyDTO> getProperty(@PathVariable(name = "id") Long propertyId) {
//        PropertyDTO propertyDTO = propertyService.getPropertyById(propertyId);
//        return new ResponseEntity<PropertyDTO>(propertyDTO, HttpStatus.OK);
//    }
//    @PostMapping("/properties")
//    public ResponseEntity<Void> addProperty(@RequestBody PropertyDTO propertyDTO) {
//        propertyService.addProperty(propertyDTO);
//        return new ResponseEntity<>(null, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/properties/{id}")
//    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable(name = "id") Long propertyId) {
//        propertyDTO = propertyService.updateProperty(propertyDTO, propertyId);
//        return new ResponseEntity<>(propertyDTO, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/properties/{id}")
//    public void deleteProperty(@PathVariable(name = "id") Long propertyId) {
//        propertyService.deleteProperty(propertyId);
//    }
//
//    @PatchMapping("/properties/title/{propertyId}")
//    public ResponseEntity<PropertyDTO> updateTitle(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
//        propertyDTO = propertyService.updateTitle(propertyDTO, propertyId);
//        return new ResponseEntity<>(propertyDTO, HttpStatus.OK);
//    }
//
//    @PatchMapping("/properties/description/{propertyId}")
//    public ResponseEntity<PropertyDTO> updateDescription(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
//        propertyDTO = propertyService.updateDescription(propertyDTO, propertyId);
//        return new ResponseEntity<>(propertyDTO, HttpStatus.OK);
//    }
//
//    @PatchMapping("/properties/owner-name/{propertyId}")
//    public ResponseEntity<PropertyDTO> updateOwnerName(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
//        propertyDTO = propertyService.updateOwnerName(propertyDTO, propertyId);
//        return new ResponseEntity<>(propertyDTO, HttpStatus.OK);
//    }
//
//    @PatchMapping("/properties/owner-email/{propertyId}")
//    public ResponseEntity<PropertyDTO> updateOwnerEmail(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
//        propertyDTO = propertyService.updateOwnerEmail(propertyDTO, propertyId);
//        return new ResponseEntity<>(propertyDTO, HttpStatus.OK);
//    }
//
//    @PatchMapping("/properties/price/{propertyId}")
//    public ResponseEntity<PropertyDTO> updatePrice(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
//        propertyDTO = propertyService.updatePrice(propertyDTO, propertyId);
//        return new ResponseEntity<>(propertyDTO, HttpStatus.OK);
//    }
//
//    @PatchMapping("/properties/address/{propertyId}")
//    public ResponseEntity<PropertyDTO> updateAddress(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
//        propertyDTO = propertyService.updateAddress(propertyDTO, propertyId);
//        return new ResponseEntity<>(propertyDTO, HttpStatus.OK);
//    }
}

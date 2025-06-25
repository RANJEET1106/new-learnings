package com.infosys.mysqlrest.Controller;

import com.infosys.mysqlrest.model.CloudVendor;
import com.infosys.mysqlrest.service.CloudVendorServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {
    CloudVendorServiceInterface cloudVendorService;
    public CloudVendorController(CloudVendorServiceInterface cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorById(@PathVariable("vendorId") String cloudVendorId) {
        return cloudVendorService.getCloudVendor(cloudVendorId);
    }

    @GetMapping()
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorService.getCloudVendors();
    }

    @PostMapping
    public String createCloudVendor(@RequestBody CloudVendor cloudVendor) {
        cloudVendorService.createCloudVendor(cloudVendor);
        return "Cloud Vendor Created Successfully";
    }

    @PutMapping
    public String updateCloudVendor(@RequestBody CloudVendor cloudVendor) {
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "Cloud Vendor Updated Successfully";
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorById(@PathVariable("vendorId") String cloudVendorId) {
        cloudVendorService.deleteCloudVendor(cloudVendorId);
        return "Cloud Vendor Deleted Successfully";
    }
}


package com.infosys.mysqlrest.service.impl;

import com.infosys.mysqlrest.Repository.CloudVendorRepository;
import com.infosys.mysqlrest.exception.CloudVendorNotFoundException;
import com.infosys.mysqlrest.model.CloudVendor;
import com.infosys.mysqlrest.service.CloudVendorServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudServiceImple implements CloudVendorServiceInterface {

    CloudVendorRepository cloudVendorRepository;
    public CloudServiceImple(CloudVendorRepository  cloudVendorRepository){
        this.cloudVendorRepository=cloudVendorRepository;
    }
    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        cloudVendorRepository.deleteById(cloudVendorId);
        return "";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        if(cloudVendorRepository.findById(cloudVendorId).isEmpty()){
            throw new CloudVendorNotFoundException("Requested Cloud vendor not found");
        }
        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getCloudVendors() {
        return cloudVendorRepository.findAll();
    }
}

package com.infosys.mysqlrest.service;

import com.infosys.mysqlrest.model.CloudVendor;

import java.util.List;

public interface CloudVendorServiceInterface {
    public String createCloudVendor(CloudVendor cloudVendor);
    public String updateCloudVendor(CloudVendor cloudVendor);
    public String deleteCloudVendor(String cloudVendorId);
    public CloudVendor getCloudVendor(String cloudVendorId);
    public List<CloudVendor> getCloudVendors();
}

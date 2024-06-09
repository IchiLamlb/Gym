package com.example.ITSSBE.service.impl;

import com.example.ITSSBE.entity.Package;
import com.example.ITSSBE.repository.IPackageRepo;
import com.example.ITSSBE.service.IPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageService implements IPackageService {
    @Autowired
    private IPackageRepo packageRepo;

    public Package addPackage( Package pa){
        pa.set_deleted(false);
        Package savedPackage = packageRepo.save(pa);
        return savedPackage;
    }

    public List<Package> getAllPackages() {
        return packageRepo.findAll();
    }

    public Package getPackage(int id) {
        return packageRepo.findById(id);
    }

    public Package changePackage(int id, Package pa) {
        Package paInDB = packageRepo.findById(id);
        paInDB.setName(pa.getName());
        paInDB.setPrice(pa.getPrice());
        paInDB.setDescription(pa.getDescription());
        return packageRepo.save(paInDB);
    }

    public Package deletePackage(int id) {
        Package pa = packageRepo.findById(id);
        pa.set_deleted(true);
        Package savedPackage = packageRepo.save(pa);
        return savedPackage;
    }
}

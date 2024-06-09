package com.example.ITSSBE.service;

import com.example.ITSSBE.entity.Package;

import java.util.List;

public interface IPackageService {
    Package addPackage(Package pa);
    List<Package> getAllPackages();
    Package getPackage(int id);
    Package changePackage(int id, Package pa);
    Package deletePackage(int id);
}

package com.happytrip.petcargo.dao;

import java.util.List;

import com.happytrip.petcargo.model.Bin;

public interface BinDao {
    public void addBin(Bin bin,int id);
    public List<Bin> searchBin(int categoryId);
    public List<Bin> fetchAllBins();
    public Bin fetchBinById(int binId);
    public void removeBin(Bin bin);
}

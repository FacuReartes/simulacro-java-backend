package com.example.simulacro.servicios;

import com.example.simulacro.entidades.Store;
import com.example.simulacro.repositorios.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    public StoreRepository storeRepository;

    @Override
    public Store add(Store entity) {
        int maxId = storeRepository.getMaxId();
        entity.setStoreId(maxId + 1);
        storeRepository.save(entity);
        return entity;
    }

    @Override
    public Store modify(Store entity) throws NoSuchElementException {
        Store existing = storeRepository.findById((int) entity.getStoreId()).orElseThrow();
        existing.setManagerStaffId(entity.getManagerStaffId());
        storeRepository.save(existing);
        return existing;
    }

    @Override
    public Store delete(int storeId) {
        Store existing = storeRepository.findById(storeId).orElseThrow();
        storeRepository.delete(existing);
        return existing;
    }

    @Override
    public Store findById(int storeId) {
        return storeRepository.findById(storeId).orElseThrow();
    }

    @Override
    public List<Store> findAllByCityId(int cityId) {
        return storeRepository.findAll().stream().filter(store -> store.getAddressId().getCityId() == cityId).collect(Collectors.toList());
    }
}

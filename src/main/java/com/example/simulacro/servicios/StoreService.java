package com.example.simulacro.servicios;

import com.example.simulacro.entidades.Store;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public interface StoreService {

    Store add(Store entity);

    Store modify(Store entity) throws NoSuchElementException;

    Store delete(int storeId);

    Store findById(int storeId);

    List<Store> findAllByCityId(int cityId);
}

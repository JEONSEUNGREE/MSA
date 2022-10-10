package com.example.catalogservice.service;

import com.example.catalogservice.jpa.Catalog;
import com.example.catalogservice.jpa.CatalogRepository;
import org.springframework.stereotype.Service;


@Service
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogRepository;

    public CatalogServiceImpl(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public Iterable<Catalog> getAllCatalogs() {
        return catalogRepository.findAll();
    }
}

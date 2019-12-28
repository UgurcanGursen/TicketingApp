package com.ugurcangursen.ticketingapp.service.impl;

import com.ugurcangursen.ticketingapp.dao.AirlineCompanyDAO;
import com.ugurcangursen.ticketingapp.entity.AirlineCompany;
import com.ugurcangursen.ticketingapp.service.AirlineCompanyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AirlineCompanyServiceImpl implements AirlineCompanyService {

    private AirlineCompanyDAO airlineCompanyDAO;

    public AirlineCompanyServiceImpl(AirlineCompanyDAO airlineCompanyDAO) {
        this.airlineCompanyDAO = airlineCompanyDAO;
    }


    @Override
    @Transactional
    public void save(AirlineCompany airlineCompany) {
        airlineCompanyDAO.save(airlineCompany);

    }

    @Override
    @Transactional
    public List<AirlineCompany> findAll() {
        return airlineCompanyDAO.findAll();
    }

    @Override
    @Transactional
    public AirlineCompany findById(long id) {
        return airlineCompanyDAO.findById(id);
    }

    @Override
    @Transactional
    public AirlineCompany findByName(String name) {
        return airlineCompanyDAO.findByName(name);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        airlineCompanyDAO.deleteById(id);

    }

    @Override
    @Transactional
    public AirlineCompany update(long id, AirlineCompany airlineCompany) {
        return airlineCompanyDAO.update(id,airlineCompany);
    }
}

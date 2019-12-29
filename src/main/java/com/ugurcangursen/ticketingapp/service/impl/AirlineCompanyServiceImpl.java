package com.ugurcangursen.ticketingapp.service.impl;

import com.ugurcangursen.ticketingapp.dao.AirlineCompanyDAO;
import com.ugurcangursen.ticketingapp.dto.AirlineCompanyDto;
import com.ugurcangursen.ticketingapp.entity.AirlineCompany;
import com.ugurcangursen.ticketingapp.service.AirlineCompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class AirlineCompanyServiceImpl implements AirlineCompanyService {

    private final ModelMapper modelMapper;
    private AirlineCompanyDAO airlineCompanyDAO;

    public AirlineCompanyServiceImpl(AirlineCompanyDAO airlineCompanyDAO, ModelMapper modelMapper) {
        this.airlineCompanyDAO = airlineCompanyDAO;
        this.modelMapper = modelMapper;
    }


    @Override
    @Transactional
    public AirlineCompanyDto save(AirlineCompanyDto airlineCompany) {
        if (airlineCompany != null) {
            AirlineCompany airlineCompanyDb = modelMapper.map(airlineCompany, AirlineCompany.class);
            AirlineCompany airlineCompanyDbSaved = airlineCompanyDAO.save(airlineCompanyDb);
            if (airlineCompanyDbSaved != null) {
                return modelMapper.map(airlineCompanyDbSaved, AirlineCompanyDto.class);
            }
        }
        return airlineCompany;
    }

    @Override
    @Transactional
    public AirlineCompanyDto update(long id, AirlineCompanyDto airlineCompany) {
        if (airlineCompany != null) {
            AirlineCompany airlineCompanyDb = modelMapper.map(airlineCompany, AirlineCompany.class);
            AirlineCompany airlineCompanyDbSaved = airlineCompanyDAO.update(id, airlineCompanyDb);
            if (airlineCompanyDbSaved != null) {
                return modelMapper.map(airlineCompanyDbSaved, AirlineCompanyDto.class);
            }
        }
        return airlineCompany;
    }


    @Override
    @Transactional
    public List<AirlineCompanyDto> findAll() {
        List<AirlineCompany> data = airlineCompanyDAO.findAll();
        return Arrays.asList(modelMapper.map(data, AirlineCompanyDto[].class));
    }

    @Override
    @Transactional
    public AirlineCompanyDto findById(long id) {
        AirlineCompany airlineCompanyDb = airlineCompanyDAO.findById(id);
        return modelMapper.map(airlineCompanyDb, AirlineCompanyDto.class);
    }

    @Override
    @Transactional
    public AirlineCompanyDto findByName(String name) {
        AirlineCompany airlineCompanyDb = airlineCompanyDAO.findByName(name);
        return modelMapper.map(airlineCompanyDb, AirlineCompanyDto.class);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        airlineCompanyDAO.deleteById(id);

    }


}

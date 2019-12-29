package com.ugurcangursen.ticketingapp.service.impl;

import com.ugurcangursen.ticketingapp.dao.PlaneDAO;
import com.ugurcangursen.ticketingapp.dto.PlaneDto;
import com.ugurcangursen.ticketingapp.entity.Plane;
import com.ugurcangursen.ticketingapp.service.PlaneService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class PlaneServiceImpl implements PlaneService {

    private final PlaneDAO planeDAO;
    private final ModelMapper modelMapper;

    @Autowired
    public PlaneServiceImpl(PlaneDAO planeDAO, ModelMapper modelMapper) {
        this.planeDAO = planeDAO;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public PlaneDto save(PlaneDto plane) {
        if (plane != null) {
            Plane planeDb = modelMapper.map(plane, Plane.class);
            Plane planeDbSaved = planeDAO.save(planeDb);
            if (planeDbSaved != null) {
                return modelMapper.map(planeDbSaved, PlaneDto.class);
            }
        }
        return plane;
    }

    @Override
    @Transactional
    public List<PlaneDto> findAll() {
        List<Plane> data = planeDAO.findAll();
        return Arrays.asList(modelMapper.map(data, PlaneDto.class));
    }

    @Override
    @Transactional
    public PlaneDto findById(long id) {
        Plane planeDb = planeDAO.findById(id);
        return modelMapper.map(planeDb,PlaneDto.class);
    }

    @Override
    @Transactional
    public PlaneDto findByName(String name) {
        Plane planeDb = planeDAO.findByName(name);
        return modelMapper.map(planeDb,PlaneDto.class);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        planeDAO.deleteById(id);
    }

    @Override
    @Transactional
    public PlaneDto update(long id, PlaneDto plane) {
        if (plane != null) {
            Plane planeDb = modelMapper.map(plane, Plane.class);
            Plane planeDbSaved = planeDAO.update(id,planeDb);
            if (planeDbSaved != null) {
                return modelMapper.map(planeDbSaved, PlaneDto.class);
            }
        }
        return plane;
    }
}

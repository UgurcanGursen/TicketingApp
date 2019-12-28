package com.ugurcangursen.ticketingapp.service.impl;

import com.ugurcangursen.ticketingapp.dao.RouteDAO;
import com.ugurcangursen.ticketingapp.entity.Route;
import com.ugurcangursen.ticketingapp.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    private RouteDAO routeDAO;

    @Autowired
    public RouteServiceImpl(RouteDAO routeDAO) {
        this.routeDAO = routeDAO;
    }

    @Override
    @Transactional
    public void save(Route route) {
        routeDAO.save(route);
    }

    @Override
    @Transactional
    public List<Route> findAll() {
        return routeDAO.findAll();
    }

    @Override
    @Transactional
    public Route findById(long id) {
        return routeDAO.findById(id);
    }

    @Override
    @Transactional
    public Route findByName(String name) {
        return routeDAO.findByName(name);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        routeDAO.deleteById(id);
    }

    @Override
    @Transactional
    public Route update(long id, Route route) {
        return routeDAO.update(id,route);
    }
}

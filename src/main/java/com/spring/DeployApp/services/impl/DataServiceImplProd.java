package com.spring.DeployApp.services.impl;


import com.spring.DeployApp.services.DataService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


@Service
@Profile("prod")
public class DataServiceImplProd implements DataService {

    @Override
    public String getData() {
        return "Prod data";
    }
}

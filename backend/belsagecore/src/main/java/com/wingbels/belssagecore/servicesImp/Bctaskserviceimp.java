package com.wingbels.belssagecore.servicesImp;

import java.util.List;
import java.util.Optional;

import com.wingbels.belssagecore.repositories.filter.TaskSpecifications;
import com.wingbels.belssagecore.servicesImp.request.FilterTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wingbels.belssagecore.entities.Bcemployees;
import com.wingbels.belssagecore.entities.Bctask;
import com.wingbels.belssagecore.repositories.Bctaskrepository;
import com.wingbels.belssagecore.services.Bctaskservice;

@Service
public class Bctaskserviceimp implements Bctaskservice {
    @Autowired
    Bctaskrepository bctaskrepository;

    @Override
    public Bctask save(Bctask bctask) {
        return bctaskrepository.save(bctask);
    }

    @Override
    public void delete(Long idbctask) {
        bctaskrepository.deleteById(idbctask);
    }

    @Override
    public int createTask(Bctask bctask) {
        return save(bctask) != null ? 1 : 2;
    }

    @Override
    public int updateTask(Bctask bctask) {
        return save(bctask) != null ? 1 : 2;
    }

    @Override
    public Optional<Bctask> findtaskbyid(Long idbctask) {
        return bctaskrepository.findByIdtask(idbctask);
    }

    @Override
    public List<Bctask> findall() {
        return bctaskrepository.findAll();
    }

    @Override
    public List<Bctask> findtaskEmp(Bcemployees Emp) {
        return bctaskrepository.findByEmployee(Emp);
    }

    @Override
    public List<Bctask> filterTasks(FilterTask task) {
        return bctaskrepository.findAll(TaskSpecifications.filterTasks(task));
    }
}

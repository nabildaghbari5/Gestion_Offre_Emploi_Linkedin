package com.wingbels.belssagecore.services;

import java.util.List;
import java.util.Optional;

import com.wingbels.belssagecore.servicesImp.request.FilterTask;
import org.springframework.stereotype.Service;
import com.wingbels.belssagecore.entities.Bcemployees;
import com.wingbels.belssagecore.entities.Bctask;

@Service
public interface Bctaskservice {
	public Bctask save(Bctask bctask);
	public void delete(Long idbctask);
	public int createTask(Bctask bctask );
    public int updateTask(Bctask bcTask);
    public Optional<Bctask> findtaskbyid(Long idbctask);
    public List<Bctask> findall();
    public List<Bctask> findtaskEmp(Bcemployees Emp);
    List<Bctask> filterTasks(FilterTask task);
}

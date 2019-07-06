package com.kadyrkuleldos.test_task.service;

import com.kadyrkuleldos.test_task.exception.WealthNotFoundException;
import com.kadyrkuleldos.test_task.models.Wealth;
import com.kadyrkuleldos.test_task.repository.WealthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WealthService {

    private final WealthRepo wealthRepo;

    @Autowired
    public WealthService(WealthRepo repo) {
        this.wealthRepo = repo;
    }
    public List<Wealth> getWealthList()
    {
        return wealthRepo.findAll();
    }

    public void saveWealth(Wealth wealth) {
        if(wealthRepo.existsById((long) wealth.getID())) {
            Wealth wealthFromDB = null;
            try {
                wealthFromDB = wealthRepo.findById(wealth.getID())
                        .orElseThrow(()-> new WealthNotFoundException(String.format("Простите у сотрудника уже есть в наличии такой %s, просим дать другой %s.", wealth.getName_wealth())));
            } catch (WealthNotFoundException e) {
                e.printStackTrace();
            }
            if (wealth.getID() == Integer.parseInt(null)) {
                wealth.setName_wealth(wealthFromDB.getName_wealth());
                wealth.setCategory_wealth(wealthFromDB.getCategory_wealth());
                wealth.setDate_wealth(wealthFromDB.getDate_wealth());
                wealth.setPrice_wealth(wealthFromDB.getPrice_wealth());
                wealth.setEmployee_id(wealthFromDB.getEmployee_id());
            }
        }

        wealthRepo.save(wealth);
    }
}

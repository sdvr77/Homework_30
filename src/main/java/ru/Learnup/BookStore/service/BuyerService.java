package ru.Learnup.BookStore.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.Learnup.BookStore.entity.Buyer;
import ru.Learnup.BookStore.repository.BuyerRepository;

import java.util.List;

@Service
public class BuyerService {

    private final BuyerRepository repository;

    public BuyerService(BuyerRepository repository) {
        this.repository = repository;
    }

    public List<Buyer> getBuyers() {
        return repository.findAll();
    }

    public Buyer findById(int id) {
        return repository.getById(id);
    }

    @Transactional
    public Object save(Buyer buyer) {
        if (buyer.getEmail().contains("@")) {
            repository.save(buyer);
            return buyer;
        } else return "Object was not saved. Field 'email' must contain '@'";
    }

    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}

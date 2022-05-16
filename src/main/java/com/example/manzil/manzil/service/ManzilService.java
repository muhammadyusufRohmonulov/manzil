package com.example.manzil.manzil.service;

import com.example.manzil.manzil.model.Manzil;
import com.example.manzil.manzil.repository.ManzilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManzilService {
    @Autowired
    ManzilRepository manzilRepository;
    public boolean insert2(Manzil manzil){
        Manzil manzil1 = new Manzil();
        manzil1.setViloyat(manzil.getViloyat());
        manzil1.setTuman(manzil.getTuman());
        manzil1.setMahalla(manzil.getMahalla());
        manzilRepository.save(manzil1);
        return false;
    }
    public Manzil view2(Integer id){
        Optional<Manzil> optionalManzil = manzilRepository.findById(id);
        return optionalManzil.orElse(null);
    }
    public String update2(Integer id,Manzil manzil){
        Optional<Manzil> optionalManzil = manzilRepository.findById(id);
        if (optionalManzil.isPresent())
        {
            Manzil manzil1 = optionalManzil.get();
            manzil1.setViloyat(manzil.getViloyat());
            manzil1.setTuman(manzil.getTuman());
            manzil1.setMahalla(manzil.getMahalla());
            manzilRepository.save(manzil1);
            return "Malumot Tahrirlandi";
        }
        return "Malumot Topilmadi";
    }
    public String delete2(Integer id){
        Optional<Manzil> optionalManzil = manzilRepository.findById(id);
        if (optionalManzil.isPresent()){
            manzilRepository.deleteById(id);
            return "Malumot O'chirildi";
        }
        return "Malumot Topilmadi";
    }
    public List<Manzil> sahifalash(Integer sahifaRaqami, Integer satrSoni){
        Pageable pageable = PageRequest.of(sahifaRaqami,satrSoni);
        Page<Manzil> manzilPage = manzilRepository.findAll(pageable);
        return manzilPage.getContent();
    }
}

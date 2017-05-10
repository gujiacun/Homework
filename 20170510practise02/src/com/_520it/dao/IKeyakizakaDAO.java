package com._520it.dao;

import java.util.List;

import com._520it.domain.Keyakizaka;

public interface IKeyakizakaDAO {
    public void add();

    public void delete();

    public void update();

    public Keyakizaka get();

    public List<Keyakizaka> listAll();
}

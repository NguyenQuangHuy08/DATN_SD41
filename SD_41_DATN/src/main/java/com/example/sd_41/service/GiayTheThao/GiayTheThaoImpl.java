package com.example.sd_41.service.GiayTheThao;



import java.util.List;
import java.util.UUID;

import com.example.sd_41.model.GiayTheThao;

public interface GiayTheThaoImpl {
    public List<GiayTheThao> getAll();

    public List<GiayTheThao> getAllWithoutInCTGGCTSP(UUID id);

    public GiayTheThao getOne(UUID id);
}

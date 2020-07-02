package com.codeid.microservices.controllers;

import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;

import com.codeid.microservices.entities.Kontrasepsi;
import com.codeid.microservices.entities.PemakaiKontrasepsi;
import com.codeid.microservices.entities.Provinsi;
import com.codeid.microservices.models.PageableList;
import com.codeid.microservices.models.PemakaiKontrasepsiModel;
import com.codeid.microservices.models.ResponseMessage;
import com.codeid.microservices.services.KontrasepsiService;
import com.codeid.microservices.services.PemakaiKontrasepsiService;
import com.codeid.microservices.services.ProvinsiService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RequestMapping("/pemakai")
@RestController
public class PemakaiKontrasepsiController {

    @Autowired
    private PemakaiKontrasepsiService pemakaiService;

    @Autowired
    private ProvinsiService pService;

    @Autowired
    private KontrasepsiService kService;

    @PostMapping
    public ResponseMessage<PemakaiKontrasepsiModel> add(@RequestBody @Valid PemakaiKontrasepsiModel model) {

        Provinsi provinsi = pService.findById(model.getId());
        Kontrasepsi kontrasepsi = kService.findById(model.getId());

        PemakaiKontrasepsi entity = new PemakaiKontrasepsi(provinsi, kontrasepsi, model.getJumlah());
        pemakaiService.save(entity);

        ModelMapper modelMapper = new ModelMapper();

        PemakaiKontrasepsiModel data = modelMapper.map(entity, PemakaiKontrasepsiModel.class);

        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<PemakaiKontrasepsiModel> edit(@PathVariable Integer id,
            @RequestBody @Valid PemakaiKontrasepsiModel model) {

        ModelMapper modelMapper = new ModelMapper();
        PemakaiKontrasepsi entity = pemakaiService.findById(id);

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.map(model, entity);
        entity.setProvinsi(pService.findById(model.getId()));
        entity.setKontrasepsi(kService.findById(model.getId()));
        entity.setJumlah(model.getJumlah());
        entity = pemakaiService.save(entity);
        PemakaiKontrasepsiModel data = modelMapper.map(entity, PemakaiKontrasepsiModel.class);

        return ResponseMessage.success(data);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<PemakaiKontrasepsiModel> deleteById(@PathVariable Integer id) {
        PemakaiKontrasepsi entity = pemakaiService.deleteById(id);

        ModelMapper modelMapper = new ModelMapper();
        PemakaiKontrasepsiModel data = modelMapper.map(entity, PemakaiKontrasepsiModel.class);

        return ResponseMessage.successDelete(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<PemakaiKontrasepsiModel> findById(@PathVariable Integer id) {
        PemakaiKontrasepsi entity = pemakaiService.findById(id);

        ModelMapper modelMapper = new ModelMapper();
        PemakaiKontrasepsiModel data = modelMapper.map(entity, PemakaiKontrasepsiModel.class);

        return ResponseMessage.success(data);
    }

    @GetMapping
    public ResponseMessage<PageableList<PemakaiKontrasepsiModel>> findAll(
            @RequestParam(required = false) Provinsi provinsi, @RequestParam(defaultValue = "asc") String sort,
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        if (size > 100) {
            size = 100;
        }

        PemakaiKontrasepsi entity = new PemakaiKontrasepsi();
        Sort.Direction direction = Sort.Direction.fromOptionalString(sort.toUpperCase()).orElse(Sort.Direction.ASC);
        Page<PemakaiKontrasepsi> pagePemakaiKontrasepsis = pemakaiService.findAll(entity, page, size, direction);
        List<PemakaiKontrasepsi> stocks = pagePemakaiKontrasepsis.toList();

        ModelMapper modelMapper = new ModelMapper();
        Type type = new TypeToken<List<PemakaiKontrasepsiModel>>() {
        }.getType();
        List<PemakaiKontrasepsiModel> stockModels = modelMapper.map(stocks, type);

        PageableList<PemakaiKontrasepsiModel> data = new PageableList<PemakaiKontrasepsiModel>(stockModels,
                pagePemakaiKontrasepsis.getNumber(), pagePemakaiKontrasepsis.getSize(),
                pagePemakaiKontrasepsis.getTotalElements());
        return ResponseMessage.success(data);
    }

}
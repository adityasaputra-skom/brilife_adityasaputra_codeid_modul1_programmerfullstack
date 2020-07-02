package com.codeid.microservices.controllers;

import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;

import com.codeid.microservices.entities.Provinsi;
import com.codeid.microservices.models.PageableList;
import com.codeid.microservices.models.ProvinsiModel;
import com.codeid.microservices.models.ResponseMessage;
import com.codeid.microservices.services.ProvinsiService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Validated
@RequestMapping("/provinsi")
@RestController
@Api(value = "items", description = "Controller for Provinsi", tags = {"Provinsi"})
public class ProvinsiController {

    @Autowired
    private ProvinsiService pService;

    @PostMapping
    public ResponseMessage<ProvinsiModel> add(@RequestBody @Valid ProvinsiModel model) {
        Provinsi entity = pService.save(new Provinsi(model.getName()));

        ModelMapper modelMapper = new ModelMapper();
        ProvinsiModel data = modelMapper.map(entity, ProvinsiModel.class);

        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<ProvinsiModel> edit(@PathVariable Integer id, @RequestBody @Valid ProvinsiModel model) {
        ModelMapper modelMapper = new ModelMapper();
        model.setId(id);

        Provinsi entity = pService.findById(id);
        modelMapper.map(model, entity);
        entity = pService.save(entity);

        ProvinsiModel data = modelMapper.map(entity, ProvinsiModel.class);

        return ResponseMessage.success(data);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<ProvinsiModel> deleteById(@PathVariable Integer id) {
        Provinsi entity = pService.deleteById(id);

        ModelMapper modelMapper = new ModelMapper();
        ProvinsiModel data = modelMapper.map(entity, ProvinsiModel.class);

        return ResponseMessage.success(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<ProvinsiModel> findById(@PathVariable Integer id) {
        Provinsi entity = pService.findById(id);
        
        ModelMapper modelMapper = new ModelMapper();
        ProvinsiModel data = modelMapper.map(entity, ProvinsiModel.class);

        return ResponseMessage.success(data);
    }

    @ApiOperation(value = "Find All Provinsi")
    @ApiResponses({
        @ApiResponse(code = 404, message = "This is response")
    })
    @GetMapping
    public ResponseMessage<PageableList<ProvinsiModel>> findAll(
            @RequestParam(required = false) String name, 
            @RequestParam(defaultValue = "asc") String sort, 
            @RequestParam(defaultValue = "0") int page, 
            @RequestParam(defaultValue = "10") int size
        ) {

        if (size > 100) {
            size = 100;
        }

        Provinsi entity = new Provinsi(name);
        Sort.Direction direction = Sort.Direction.fromOptionalString(sort.toUpperCase()).orElse(Sort.Direction.ASC);
        Page<Provinsi> pageItems = pService.findAll(entity, page, size, direction);
        List<Provinsi> items = pageItems.toList();

        ModelMapper modelMapper = new ModelMapper();
        Type type = new TypeToken<List<ProvinsiModel>>() {}.getType();
        List<ProvinsiModel> itemModels = modelMapper.map(items, type);

        PageableList<ProvinsiModel> data = new PageableList<ProvinsiModel>(itemModels, 
                pageItems.getNumber(), pageItems.getSize(), pageItems.getTotalElements());
        return ResponseMessage.success(data);
    }
}
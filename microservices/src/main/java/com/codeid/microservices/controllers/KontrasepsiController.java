package com.codeid.microservices.controllers;

import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;

import com.codeid.microservices.entities.Kontrasepsi;
import com.codeid.microservices.models.KontrasepsiModel;
import com.codeid.microservices.models.PageableList;
import com.codeid.microservices.models.ResponseMessage;
import com.codeid.microservices.services.KontrasepsiService;

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
@RequestMapping("/kontrasepsi")
@RestController
@Api(value = "items", description = "Controller for Kontrasepsi", tags = {"Kontrasepsi"})
public class KontrasepsiController {

    @Autowired
    private KontrasepsiService kService;

    @PostMapping
    public ResponseMessage<KontrasepsiModel> add(@RequestBody @Valid KontrasepsiModel model) {
        Kontrasepsi entity = kService.save(new Kontrasepsi(model.getName()));

        ModelMapper modelMapper = new ModelMapper();
        KontrasepsiModel data = modelMapper.map(entity, KontrasepsiModel.class);

        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<KontrasepsiModel> edit(@PathVariable Integer id, @RequestBody @Valid KontrasepsiModel model) {
        ModelMapper modelMapper = new ModelMapper();
        model.setId(id);

        Kontrasepsi entity = kService.findById(id);
        modelMapper.map(model, entity);
        entity = kService.save(entity);

        KontrasepsiModel data = modelMapper.map(entity, KontrasepsiModel.class);

        return ResponseMessage.success(data);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<KontrasepsiModel> deleteById(@PathVariable Integer id) {
        Kontrasepsi entity = kService.deleteById(id);

        ModelMapper modelMapper = new ModelMapper();
        KontrasepsiModel data = modelMapper.map(entity, KontrasepsiModel.class);

        return ResponseMessage.success(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<KontrasepsiModel> findById(@PathVariable Integer id) {
        Kontrasepsi entity = kService.findById(id);
        
        ModelMapper modelMapper = new ModelMapper();
        KontrasepsiModel data = modelMapper.map(entity, KontrasepsiModel.class);

        return ResponseMessage.success(data);
    }

    @ApiOperation(value = "Find All Kontrasepsi")
    @ApiResponses({
        @ApiResponse(code = 404, message = "This is response")
    })
    @GetMapping
    public ResponseMessage<PageableList<KontrasepsiModel>> findAll(
            @RequestParam(required = false) String name, 
            @RequestParam(defaultValue = "asc") String sort, 
            @RequestParam(defaultValue = "0") int page, 
            @RequestParam(defaultValue = "10") int size
        ) {

        if (size > 100) {
            size = 100;
        }

        Kontrasepsi entity = new Kontrasepsi(name);
        Sort.Direction direction = Sort.Direction.fromOptionalString(sort.toUpperCase()).orElse(Sort.Direction.ASC);
        Page<Kontrasepsi> pageItems = kService.findAll(entity, page, size, direction);
        List<Kontrasepsi> items = pageItems.toList();

        ModelMapper modelMapper = new ModelMapper();
        Type type = new TypeToken<List<KontrasepsiModel>>() {}.getType();
        List<KontrasepsiModel> itemModels = modelMapper.map(items, type);

        PageableList<KontrasepsiModel> data = new PageableList<KontrasepsiModel>(itemModels, 
                pageItems.getNumber(), pageItems.getSize(), pageItems.getTotalElements());
        return ResponseMessage.success(data);
    }
}
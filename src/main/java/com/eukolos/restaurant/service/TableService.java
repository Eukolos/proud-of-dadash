package com.eukolos.restaurant.service;

import com.eukolos.restaurant.dto.AllTableResponse;
import com.eukolos.restaurant.dto.AllTableResponseConverter;
import com.eukolos.restaurant.model.Table;
import com.eukolos.restaurant.repository.TableRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TableService {
    private final TableRepository repository;
    private final AllTableResponseConverter allTableResponseConverter;

    public TableService(TableRepository repository, AllTableResponseConverter allTableResponseConverter) {
        this.repository = repository;
        this.allTableResponseConverter = allTableResponseConverter;
    }

    public List<AllTableResponse> getAllTable(){
        List<Table> tableList = repository.findAll();

        List<AllTableResponse> Response = tableList.stream().map(allTableResponseConverter::convert).collect(Collectors.toList());
        return Response;

    }



 //   public TableResponse getTableById(String id) {return null }




}

package com.eukolos.restaurant.controler;

import com.eukolos.restaurant.dto.AllTableResponse;
import com.eukolos.restaurant.model.Table;
import com.eukolos.restaurant.service.TableService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/req")
public class TableController {
    private final TableService service;

    public TableController(TableService service) {
        this.service = service;
    }
    @GetMapping
    public List<AllTableResponse> getAllTable() {
        return service.getAllTable();
    }

    @PostMapping("/create/{createAccountByTableNumberRequest}")
    public Table postAccountOnTable(@PathVariable int createAccountByTableNumberRequest){
       return service.createAccountOnTable(createAccountByTableNumberRequest);
    }

}
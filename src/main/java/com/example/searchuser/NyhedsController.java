package com.example.searchuser;

import com.example.searchuser.Model.Nyhed;
import com.example.searchuser.service.Nyheder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NyhedsController {
    private Nyheder nyheder = new Nyheder(); // vores "database"
    @PostMapping("api/nyheder")
    public ResponseEntity<Nyheder> getSearchResult(){
        System.out.println("api/nyheder kaldet med " );
        return ResponseEntity.ok(nyheder);
    }
    @PostMapping("api/opretnyhed")
    public ResponseEntity<Nyheder> opretNyhed(@RequestBody Nyhed nyhed){// tilføj parameter
        System.out.println("api/nyheder kaldet med " );
        nyheder.tilfoejNyhed(nyhed.nyheden);

        return ResponseEntity.ok(nyheder);
    }
}
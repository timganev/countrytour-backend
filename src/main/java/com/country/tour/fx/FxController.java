package com.country.tour.fx;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fx")
public class FxController {

  @Autowired
  private FxRepository fxRepository;


//TODO get rates  http://data.fixer.io/api/latest?access_key=62a07267d78d80b5c5cc109268183aef


  @GetMapping
  public Iterable<FxEntity> getAll() {
    return fxRepository.findAll();
  }

  @PostMapping
  public ResponseEntity<List<FxEntity>> saveAll(@RequestBody RatesDTO request) {

    List<FxEntity> list = new ArrayList<>();

    request.getRates().forEach((k,v) ->{
      FxEntity entity = new FxEntity(k,v);
      list.add(entity);
    });
    fxRepository.saveAll(list);

    return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
        .body(list);
  }




}

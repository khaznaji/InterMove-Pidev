package com.example.intermove.Controllers.Accomodation;

import com.example.intermove.Entities.Accomodation.House;
import com.example.intermove.Services.Accomodation.IAccomodationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Houses Management")
@RestController
@RequestMapping("/Houses")
public class HouseController {
    @Autowired
    IAccomodationService accomodationService;

    @GetMapping("/AllHouses")
    @ResponseBody
    public List<House> getAllHouses() {
        return accomodationService.getAllHouses();
    }

    @PostMapping("/addHouse/{idAgency}")
    @ResponseBody
    public int addAgent(@RequestBody House house, @PathVariable("idAgency") int id) {

        return accomodationService.addHouses(house, id);
    }


    @PutMapping("/updateHouse")
    @ResponseBody
    public House updateHouse(@RequestBody House house) {
        return accomodationService.updateHouses(house);
    }


    @DeleteMapping("/deleteHouse/{id}")
    @ResponseBody
    public void deleteAgency(@PathVariable("id") int id) {
        accomodationService.deleteHouse(id);
    }

    @GetMapping("/getHouseById/{id}")
    @ResponseBody
    public House getHouseById(@PathVariable("id") int id) {
        return accomodationService.getHouseById(id);
    }
}

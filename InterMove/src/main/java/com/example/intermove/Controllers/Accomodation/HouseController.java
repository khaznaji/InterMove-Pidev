package com.example.intermove.Controllers.Accomodation;

import com.example.intermove.Entities.Accomodation.House;
import com.example.intermove.Entities.Accomodation.Image;
import com.example.intermove.Entities.Accomodation.TypeHouses;
import com.example.intermove.Repositories.Accomodation.ImageRepository;
import com.example.intermove.Services.Accomodation.IAccomodationService;
import com.example.intermove.Utils.ImageUtility;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Tag(name = "Houses Management")
@RestController
@RequestMapping("/Houses")
public class HouseController {
    @Autowired
    IAccomodationService accomodationService;
    @Autowired
    ImageRepository imageRepository;

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

    @GetMapping(value = {"/SearchHouse"})
    @ResponseBody
    public List<House> findHouse(@RequestParam(required = false) String country,@RequestParam(required = false) String region
            ,@RequestParam(required = false) Boolean available
            ,@RequestParam(required = false) TypeHouses typeHouses
            ,@RequestParam(required = false) Integer Loyer){
        return accomodationService.findByCountryAndRegion(country,region,available,typeHouses,Loyer);
    }
    @PostMapping("/upload/image")
    public ResponseEntity<ImageUploadResponse> uplaodImage(@RequestParam("image") MultipartFile file)
            throws IOException {

        imageRepository.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(ImageUtility.compressImage(file.getBytes())).build());
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ImageUploadResponse("Image uploaded successfully: " +
                        file.getOriginalFilename()));
    }
    @GetMapping(path = {"/get/image/{name}"})
    public ResponseEntity<byte[]> getImage(@PathVariable("name") String name) throws IOException {

        final Optional<Image> dbImage = imageRepository.findByName(name);

        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(dbImage.get().getType()))
                .body(ImageUtility.decompressImage(dbImage.get().getImage()));
    }
}

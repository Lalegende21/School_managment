package SchoolManagment.controller;

import SchoolManagment.entity.Serie;
import SchoolManagment.serviceImpl.SerieServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "serie")
public class SerieController {

    private final SerieServiceImpl serieService;

    public SerieController(SerieServiceImpl serieService) {
        this.serieService = serieService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void Create(@RequestBody Serie serie) {
        this.serieService.saveSerie(serie);
        log.info("Serie enregistre avec succes !");
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<Serie> getAllSerie() {
        return this.serieService.getAllSerie();
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "{id}")
    public Serie getAdmin(@PathVariable String id) {
        return this.serieService.getSerie(id);
    }


    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping(path = "{id}")
    public void updateSerie(@PathVariable String id, @RequestBody Serie serie) {
        this.serieService.updateSerie(id, serie);
        log.info("Mise a jour effectuee avec succes !");
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteAllAdmin() {
        this.serieService.deleteSerie();
        log.info("Toutes les series ont ete supprimees avec succes !");
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @DeleteMapping(path = "{id}")
    public void deleteAdmin(@PathVariable String id) {
        this.serieService.deleteSerieByid(id);
        log.info("Serie supprime avec succes !");
    }
}

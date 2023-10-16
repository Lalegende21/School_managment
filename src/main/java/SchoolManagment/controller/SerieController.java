package SchoolManagment.controller;

import SchoolManagment.dto.SerieDTO;
import SchoolManagment.entity.Serie;
import SchoolManagment.model.SerieMapper;
import SchoolManagment.serviceImpl.SerieServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping(path = "serie")
public class SerieController {

    private final SerieServiceImpl serieService;
    private final SerieMapper serieMapper;

    public SerieController(SerieServiceImpl serieService, SerieMapper serieMapper) {
        this.serieMapper = serieMapper;
        this.serieService = serieService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void Create(@RequestBody SerieDTO serieDTO) {
        Serie serie = serieMapper.mapDTOToSerie(serieDTO);
        this.serieService.saveSerie(serie);
        log.info("Serie enregistre avec succes !");
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<SerieDTO> getAllSerie() {
        List<Serie> series = this.serieService.getAllSerie();
        return series.stream()
                .map(serie -> serieMapper.mapSerieToDto(serie))
                .collect(Collectors.toList());
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "{id}")
    public SerieDTO getAdmin(@PathVariable String id) {
        Serie serie = this.serieService.getSerie(id);

        SerieDTO serieDTO = serieMapper.mapSerieToDto(serie);
        return serieDTO;
    }


    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping(path = "{id}")
    public void updateSerie(@PathVariable String id, @RequestBody SerieDTO serieDTO) {
        Serie serie = serieMapper.mapDTOToSerie(serieDTO);
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

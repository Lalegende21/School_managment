package SchoolManagment.controller;

import SchoolManagment.dto.SerieDTO;
import SchoolManagment.entity.Serie;
import SchoolManagment.model.SerieMapper;
import SchoolManagment.serviceImpl.SeriesServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(path = "series")
public class SeriesController {

    private final SeriesServiceImpl seriesService;
    private final SerieMapper serieMapper;



    //Method to save series
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public String Create(@RequestBody SerieDTO serieDTO) {
        Serie serie = serieMapper.mapDTOToSerie(serieDTO);
        this.seriesService.saveSeries(serie);
        return "Series register successfully!";
    }



    //Method to read all series
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<SerieDTO> getAllSeries() {
        List<Serie> series = this.seriesService.getAllSeries();
        return series.stream()
                .map(serie -> serieMapper.mapSerieToDto(serie))
                .collect(Collectors.toList());
    }



    //Method to read series by id
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "{id}")
    public SerieDTO getAdmin(@PathVariable String id) {
        Serie serie = this.seriesService.getSeries(id);

        SerieDTO serieDTO = serieMapper.mapSerieToDto(serie);
        return serieDTO;
    }



    //Method to update series
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping(path = "{id}")
    public String updateSeries(@PathVariable String id, @RequestBody SerieDTO serieDTO) {
        Serie serie = serieMapper.mapDTOToSerie(serieDTO);
        this.seriesService.updateSeries(id, serie);
        return "Update complete successfully!";
    }



    //Method to delete all series
    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping
    public String deleteAllAdmin() {
        this.seriesService.deleteSeries();
        return "All series delete successfully!";
    }



    //Method to delete series
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @DeleteMapping(path = "{id}")
    public String deleteAdmin(@PathVariable String id) {
        this.seriesService.deleteSeriesById(id);
        return "Series delete successfully!";
    }
}

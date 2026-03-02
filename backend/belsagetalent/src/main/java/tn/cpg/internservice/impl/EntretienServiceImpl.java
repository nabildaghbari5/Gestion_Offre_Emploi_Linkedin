package tn.cpg.internservice.impl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.cpg.internservice.dto.EntretienDto;
import tn.cpg.internservice.exception.NotFoundException;
import tn.cpg.internservice.mapper.EntretienMapper;
import tn.cpg.internservice.model.Announcement;
import tn.cpg.internservice.model.Entretien;
import tn.cpg.internservice.model.Request;
import tn.cpg.internservice.repository.EntretienRepository;
import tn.cpg.internservice.repository.RequestRespository;
import tn.cpg.internservice.service.EntretienService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EntretienServiceImpl  implements EntretienService {

     private final EntretienRepository entretienRepository ;
     private final EntretienMapper entretienMapper ;
     private final RequestRespository requestRespository ;

    private Entretien save(Entretien entity) {
        return entretienRepository.save(entity);
    }

    @Override
    public EntretienDto create(EntretienDto dto ) {
         Entretien entretien = entretienMapper.toENTITY(dto);
         entretien.setDate(dto.getDate());
         entretien.setStatus("Planifié");
        if (dto.getRequest() != null && dto.getRequest().getAnnouncement() != null) {
            String title = dto.getRequest().getAnnouncement().getTitle();
        }
        entretien.setRequest(dto.getRequest());
        return entretienMapper.toDTO(
                save(entretien)
            );
    }

    @Override
    public EntretienDto update(Integer id, EntretienDto dto) throws NotFoundException {
        Optional<Entretien> optional = entretienRepository.findById(id);
        if(optional.isEmpty())
            throw new NotFoundException("Service not found");
        Entretien existing = optional.get();
        entretienMapper.partialUpdate(existing, dto);
        return entretienMapper.toDTO(save(existing));
    }
    @Override
    public EntretienDto findById(Integer id) throws NotFoundException {
        Optional<Entretien> optional = entretienRepository.findById(id);
        if(optional.isEmpty())
            throw new NotFoundException("Service not found");
        return entretienMapper.toDTO(optional.get());
    }
    @Override
    public List<EntretienDto> findAll() {
        return entretienRepository.findAll()
                .stream()
                .map(entretienMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Page<EntretienDto> findPage(int pageSize, int pageNumber) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        return entretienRepository.findAll(page)
                .map(entretienMapper::toDTO);
    }
    @Override
    public void delete(Integer id) throws NotFoundException {

        if(!entretienRepository.existsById(id)) {
            throw new NotFoundException("Service not found");
        }
        entretienRepository.deleteById(id);
    }




}

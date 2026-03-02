package tn.cpg.internservice.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import tn.cpg.internservice.dto.AnnouncementDto;
import tn.cpg.internservice.exception.NotFoundException;
import tn.cpg.internservice.mapper.AnnouncementMapper;
import tn.cpg.internservice.model.Announcement;
import tn.cpg.internservice.repository.AnnouncementRepository;
import tn.cpg.internservice.service.AnnouncementService;

@Service
@AllArgsConstructor
@Slf4j
public class AnnouncementServiceImpl  implements  AnnouncementService {

	private AnnouncementRepository announcementRepository ; 
	private AnnouncementMapper announcementMapper ;
	private final LinkedInService linkedInService;
	private Announcement save(Announcement entity) {
		return announcementRepository.save(entity);
	}

	@Override
	@Transactional
	public AnnouncementDto create(AnnouncementDto dto) {
		log.info("Création d'une nouvelle annonce: {}", dto.getTitle());

		// Conversion du DTO en entité
		Announcement announcement = announcementMapper.toENTITY(dto);

		// Sauvegarde initiale de l'annonce
		Announcement savedAnnouncement = save(announcement);
		log.info("Annonce sauvegardée avec l'ID: {}", savedAnnouncement.getId());

		// Vérification et publication sur LinkedIn si demandé
		if (dto.isPublishToLinkedIn()) {
			try {
				log.info("Tentative de publication sur LinkedIn");
				String linkedInPostId = linkedInService.publishJobToLinkedIn(savedAnnouncement);

				// Mise à jour de l'annonce avec l'ID du post LinkedIn
				savedAnnouncement.setLinkedInPostId(linkedInPostId);
				savedAnnouncement = save(savedAnnouncement);
				log.info("Annonce publiée sur LinkedIn avec l'ID: {}", linkedInPostId);

			} catch (LinkedInService.LinkedInPublicationException e) {
				log.error("Erreur lors de la publication sur LinkedIn: {}", e.getMessage());
				// Optionnel: relancer l'exception ou gérer l'erreur
			}
		}

		// Conversion et retour du DTO
		return announcementMapper.toDTO(savedAnnouncement);
	}




	@Override
	public AnnouncementDto update(Integer id, AnnouncementDto dto) throws NotFoundException {
		Optional<Announcement> optional = announcementRepository.findById(id);
		if(optional.isEmpty())
			throw new NotFoundException("Service not found");
		Announcement existing = optional.get();
		announcementMapper.partialUpdate(existing, dto);
		return announcementMapper.toDTO(save(existing));
	}
	@Override
	public AnnouncementDto findById(Integer id) throws NotFoundException {
		Optional<Announcement> optional = announcementRepository.findById(id);
		if(optional.isEmpty())
			throw new NotFoundException("Service not found");
		return announcementMapper.toDTO(optional.get());
	}
	@Override
	public List<AnnouncementDto> findAll() {
		return announcementRepository.findAll()
				.stream()
				.map(announcementMapper::toDTO)
				.collect(Collectors.toList());
	}

	public Page<AnnouncementDto> findPage(int pageSize, int pageNumber) {
		Pageable page = PageRequest.of(pageNumber, pageSize);
		return announcementRepository.findAll(page)
				.map(announcementMapper::toDTO);
	}
	@Override
	public void delete(Integer id) throws NotFoundException {

		if(!announcementRepository.existsById(id)) {
			throw new NotFoundException("Service not found");
		}
		
		announcementRepository.deleteById(id);
	}
	
	
	
	
}
